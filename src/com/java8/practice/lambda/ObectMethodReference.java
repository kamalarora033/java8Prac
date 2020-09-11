package com.java8.practice.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ObectMethodReference {
	
	public static void main(String[] args) {
		List<Integer> weights = Arrays.asList(7,1,4,8);
		List<Apple> map = map(weights, Apple::new);
		System.out.println(map);
	}
	
	public static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f){
		List<Apple> apples = new ArrayList<>();
		for(Integer weight : weights) {
			apples.add(f.apply(weight));
		}
		return apples;
	}

	
}
class Apple{
	public Apple() {
		
	}
	public Apple(Integer weight) {
		
	}
}
