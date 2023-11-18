package lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		super();
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course result = null;
		int maxCourseStudent = 0;
		for (Course course : courses) {
			if (course.sameType("Practical") && course.getNumberStudents() > maxCourseStudent) {
				maxCourseStudent = course.getNumberStudents();
				result = course;
			}
		}
		return result;
	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> map = new HashMap<>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				int year = student.getYear();
				if (!map.containsKey(year)) {
					ArrayList<Student> students = new ArrayList<>();
					students.add(student);
					map.put(year, students);
				} else {
					map.get(year).add(student);
				}
			}
		}
		return map;
	}
	public Set<Course> filterCourses(String type) {
		return null;
	}
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("S001", "John Doe", 2022));
		students.add(new Student("S002", "Alice Smith", 2021));
		students.add(new Student("S003", "Bob Johnson", 2022));

		List<Student> students2 = new ArrayList<Student>();
		students2.add(new Student("S004", "Emma Williams", 2022));
		students2.add(new Student("S005", "Daniel Chang", 2023));
		students2.add(new Student("S006", "Sophia Rodriguez", 2021));
		students2.add(new Student("S007", "Taylor Swift", 2020));

		List<Student> students3 = new ArrayList<Student>();
		students3.add(new Student("S008", "Michael Lee", 2022));
		students3.add(new Student("S009", "Olivia Davis", 2023));
		students3.add(new Student("S010", "Ava Johnson", 2021));
		students3.add(new Student("S011", "Liam Kim", 2020));
		students3.add(new Student("S012", "Ethan Martinez", 2023));

		List<Course> courses = new ArrayList<Course>();
		courses.add(new Course("WD101", "Web Development Fundamentals", "Practical", students, " Dr. Sarah Webber"));
		courses.add(new Course("DS201", "Introduction to Data Science", "Theory", students2, "Prof. James Datafield"));
		courses.add(new Course("AI301", "Artificial Intelligence Applications", "Practical", students3, "Dr. Alex RoboMind"));

		Faculty faculty = new Faculty("Information Technology", "Nong Lam University", courses);

		System.out.println("Max practical course: " + faculty.getMaxPracticalCourse().getTitle());
		System.out.println();
		System.out.println("Sort list student by year: ");
		Map<Integer, List<Student>> map = faculty.groupStudentsByYear();
		for (Integer year : map.keySet()) {
			System.out.print("Year " + year + ": " + "\t");
			for (Student student : map.get(year)) {
				System.out.print(student.getName() + "\t" + " || " + "\t");
			}
			System.out.println();
		}
		System.out.println("Filter courses: " + faculty.filterCourses("Web Development Fundamentals"));
	}
}