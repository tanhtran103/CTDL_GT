package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "D:\\Code\\Exercise\\CTDL\\src\\lab8\\data\\fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() {
		// TODO
		Scanner input;
		try {
			input = new Scanner(new File(fileName));

			while (input.hasNext()) {
				String word = input.next();
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Returns the number of distinct tokens in the file data/hamlet.txt or
	// fit.txt
	public int countDistinct() {
		// TODO
		Set<String> result = new HashSet<>();
		Iterator<String> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			result.add(itr.next());
		}
		return result.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		for (String word : map.keySet()) {
		    System.out.println(word + map.get(word));
		}
		// TODO
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of
	// tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		Map<String, Integer> sortedMap = new HashMap<>();
		sortedMap.putAll(map);      
		for (String word : sortedMap.keySet()) {
		    System.out.println(word + map.get(word));
		}
	}

	public static void main(String[] args) {
		MyWordCountApp myWC = new MyWordCountApp();
		myWC.loadData();
		System.out.println("Number of distinct words: " + myWC.countDistinct());
		try {
			myWC.printWordCounts();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Print word counts alphabet: ");myWC.printWordCountsAlphabet();
	}
}
