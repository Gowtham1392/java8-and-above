package java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFunction {

	public static void main(String[] args) {
		
		// Convert String to upper case
		String[] cities = new String[] {"Sydney", "Tokyo", "London", "New York"};
		List<String> cityList = Arrays.asList(cities);
		cityList.stream().map(String::toUpperCase).collect(Collectors.toList())
		.forEach(System.out::println);
		
		// Applying multiplication on list of Integers if it's less than 10
		List<Integer> numbers = Arrays.asList(3,4,8,10,81,88,16);
		numbers.stream().filter(number -> number < 10).map(num -> num * 10)
		.collect(Collectors.toList()).forEach(System.out::println);
	}

}
