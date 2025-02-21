package model;

public class Course {
	//1. mainigie
	private long cID;
	private String title;
	private int creditPoints;
	private Professor professor;
	
	private static long counter = 20000;

	//2. getters
	public long getcID() {
		return cID;
	}

	public String getTitle() {
		return title;
	}

	public int getCreditPoints() {
		return creditPoints;
	}

	public Professor getProfessor() {
		return professor;
	}
	
	//3. setters
	public void setCID() {
		cID = counter++;
	}
	
	public void setTitle(String inputTitle) {
		if(inputTitle != null && inputTitle.matches("[A-Za-z ]{4,20}"))
		{
			title = inputTitle;
		}
		else
		{
			title = "unknown";
		}
	}
	
	
	public void setCreditPoints(int inputCreditPoints)
	{
		if(inputCreditPoints > 0 && inputCreditPoints <=30) {
			creditPoints = inputCreditPoints;
		}
		else
		{
			creditPoints = 1;
		}
	}
	
	public void setProfessor(Professor inputProfessor) {
		if(inputProfessor != null) {
			professor = inputProfessor;
		}
		else
		{
			professor = new Professor();
		}
	}
	
	//4. bez argumenta konstruktors
	public Course()
	{
		setCID();
		setTitle("Testa kurss");
		setCreditPoints(1);
		setProfessor(new Professor());
	}
	
	
	//5. argumenta konstruktors
	public Course(String inputTitle, int inputCreditPoints, Professor inputProfessor)
	{
		setCID();
		setTitle(inputTitle);
		setCreditPoints(inputCreditPoints);
		setProfessor(inputProfessor);
	}
	//6. toString funkcija
	public String toString() {
		return cID + ": " + title + " (" + creditPoints + " KP) " 
				+ professor.getName().charAt(0) + ". " + professor.getSurname();
	}
	//7. citas funkcijas (pec nepieciesamibas)

}
