package com.java8.practice.streams;

import java.util.Arrays;
import java.util.List;

public class UniqueElements {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 4, 4, 2);
		numbers.stream().filter(i -> {
			System.out.println("in filter");
			return i % 2 == 0;
		}).distinct().forEach(System.out::println);
	}

}
