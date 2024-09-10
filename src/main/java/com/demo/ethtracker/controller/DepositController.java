package com.demo.ethtracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.demo.ethtracker.entity.Deposit;
import com.demo.ethtracker.repository.DepositRepository;

import java.util.List;

@RestController
public class DepositController {

    @Autowired
    private DepositRepository depositRepository;

    @GetMapping("/deposits")
    public List<Deposit> getAllDeposits() {
        return depositRepository.findAll();
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook() {
        System.out.println("Received webhook data: ");

        return ResponseEntity.ok("Webhook received");
    }
}