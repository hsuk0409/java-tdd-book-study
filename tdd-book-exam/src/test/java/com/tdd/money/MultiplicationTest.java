package com.tdd.money;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicationTest {

    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertNotEquals(Money.dollar(5), Money.dollar(6));
        assertNotEquals(Money.franc(5), Money.dollar(5));
    }

    @Test
    public void testCurrency() {
        assertEquals(Currency.USD, Money.dollar(1).currency());
        assertEquals(Currency.CHF, Money.franc(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, Currency.USD);
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }

    @Test
    public void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, Currency.USD);
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), Currency.USD);
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate(Currency.CHF, Currency.USD, 2);
        Money result = bank.reduce(Money.franc(2), Currency.USD);
    }

    @Test
    public void testArrayEquals() {
        assertArrayEquals(new Object[] {"abc"}, new Object[] {"abc"});
    }

    @Test
    public void testIdentityRate() {
        assertEquals(1, new Bank().rate(Currency.USD, Currency.USD));
    }

    @Test
    public void testMixedAddition() {
        Expression fiveBuckets = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate(Currency.CHF, Currency.USD, 2);

        Money result = bank.reduce(fiveBuckets.plus(tenFrancs), Currency.USD);
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testSumPlusMoney() {
        Expression fiveBuckets = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate(Currency.CHF, Currency.USD, 2);

        Expression sum = new Sum(fiveBuckets, tenFranc).plus(fiveBuckets);
        Money result = bank.reduce(sum, Currency.USD);
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes() {
        Expression fiveBuckets = Money.dollar(5);
        Expression tenFranc = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate(Currency.CHF, Currency.USD, 2);

        Expression sum = new Sum(fiveBuckets, tenFranc).times(2);
        Money result = bank.reduce(sum, Currency.USD);
        assertEquals(Money.dollar(20), result);
    }
}
