package main.code.chapter3;

import main.code.chapter2.BankTransaction;

public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
