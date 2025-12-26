package org.ds.array.medium;
import java.util.*;

public class InvalidTransactions {
    public List<String> invalidTransactions(final String[] transactions) {
        final List<String> invalid = new ArrayList<>();
	    final Map<String, List<Transaction>> map = new HashMap<>();

        for (final String transaction : transactions) {
            final Transaction tran = new Transaction(transaction);

            if (map.containsKey(tran.name)){
                map.get(tran.name).add(tran);
            } else {
                List<Transaction> list = new ArrayList<>();
                list.add(tran);
                map.put(tran.name, list);
            }
        }
        for (final String transaction : transactions) {
			final Transaction tran = new Transaction(transaction);

			if (!isValid(map.get(tran.name), tran)) {
				invalid.add(transaction);
			}

		}

		return invalid;
    }

    public boolean isValid(final List<Transaction> transactions, final Transaction transaction){
        if (transactions.size() <= 1 && transaction.amount < 1000){
            return true;
        }

        for (final Transaction tran: transactions) {
            if (transaction.invalidTransactions(tran.city,tran.time 0)){
                return false;
            }
        }
        return true;
    }
}

class Transaction{
    String name;
    String city;
    int time;
    int amount;

    public Transaction(String sentence){
        String[] arr = sentence.split(",");
        this.name = arr[0];
        this.city = arr[3];
        this.time = Integer.parseInt(arr[1]);
        this.amount = Integer.parseInt(arr[2]);
    }

    public boolean invalidTransactions(final String city, final int time) {
        return invalidAmount() || differentCity(city, time);
    }

    private boolean differentCity(final String city, final int time){
        return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
    }

    private boolean invalidAmount(){
        return this.amount > 1000;
    }
}
