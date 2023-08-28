package com.wqh.service;

/**
 * @author ASUS
 */
public interface BankService {
    boolean transfer(String from, String to, int amount);
}
