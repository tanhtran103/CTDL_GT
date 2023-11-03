package lab7_set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which p.test(obj)
	// is true. (This does the same thing as coll.removeIf(p).)
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		// TODO
		Iterator<T> itr = coll.iterator();
		while (itr.hasNext()) {
			T next = itr.next();
			if (p.test(next)) {
				itr.remove();
			}
		}
	}

	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> itr = coll.iterator();
		while (itr.hasNext()) {
			T next = itr.next();
			if (!p.test(next)) {
				itr.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		// TODO
		Set<T> result = new HashSet<>();
		Iterator<T> itr = coll.iterator();
		while (itr.hasNext()) {
			T next = itr.next();
			if (p.test(next)) {
				result.add(next);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		// TODO
		int index = 0;
		Iterator<T> itr = coll.iterator();
		while (itr.hasNext()) {
			T next = itr.next();
			if (p.test(next)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	public static void main(String[] args) {
		Even even = new Even();
		Predicate<Integer> isEven = n -> even.test(n);

		// Test method remove
		List<Integer> listNum = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 4, 8, 9, 1));
		MyPredicates.remove(listNum, isEven);
		System.out.println(listNum);
		System.out.println();

		// Test method retain
		List<Integer> listNum2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 4, 8, 9, 1));
		MyPredicates.retain(listNum2, isEven);
		System.out.println(listNum2);
		System.out.println();

		// Test method collect
		List<Integer> listNum3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 4, 8, 9, 1));
		Set<Integer> print = MyPredicates.collect(listNum3, isEven);
		System.out.println(print);
		System.out.println();

		// Test method find
		List<Integer> listNum4 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 4, 8, 9, 1));
		int number = MyPredicates.find(listNum4, isEven);
		System.out.println(number);
	}
}
