package com.tdd.money;

public class Money implements Expression {

    int amount;
    Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Money reduce(Bank bank, Currency to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }

    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    static Money dollar(int amount) {
        return new Money(amount, Currency.USD);
    }

    static Money franc(int amount) {
        return new Money(amount, Currency.CHF);
    }

    public Currency currency() {
        return this.currency;
    }

    public boolean equals(Object object) {
        Money money = (Money) object;

        return amount == money.amount && currency() == money.currency;
    }

    public String toString() {
        return amount + "  " + currency;
    }
}
