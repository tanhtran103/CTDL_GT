package lab9;

public class Chapter {
	private String title;
	private int numberOfPages;
	public Chapter(String title, int numberOfPages) {
		super();
		this.title = title;
		this.numberOfPages = numberOfPages;
	}
	public int getNumberPages() {
		return this.numberOfPages;
	}
	@Override
	public String toString() {
		return "Chapter [title=" + title + ", numberOfPages=" + numberOfPages + "]";
	}
}
