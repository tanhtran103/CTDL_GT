package lab7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Clazz {
	private String name;
	private String year;// 2017, 2018, 2019, ...
	private ArrayList<Student> students = new ArrayList<Student>();

	public Clazz(String name, String year) {
		this.name = name;
		this.year = year;
	}

	public void loadStudents(String fileName) throws IOException {
		this.students = StudentUtils.loadStudents(fileName);
	}

	// sort students according to the given comparator c
	public void sortStudents(Comparator<Student> c) {
		// TODO
	}

	// get top n students with highest GPA
	public ArrayList<Student> getTopNStudents(int n) {

		if (n > students.size()) {
			return null;
		}
		ArrayList<Student> result = new ArrayList<>();
		ArrayList<Student> highGPA = (ArrayList<Student>) students.clone();
		Comparator<Student> gpaComparator = (Student i, Student j) -> {
			if (i.getGPA() < j.getGPA()) {
				return 1;
			}
			return -1;
		};
		highGPA.sort(gpaComparator);
		for (int i = 0; i < n; i++) {
			result.add(highGPA.get(i));
		}
		return result;
	}

	// get random n students from the list of students
	public ArrayList<Student> getRandomNStudents(int n) {
		if (n > students.size()) {
			return null;
		}
		ArrayList<Student> result = new ArrayList<>();
		ArrayList<Student> randomStudent = (ArrayList<Student>) students.clone();
		for (int i = 0; i < n; i++) {
			int random = (int) (Math.random() * randomStudent.size());
			result.add(randomStudent.get(random));
		}
		return result;
	}

// remove a student with a given id
	public boolean removeStudent(String id) {
		for (Student s : students) {
			if (s.compareID(id)) {
				students.remove(s);
				return true;
			}
		}
		return false;
	}

	// get all students who were born in a given birth year.
	public ArrayList<Student> getStudentByBirthYear(int birthYear) {
		ArrayList<Student> result = new ArrayList<>();
		for (Student s : students) {
			if (s.compareBirthYear(birthYear)) {
				result.add(s);
			}
		}
		return result;
	}

	// similar as toString method, this method prints the name, year, and all
	// students of the class. Note that, using iterator
	public void display() {
		System.out.println("Name: " + name + " year: " + year);
		for (Student s : students) {
			System.out.println(s);
		}
	}
}
