package com.java8.practice.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MethodReference {

	public static void main(String[] args) {
		List<String> strList = Arrays.asList("s","b","a","d");
		
//		strList.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
		strList.sort(String::compareToIgnoreCase);
		System.out.println(strList);
		
		String s = "10";
		Function<String, Integer> strToInteger = Integer::parseInt;
		System.out.println(strToInteger.apply(s));
	}
}
