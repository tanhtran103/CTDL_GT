package lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookManagement {
	private List<Publication> library;

	public BookManagement(List<Publication> library) {
		this.library = library;
	}

	public String checkTypeList(Publication other) {
		return other.checkType(other);
	}

	// Method calculate total cost
	public double totalCost(List<Publication> library) {
		double total = 0;
		for (Publication publication : library) {
			total += publication.getPrice();
		}
		return total;
	}

	// Method check the reference book has the most pages in chapter
	public ReferenceBook highestPagesInChapter(List<Publication> library) {
		ReferenceBook highestPagesRFBook = null;
		int maxPages = 0;
		for (Publication publication : library) {
			if (publication instanceof ReferenceBook) {
				ReferenceBook listReferenceBook = (ReferenceBook) publication;
				if (listReferenceBook.getHighestPages() > maxPages) {
					highestPagesRFBook = listReferenceBook;
					maxPages = listReferenceBook.getHighestPages();
				}
			}
		}
		return highestPagesRFBook;
	}

	// Method check if a magazine with the given name
	public static boolean checkMagazine(List<Publication> library, String tenTapChi) {
		for (Publication publication : library) {
			if (publication instanceof Magazine && ((Magazine) publication).getMagazineName().equals(tenTapChi)) {
				return true;
			}
		}
		return false;
	}

	// Method retrieve a list of publication published in a given year
	public List<Publication> retrieveListOfPublication(int year) {
		List<Publication> magazineGivenYear = new ArrayList<>();
		for (Publication publication : library) {
			if (publication.isSameYearPublish(year)) {
				magazineGivenYear.add(publication);
			}
		}
		return magazineGivenYear;
	}

	// Method statistics the number of publication publish by year
	public Map<Integer, Integer> statisticalPublicationByYear(List<Publication> library) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Publication p : library) {
			int number = map.getOrDefault(p.getPublishYear(), 0);
			map.put(p.getPublishYear(), number+1);
		}
		return map;
	}
	public static void main(String[] args) {
		// List chapter
		List<Chapter> chapterBook1 = new ArrayList<Chapter>();
		Chapter chapter1A = new Chapter("Introduction", 60);
		Chapter chapter1B = new Chapter("Chapter 1: Basics", 70);
		Chapter chapter1C = new Chapter("Chapter 2: Advanced Concepts", 90);

		chapterBook1.add(chapter1A);
		chapterBook1.add(chapter1B);
		chapterBook1.add(chapter1C);

		List<Chapter> chapterBook2 = new ArrayList<Chapter>();
		Chapter chapter2A = new Chapter("Introduction", 80);
		Chapter chapter2B = new Chapter("Atomic Structure", 90);
		Chapter chapter2C = new Chapter("Chemical Reactions", 120);
		chapterBook2.add(chapter2A);
		chapterBook2.add(chapter2B);
		chapterBook2.add(chapter2C);

		// List reference book
		ReferenceBook referenceBook1 = new ReferenceBook("Java Programming", 300, 2022, "Tech Publications", 29.99,
				"Computer Science", chapterBook1);

		ReferenceBook referenceBook2 = new ReferenceBook("Chemistry Essentials", 250, 2021, "Science Publishers", 25.00,
				"Chemistry", chapterBook2);

		// List magazine
		Magazine mg1 = new Magazine("Magazine 1", 100, 2021, "ABC Publications", 15.99, "Science Today");
		Magazine mg2 = new Magazine("Magazine 2", 120, 2010, "Health Publications Ltd.", 19.95, "Artistic Expressions");
		Magazine mg3 = new Magazine("Magazine 3", 80, 2022, "XYZ Media", 12.50, "Health & Wellness");
		Magazine mg4 = new Magazine("Magazine 4", 90, 2023, "Tech World Press", 18.00, "Tech Innovations");
		
		// Add to library
		List<Publication> library = new ArrayList<Publication>();
		library.add(mg1);
		library.add(mg2);
		library.add(mg3);
		library.add(mg4);
		library.add(referenceBook1);
		library.add(referenceBook2);
		Collections.sort(library);
		// Test case
		BookManagement bookList = new BookManagement(library);
		System.out.println(bookList.checkTypeList(mg1));
		System.out.println(bookList.checkTypeList(referenceBook1));
		System.out.println();
		System.out.println("Check if magazine 1 is same type and author to magazine 4: " + mg1.isSameTypeAndAuthor(mg4));
		System.out.println();
		System.out.println("Check if magazine 1 is publish 10 years ago: " + mg2.isPublish10YearsAgo());
		System.out.println();
		System.out.println("Total cost " + bookList.totalCost(library));
		System.out.println();
		System.out.println("Reference book has the most pages in a chapter: " + bookList.highestPagesInChapter(library));
		System.out.println();
		System.out.println("Check if the book list has the magazine with the given name: "+ bookList.checkMagazine(library, "Science Today"));
		System.out.println();
		System.out.println("Retrieve a list of magazine with given year: " + bookList.retrieveListOfPublication(2022));
		System.out.println();
		System.out.println("List publication after arrange by title: ");
		for (Publication p : library) {
			System.out.println("- " + p.getName());
		}
		System.out.println();
		System.out.println("Statistical the number of publication publish by year");
		System.out.println(bookList.statisticalPublicationByYear(library));
	}
}
