package com.demo.ethtracker.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@Configuration
public class Web3JConfig {

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService("https://eth-mainnet.g.alchemy.com/v2/demo"));
    }
}