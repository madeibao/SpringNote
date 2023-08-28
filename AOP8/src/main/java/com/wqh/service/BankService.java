package com.wqh.service;

public interface BankService {
    boolean transfer(String from, String to, int amount);
}
