package com.java8.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindingAndMatching {
	public static void main(String[] args) {
		List<Dish> menus = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
		
		if(menus.stream().anyMatch(Dish::isVegetarian)) {
			System.out.println("vegeterian dish");
		}
		System.out.println(menus.stream().allMatch(d -> d.getCalories() < 1000));
		
		Optional<Dish> findAnyDish = menus.stream().filter(Dish::isVegetarian).findAny();
		System.out.println(findAnyDish.get());
		
		List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
		Optional<Integer> findFirst = someNumbers.stream().map(n -> n*n).filter(n -> n%3==0).findFirst();
		if(findFirst.isPresent()) {
			System.out.println(findFirst.get());
		}
	}

}
