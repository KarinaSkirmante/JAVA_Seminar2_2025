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
	public void setPID() {
		pID = counter++;
	}
	
	public void setName(String inputName) {
		if(inputName != null 
				&& inputName.matches("[A-Z]{1}[a-z]{3,10}([ ][A-Z]{1}[a-z]{3,10})?"))
		{
			name = inputName;
		}
		else
		{
			name = "unknown";
		}
	}
	
	public void setSurname(String inputSurname) {
		if(inputSurname != null
				&& inputSurname.matches("[A-Z]{1}[a-z]{3,10}([-][A-Z]{1}[a-z]{3,10})?"))
		{
			surname = inputSurname;
		}
		else
		{
			surname = "unknown";
		}
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
		setPID();
		setName("Testa");
		setSurname("Professors");
		setDegree(Degree.bsc);
	}
	//5. argumenta konstruktors
	public Professor(String name, String surname, Degree degree) {
		setPID();
		setName(name);
		setSurname(surname);
		setDegree(degree);
	}

	
	//6. toString funkcija
	@Override
	public String toString() {
		return pID + ": "+ degree + ", " + name + " " + surname;
	}
	
	
	//7. citas funkcijas (pec nepieciesamibas)
}
