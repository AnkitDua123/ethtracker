package com.demo.ethtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;

@Service
public class EthereumService {

    private final Web3j web3j;

    @Autowired
    public EthereumService(Web3j web3j) {
        this.web3j = web3j;
    }

    public Web3j getWeb3j() {
        return web3j;
    }
}