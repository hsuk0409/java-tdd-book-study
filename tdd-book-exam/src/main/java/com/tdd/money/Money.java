package com.tdd.money;

public class Money implements Expression {

    int amount;
    String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    public Money reduce(String to) {
        return this;
    }

    public Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public String currency() {
        return this.currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;

        return amount == money.amount && currency().equals(money.currency);
    }

    public String toString() {
        return amount + "  " + currency;
    }
}
