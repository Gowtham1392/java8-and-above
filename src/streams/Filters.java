package streams;

import java.util.Arrays;
import java.util.List;

public class Filters {

	public static void main(String[] args) {
		String[] str = new String[] {"Tokyo", "London", "Sydney", "New York", "Moscow", "Singapore"};
		List<String> list = Arrays.asList(str);
		list.stream().filter(s -> s.length() > 6).forEach(System.out::println);
	}

}
