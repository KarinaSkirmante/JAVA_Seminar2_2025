package model;

public class Student extends Person {

	//1. mainigie
	private long stID;

	
	private static long counter = 0;
	
	//2. getters
	public long getStID() {
		return stID;
	}
	

	//3. setter
	public void setStID() {
		stID = counter++;
	}
	
	
	
	//4. bez argumenta konstruktors
	public Student() {
		super();//tiek izsaukt bazes kalses bezragumenta konstruktors
		setStID();
		//setSurname("Students");//set funkcija ir izsaukta no bazes klases
		surname = "Students";
		
	}
	
	//5. argumena konstruktors
	public Student(String name, String surname) {
		super(name, surname);//tiek izsaukts bazes klases konstruktors Person(String inputName, String inputSurname)
		setStID();
		
	}

	
	//6. toString funkcija
	//parrakstam object klases toString funkciju
	//2: Karlis Lielais
	@Override
	public String toString() {
		return stID + ": " + super.toString();//pielipinas vardu un uzvardu no bazes klases toString funkcijas
	}
	
	
	
	//7. citas funkcijas (ja nepieciesams)
}
