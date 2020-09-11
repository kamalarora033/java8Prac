package com.java8.practice.streams.transactions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionSolution {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		// Find all transactions in 2011 and sort by value (small to high)
		List<Transaction> transactionOf2011 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		transactionOf2011.stream().forEach(System.out::println);

		// What are all the unique cities where the traders work
		List<String> cities = transactions.stream().map(t -> t.getTrader().getCity()).distinct()
				.collect(Collectors.toList());
		cities.stream().forEach(System.out::println);

		// Find all traders from Cambridge and sort them by name
		List<Trader> traders = transactions.stream().map(Transaction::getTrader)
				.filter(t -> t.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName))
				.collect(Collectors.toList());
		System.out.println(traders);

		// Return a string of all traders’ names sorted alphabetically
		String tradersName = transactions.stream().map(t -> t.getTrader().getName()).distinct()
				.reduce("", (a, b) -> a + " " + b).trim();
		System.out.println(tradersName);

		// Are any traders based in Milan?
		boolean anyMatch = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
		System.out.println(anyMatch);

		// Print all transactions’ values from the traders living in Cambridge
		List<Integer> transactValues = transactions.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue).distinct().collect(Collectors.toList());
		transactValues.stream().forEach(System.out::println);

		// What’s the highest value of all the transactions?
		// 1st way
		Optional<Integer> max = transactions.stream().max(Comparator.comparing(Transaction::getValue))
				.map(Transaction::getValue);
		// 2nd way
		Optional<Integer> reduce = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(reduce.get());

		// Find the transaction with the smallest value
		// 1st way
		Optional<Integer> min = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
		// 2nd ways
		Optional<Transaction> minWithReduce = transactions.stream()
				.reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(minWithReduce.get().getValue());
		System.out.println(min.get());
		
		
	}
}
