package model;

public class Professor extends Person{
	//1. mainigie
	private long pID;

	private Degree degree;
	
	private static long counter = 10000;

	//2. getter
	public long getpID() {
		return pID;
	}

	
	public Degree getDegree() {
		return degree;
	}
	

	
	//3. setter
	public void setPID() {
		pID = counter++;
	}
	

	
	public void setDegree(Degree inputDegree) {
		if(inputDegree != null) {
			degree = inputDegree;
		}
		else
		{
			degree = Degree.unknown;
		}
	}

	//4. bez argumenta konstruktors
	public Professor()
	{
		super();
		setPID();
		setSurname("Profesors");
		setDegree(Degree.bsc);
	}
	//5. argumenta konstruktors
	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setPID();
		setDegree(degree);
	}

	
	//6. toString funkcija
	@Override
	public String toString() {
		return pID + ": "+ degree + ", " + super.toString();
	}
	
	
	//7. citas funkcijas (pec nepieciesamibas)
}
