package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(10,29,91,88,1,6,73,22,65);
		// if the val is less than 25 then add 10 to it
		intList.stream().filter(val -> val < 25).map(val -> val + 10).collect(Collectors.toList()).forEach(System.out::println);
	}

}
