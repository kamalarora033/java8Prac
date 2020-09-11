package com.java8.practice.streams.numeric;

import java.util.stream.IntStream;

public class NumericRanges {
	public static void main(String[] args) {
		IntStream intRange = IntStream.range(1, 100).filter(n -> n % 2 == 0);
		System.out.println(intRange.count());
		IntStream intRangeClosed = IntStream.rangeClosed(1, 100).filter(n -> n % 2 == 0);
		System.out.println(intRangeClosed.count());
	}

}
