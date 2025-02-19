package model;

public class Student {

	//1. mainigie
	private long stID;
	private String name;
	private String surname;
	
	//2. getters
	public long getStID() {
		return stID;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}

	

	
	//3. setter
	//7as6fg34786adghq78612gjAYS897A7Y
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
	
	
	
	
	
	//4. bez argumenta konstruktors
	//5. argumena konstruktors
	//6. toString funkcija
	//7. citas funkcijas (ja nepieciesams)
}
