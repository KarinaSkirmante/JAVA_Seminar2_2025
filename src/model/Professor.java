package model;

public class Professor {
	//1. mainigie
	private long pID;
	private String name;
	private String surname;
	private Degree degree;
	
	private static long counter = 10000;

	//2. getter
	public long getpID() {
		return pID;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public Degree getDegree() {
		return degree;
	}
	

	
	//3. setter
	//4. bez argumenta konstruktors
	//5. argumenta konstruktors
	//6. toString funkcija
	//7. citas funkcijas (pec nepieciesamibas)
}
