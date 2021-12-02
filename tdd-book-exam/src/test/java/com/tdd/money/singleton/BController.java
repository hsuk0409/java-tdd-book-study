package com.tdd.money.singleton;

public class BController {

    public BController() {
        System.out.println(AService.getInstance().hashCode());
    }
}
