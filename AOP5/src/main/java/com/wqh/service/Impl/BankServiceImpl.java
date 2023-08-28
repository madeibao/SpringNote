package com.wqh.service.Impl;

import com.wqh.service.BankService;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    public boolean transfer(String from, String to, int amount) {
        if(amount < 1){
            throw new IllegalArgumentException("transfer amount must be a positive number");
        }
        System.out.println("["+from+"]向["+to+"]转账金额"+amount);
        return false;
    }
}
