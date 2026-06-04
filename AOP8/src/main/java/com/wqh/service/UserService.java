package com.wqh.service;

public interface UserService {
    String login(String userName, String password);

    String register(String userName, String password);
}
