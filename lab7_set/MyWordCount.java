package lab7_set;

import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "D:\\Code\\Exercise\\CTDL\\src\\lab7_set\\data\\fit.txt";
	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Returns a set of WordCount objects that represents the number of times each
	// unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		// TODO
		List<WordCount> result = new ArrayList<WordCount>();
		for (String w : words) {
			WordCount wc = new WordCount(w, countWord(w));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}
		return result;
	}

	private int countWord(String w) {
		int count = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).equals(w))
				count++;
		}
		return count;
	}

	// Returns the words that their appearances are 1, do not consider
	// duplidated words
	public Set<String> getUniqueWords() {
		// TODO
		Set<String> result = new HashSet<>();
		List<WordCount> list = getWordCounts();
		for (WordCount wc : list) {
			if (wc.getCount() == 1) {
				result.add(wc.getWord());
			}
		}
		return result;
	}
	// Returns the words in the text file, duplicated words appear once in the
	// result

	public Set<String> getDistinctWords() {
		// TODO
		Set<String> result = new HashSet<>();
		List<WordCount> list = getWordCounts();
		for (WordCount wc : list) {
			if (wc.getCount() == 2) {
				result.add(wc.getWord());
			}
		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of
	// tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> exportWordCounts() {
		// TODO
		Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				if (o1.getCount() - o2.getCount() == 0)
					return o1.getWord().compareTo(o2.getWord());
				return o1.getCount() - o2.getCount();
			}
		});
		for (String w : words) {
			WordCount wc = new WordCount(w, countWord(w));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}
		return result;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsOrderByOccurence() {
		// TODO
		Set<WordCount> result = new TreeSet<>(new Comparator<WordCount>() {
			@Override
			public int compare(WordCount o1, WordCount o2) {
				if (o1.getCount() - o2.getCount() == 0)
					return o1.getWord().compareTo(o2.getWord());
				return o2.getCount() - o1.getCount();
			}
		});
		for (String w : words) {
			WordCount wc = new WordCount(w, countWord(w));
			if (!result.contains(wc)) {
				result.add(wc);
			}
		}
		return result;
	}

	// delete words beginning with the given pattern (i.e., delete words begin
	// with 'A' letter
	public Set<WordCount> filterWords(String pattern) {
		// TODO
		Set<WordCount> result = new HashSet<>();
		for (String w : words) {
			WordCount wc = new WordCount(w, countWord(w));
			if (!w.startsWith(pattern)) {
				result.add(wc);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		MyWordCount wordCount = new MyWordCount();
		List<WordCount> list = wordCount.getWordCounts();
		System.out.println("Count all words appear in the file");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println();
		System.out.println("Get Unique Words: ");
		for (String w : wordCount.getUniqueWords()) {
			System.out.println(w);
		}
		System.out.println();
		System.out.println("Get Distinct Words: ");
		for (String w : wordCount.getDistinctWords()) {
			System.out.println(w);
		}
		System.out.println();
		System.out.println("Export Words Count: ");
		for (WordCount w : wordCount.exportWordCounts()) {
			System.out.println(w);
		}
		System.out.println();
		System.out.println("Export Words Count Order By Occurence: ");
		for (WordCount w : wordCount.exportWordCountsOrderByOccurence()) {
			System.out.println(w);
		}
		System.out.println();
		System.out.println("Filter Words: ");
		for (WordCount w : wordCount.filterWords("D")) {
			System.out.println(w);
		}
	}
}
