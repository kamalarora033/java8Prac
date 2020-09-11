package com.java8.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("Hello", "World");
		// List<Stream<String>> collect = words.stream().map(w ->
		// w.split("")).map(Arrays::stream)
		// .collect(Collectors.toList());

		List<String> listOfCharacters = words.stream().map(w -> w.split("")).flatMap(Arrays::stream).distinct()
				.collect(Collectors.toList());
		System.out.println(listOfCharacters);

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> squareNumbers = numbers.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println(squareNumbers);

		List<Integer> numbers1 = Arrays.asList(1, 2, 3);
		List<Integer> numbers2 = Arrays.asList(3, 4);

		List<int[]> pairs = numbers1.stream()
				.flatMap(i -> numbers2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[] { i, j }))
				.collect(Collectors.toList());
		for (int[] pair : pairs) {
			System.out.println(Arrays.toString(pair));
		}
	}

}
