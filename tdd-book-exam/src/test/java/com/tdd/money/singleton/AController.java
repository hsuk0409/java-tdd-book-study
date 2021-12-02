package com.tdd.money.singleton;

public class AController {

    public AController() {
        System.out.println(AService.getInstance().hashCode());
    }
}
