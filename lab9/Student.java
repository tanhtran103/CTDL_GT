package lab9;

public class Student {
	private String id;
	private String name;
	private int year;
	public Student(String id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}
	public String getName() {
		return this.name;
	}
	public int getYear() {
		return this.year;
	}
}
