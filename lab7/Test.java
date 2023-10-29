package lab7;

import java.io.IOException;

import java.util.Comparator;

public class Test {
	public static void main(String[] args) throws IOException {

		Clazz clazz = new Clazz("Test", "2023");
		clazz.loadStudents("D:\\Code\\Exercise\\CTDL\\src\\lab7\\students.txt");
		System.out.println("Test method get top N student");
		for (Student s : clazz.getTopNStudents(2)) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("Test method get random N student");
		for (Student s : clazz.getRandomNStudents(2)) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("Test method remove student");
		clazz.removeStudent("18130024"); 
		clazz.display();
		System.out.println();
		
		System.out.println("Test method get all student in a given birth year");
		for(Student s : clazz.getStudentByBirthYear(1998)) {
			System.out.println(s);
		}
	}
}