package model;

public class Grade {
	//1. mainigie
	private long gID;
	private int grValue;
	private Student student;
	private Course course;
	
	private static long counter = 30000;
	//2. getters
	public long getgID() {
		return gID;
	}
	public int getGrValue() {
		return grValue;
	}
	public Student getStudent() {
		return student;
	}
	public Course getCourse() {
		return course;
	}
		

	//3. setters
	
	public void setGID() {
		gID = counter++;
	}
	
	public void setGrValue(int inputGrValue) {
		if(inputGrValue > 0 && inputGrValue <=10) {
			grValue = inputGrValue;
		}
		else
		{
			grValue = 0;
		}
	}
	
	public void setStudent(Student inputStudent) {
		if(inputStudent != null) {
			student = inputStudent;
		}
		else
		{
			student = new Student();
		}
	}
	
	public void setCourse(Course inputCourse) {
		if(inputCourse != null) {
			course = inputCourse;
		}
		else
		{
			course = new Course();
		}
	}
	
	//4. noklusetais konstruktors
	public Grade() {
		setGID();
		setGrValue(0);
		setStudent(new Student());
		setCourse(new Course());
	}
	//5. argumenta konstruktors
	public Grade(int inputGrValue, Student inputStudent, Course inputCourse) {
		setGID();
		setGrValue(inputGrValue);
		setStudent(inputStudent);
		setCourse(inputCourse);
	}
	//6. toString
	public String toString() {
		return gID + ": " + grValue + " (" + course.getTitle() + ") -> " 
				+ student.getName().charAt(0) + ". " + student.getSurname();  
	}
	//7. citas funkcijas (ja nepieciešams)

}
