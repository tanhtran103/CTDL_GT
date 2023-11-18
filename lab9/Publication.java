package lab9;

public abstract class Publication implements Comparable<Publication> {
	private String title;
	private int numberOfPages;
	private int yearOfPublish;
	private String author;
	private double price;
	public Publication(String title, int numberOfPages, int yearOfPublish, String author, double price) {
		this.title = title;
		this.numberOfPages = numberOfPages;
		this.yearOfPublish = yearOfPublish;
		this.author = author;
		this.price = price;
	}
	public String getTitle() {
		return this.title;
	}
	public int getPublishYear() {
		return this.yearOfPublish;
	}
	public double getPrice() {
		return this.price;
	}
	public String getName() {
		return this.author;
	}
	public abstract String checkType(Publication other);
	public boolean isSameTypeAndAuthor(Publication other) {
		return this.getClass() == other.getClass() && this.author.equals(other.author);
	}
	public boolean isPublish10YearsAgo() {
        return (2021 - this.getPublishYear() >= 10);
    }
	public boolean isSameYearPublish(int year) {
		return this.yearOfPublish == year;
	}
	public int compareTo(Publication p) {
		return this.author.compareTo(p.author);
	}
	public String toString() {
		return "Publication [title=" + title + ", numberOfPages=" + numberOfPages + ", yearOfPublish=" + yearOfPublish
				+ ", author=" + author + ", price=" + price + "]";
	}
}
