package com.java8.practice.streams.numeric;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.java8.practice.streams.Dish;

public class NumericStreamExample {
	public static void main(String[] args) {
		List<Dish> menus = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
		int sumOfCalories = menus.stream().mapToInt(Dish::getCalories).sum();
		System.out.println("sumOfCalories " + sumOfCalories);

		IntStream mapToInt = menus.stream().mapToInt(Dish::getCalories);
		Stream<Integer> intStream = mapToInt.boxed();
		intStream.forEach(System.out::println);

		OptionalInt max = menus.stream().mapToInt(Dish::getCalories).max();
		int maxCalories = max.orElse(0);
		System.out.println(maxCalories);
	}

}
