package com.tdd.money;

public class Pair {
    private Currency from;
    private Currency to;

    public Pair(Currency from, Currency to) {
        this.from = from;
        this.to = to;
    }

    public boolean equals(Object object) {
        Pair pair = (Pair) object;
        return from == pair.from && to == pair.to;
    }

    public int hashCode() {
        return 0;
    }
}
