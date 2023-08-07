package java8.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurrences {

	public static void main(String[] args) {
		System.out.println("Enter the String");
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		CountOccurrences c = new CountOccurrences();
		char [] charArray = input.toCharArray();
		Map<Character, Integer> output = c.beforeJava8(charArray);
		for(Map.Entry<Character, Integer> entry : output.entrySet()) {
			System.out.println("Char->"+entry.getKey()+" Occ->"+entry.getValue());
		}
		// Java 8 Approach
		System.out.println("--------Java 8 Approach----");
		Map<String, Long> Java8Streams = c.afterJava8(input);
		Java8Streams.forEach((key, value) -> System.out.println("Char->"+key+" occ->"+value));
		sc.close();
		
		//find the repeated characters in a String
		System.out.println("------------Repeated Characters-------------");
		Set<String> repeatedChars = c.findRepeated(input);
		repeatedChars.forEach(System.out::println);
	}
	
	 Map<Character, Integer> beforeJava8(char[] input) {
		Map<Character, Integer> result = new HashMap<Character, Integer>();
		for(int i = 0; i < input.length; i++) {
			if(!result.containsKey(input[i])) {
				result.put(input[i], 1);
			}
			else {
				result.put(input[i], result.get(input[i]) + 1);
			}
		}
		return result;
	}
	Map<String, Long> afterJava8(String input) {
		return Arrays.stream(input.split(""))
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
	
	Set<String> findRepeated(String input){
		Set<String> items = new HashSet<String>();
		Stream<String> stream = Arrays.stream(input.split(""));
		return stream.filter(item -> !items.add(item)).collect(Collectors.toSet());
		
	}
	
}
