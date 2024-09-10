package com.demo.ethtracker.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthBlock;

import com.demo.ethtracker.entity.Deposit;
import com.demo.ethtracker.repository.DepositRepository;

@Service
public class DepositTrackingService {

    private static final String BEACON_DEPOSIT_CONTRACT_ADDRESS = "0x00000000219ab540356cBB839Cbe05303d7705Fa";

    @Autowired
    private EthereumService ethereumService;

    @Autowired
    private DepositRepository depositRepository;

    @Scheduled(fixedDelay = 6000) // Polling every 60 seconds
    public void trackDeposits() {
        try {
            Web3j web3j = ethereumService.getWeb3j();

            // Fetch latest block
            EthBlock latestBlock = web3j.ethGetBlockByNumber(DefaultBlockParameterName.LATEST, true).send();

            // Extract and save deposit details
            if (latestBlock.getBlock() != null) {
                EthBlock.Block block = latestBlock.getBlock();
                block.getTransactions().forEach(tx -> {
                    // Implement logic to parse and identify relevant deposits
                    Deposit deposit = new Deposit();
                    deposit.setBlockNumber(block.getNumber());
                    deposit.setBlockTimestamp(block.getTimestamp().longValue());
                    // deposit.setHash(tx.get().getHash());
                    // deposit.setFee(tx.get().getGasPrice()); 
                    depositRepository.save(deposit);
                });
            }
        } catch (Exception e) {
            System.err.println("Error tracking deposits: " + e.getMessage());
        }
    }
}