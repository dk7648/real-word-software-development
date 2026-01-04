package main.code.chapter3;

import main.code.chapter2.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumlator, BankTransaction bankTransaction);
}
