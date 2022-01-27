package com.yuva.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
1169. Invalid Transactions
A transaction is possibly invalid if:
	the amount exceeds $1000, or;
	if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
	
You are given an array of strings transaction where transactions[i] consists of comma-separated values
 representing the name, time (in minutes), amount, and city of the transaction.

Return a list of transactions that are possibly invalid. You may return the answer in any order.

 

Example 1:
Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, 
have the same name and is in a different city. Similarly the second one is invalid too.

Example 2:
Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]

Example 3:
Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]

 * @author Yuvaraja Kanagarajan
 *
 */
public class InvalidTransactions {

	public List<String> invalidTransactions(String[] transactions) {
		// map transaction name to all transactions with that name
		Map<String, List<String[]>> map = new HashMap<>();

		for (String currTransaction : transactions) {
			String[] splitTransaction = currTransaction.split(",");
			map.putIfAbsent(splitTransaction[0], new ArrayList<>()); // add list for the name if it doesn't exist
			map.get(splitTransaction[0]).add(splitTransaction); // add current transaction to appropriate list
		}

		List<String> result = new ArrayList<>();

		// every loop checks if the currTransaction is invalid
		for (String currTransaction : transactions) {
			String[] currSplitTransaction = currTransaction.split(",");

			if (Integer.parseInt(currSplitTransaction[2]) > 1000) {
				result.add(currTransaction);
			} else {
				// iterate through all transactions with the same name, check if within 60
				// minutes and different city
				for (String[] curr : map.get(currSplitTransaction[0])) {

					if (Math.abs(Integer.parseInt(currSplitTransaction[1]) - Integer.parseInt(curr[1])) <= 60  // with in 60 mins
							&& !currSplitTransaction[3].equals(curr[3])) { // different city
						result.add(currTransaction);
						break;
					}
				}

			}

		}

		return result;
	}

	
	public List<String> invalidTransactions1(final String[] transactions) {
		final List<String> invalid = new ArrayList<>();
		final Map<String, List<Transaction>> map = new HashMap<>();

		/*
		 * build a map with name as key and value as list of transactions for that name
		 */
		for (final String transaction : transactions) {
			final Transaction tran = new Transaction(transaction);

			if (map.containsKey(tran.name)) {
				map.get(tran.name).add(tran);
			} else {
				final List<Transaction> list = new ArrayList<>();
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

	public boolean isValid(final List<Transaction> transactions, final Transaction transaction) {

		/* if there is only one transaction and the amount is less than 1000 */
		if (transactions.size() <= 1 && transaction.amount < 1000)
			return true;

		/* check against all other transaction to check it this one is valid */
		for (final Transaction tran : transactions) {
			if (transaction.invalidTransaction(tran.city, tran.time)) {
				return false;
			}
		}
		return true;
	}

	class Transaction {
		String name;
		int time;
		int amount;
		String city;

		Transaction(final String transaction) {
			final String[] t = transaction.split(",");
			this.name = t[0];
			this.time = Integer.parseInt(t[1]);
			this.amount = Integer.parseInt(t[2]);
			this.city = t[3];
		}

		/*
		 * the amount exceeds $1000, or;
		 * 
		 * if it occurs within (and including) 60 minutes of another transaction with
		 * the same name in a different city. Each transaction string transactions[i]
		 * consists of comma separated values representing the name, time (in minutes),
		 * amount, and city of the transaction.
		 */
		public boolean invalidTransaction(final String city, final int time) {
			return invalidAmount() || differentCity(city, time);
		}

		private boolean differentCity(final String city, final int time) {
			return !this.city.equals(city) && Math.abs(this.time - time) <= 60;
		}

		private boolean invalidAmount() {
			return this.amount > 1000;
		}
	}
	
}
