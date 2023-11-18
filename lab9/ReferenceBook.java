package lab9;

import java.util.List;

public class ReferenceBook extends Publication {
	private String field;
	private List<Chapter> chapters;
	public ReferenceBook(String title, int numberOfPages, int yearOfPublish, 
			String author, double price, String field, List<Chapter> chapters) {
		
		super(title, numberOfPages, yearOfPublish, author, price);
		// TODO Auto-generated constructor stub
		this.field = field;
		this.chapters = chapters;
	}
	public List<Chapter> getChapter() {
		return this.chapters;
	}
	public String checkType(Publication other) {
		if(other.getClass().equals(this.getClass())) {
			return "Reference Book";
		}
		return "Magazine";
	}
	public int getHighestPages() {
		int max = 0;
		for(Chapter chapter : chapters) {
			if (chapter.getNumberPages() > max) {
				max = chapter.getNumberPages();
			}
		}
		return max;
	}
	public String toString() {
		return "ReferenceBook [field=" + field + ", chapters=" + chapters + "]";
	}
}
