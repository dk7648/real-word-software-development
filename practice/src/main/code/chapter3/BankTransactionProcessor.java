package main.code.chapter3;


import main.code.chapter2.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankTransactionProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0;
        for(final BankTransaction bankTransaction: bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
    }


    public double calculateTotalInCategory(final String category) {
        double total = 0;
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransactionFilter.test(bankTransaction)) {
                bankTransactions.add(bankTransaction);
            }
        }
        return bankTransactions;
    }

    public List<BankTransaction> findTransactionsGraterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }

    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        final List<BankTransaction> result = new ArrayList<>();
        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }
}
