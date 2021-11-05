package com.tdd.money;

import java.util.Hashtable;

public class Bank {
    private Hashtable rates = new Hashtable();

    public Money reduce(Expression source, Currency to) {
        return source.reduce(this, to);
    }

    public int rate(Currency from, Currency to) {
        if (from == to) return 1;
        return (int) rates.get(new Pair(from, to));
    }

    public void addRate(Currency from, Currency to, int rate) {
        rates.put(new Pair(from, to), rate);
    }
}
