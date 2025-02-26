package model;

public class Person {
	//1. mainigie
	private String name;
	private String surname;
	
	//2. getters
	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}
	//3. setters

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
	//4. bezargumenta konstr.
	
	public Person()
	{
		setName("Testa");
		setSurname("Persona");
	}
	
	
	//5. argum. konstruktors
	public Person(String inputName, String inputSurname)
	{
		setName(inputName);
		setSurname(inputSurname);
	}
	
	//6. toString
	public String toString() {
		return name + " " + surname;
	}
}
