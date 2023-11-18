package lab9;

public class Magazine extends Publication {
	private String magazineName;
	public Magazine(String title, int numberOfPages, int yearOfPublish, String author, double price, String magazineName) {
		super(title, numberOfPages, yearOfPublish, author, price);
		// TODO Auto-generated constructor stub
		this.magazineName = magazineName;
	}
	public String getMagazineName() {
		return this.magazineName;
	}
	public String checkType(Publication other) {
		if(other.getClass().equals(this.getClass())) {
			return "Magazine";
		}
		return "Reference Book";
	}
	public String toString() {
		return "Magazine [magazineName=" + magazineName + "]";
	}
}
