package homework_Lesson22;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Homework_Lesson23 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// String input = sc.nextLine();

		String input = "His name is Slim Shady";
		
		String inputToUpper = input.toUpperCase();

		TreeMap<Character, Integer> map = new TreeMap<>();

		for (int i = 0; i < inputToUpper.length(); i++) {
			char letter = inputToUpper.charAt(i); 
			if (letter != ' ') {
				if (!map.containsKey(letter)) {
					map.put(letter, 1);
				} else {					 
					map.put(letter, map.get(letter) + 1);		
				}
			} 
		}
		
		TreeSet<Counter> set = new TreeSet<>();
		for (Entry<Character, Integer> e : map.entrySet()) {			
			set.add(new Counter(e.getValue(), e.getKey()));			
		}
		int maxCounter = Collections.min(set).getCounter();		
		for (Counter counter : set) {
			System.out.println(counter.getLetter() + ": " + counter.getCounter() + " " + counter.printSymbol(maxCounter));
		}		 
	}	 
}
