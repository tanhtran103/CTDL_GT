package lab9;
import java.util.List;

public class Course {
	private String id;
	private String title;
	private String type;
	private List<Student> students;
	private String lecturer;
	public Course(String id, String title, String type, List<Student> students, String lecturer) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.students = students;
		this.lecturer = lecturer;
	}
	public boolean sameType(String type) {
		return this.type.equals(type);
	}
	public int getNumberStudents() {
		return this.students.size();
	}
	public String getTitle() {
		return this.title;
	}
	public List<Student> getStudents() {
		return this.students;
	}

}
