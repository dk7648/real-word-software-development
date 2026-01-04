package main.code.chapter3;

import main.code.chapter2.BankTransaction;

import java.time.Month;

public class BankTransactionIsInFebruaryAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }
}
