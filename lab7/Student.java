package lab7;

import java.util.ArrayList;

public class Student {
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double GPA;

	public Student(String id, String firstName, String lastName, int birthYear, double GPA) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.GPA = GPA;
	}
	public String getID() {
		return id;
	}
	public String getFName() {
		return firstName;
	}
	public String getLName() {
		return lastName;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public double getGPA() {
		return GPA;
	}
	public boolean compareBirthYear(int otherBirthYear) {
		return this.birthYear == otherBirthYear;
	}
	public boolean compareID(String otherID) {
		return this.id.equals(otherID);
	}
	@Override
	public String toString() {
		return "Student id: " + id + ", First name: " + firstName + ", last name: " + lastName + ", birth year: " + birthYear
				+ ", GPA: " + GPA;
	}
	
}
