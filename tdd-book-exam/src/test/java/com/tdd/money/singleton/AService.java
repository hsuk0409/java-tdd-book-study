package com.tdd.money.singleton;

public class AService {
    private static final AService instance = new AService();

    public static AService getInstance() {
        return instance;
    }
}
