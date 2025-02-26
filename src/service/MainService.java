package service;



import java.util.ArrayList;
import java.util.Arrays;

import model.Course;
import model.Degree;
import model.Grade;
import model.Person;
import model.Professor;
import model.Student;

public class MainService {
	
	private static ArrayList<Person> allPersons = new ArrayList<Person>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();
	

	public static void main(String[] args) {
		System.out.println("------------------STUDENTI---------------");
		Student st1 = new Student();
		//System.out.println(st1);//0: Testa Students //toString tiek izsaukts automatiski
		
		Student st2 = new Student("Janis", "Berzins");
		//System.out.println(st2);//1: Janis Berzins
		
		Student st3 = new Student("Anna Paula", "Jauka-Nejauka");
		//System.out.println(st3);//2: Anna Paula Jauka-Nejauka
		
		Student st4 = new Student("786s78rfa6", "Skirm$ante");
		//System.out.println(st4);//3: unknown unknown
		
		Student st5 = new Student("Laura", "Gudra");
		allPersons.addAll(Arrays.asList(st1, st2, st3, st4, st5));
		System.out.println(allPersons);
		
		
		System.out.println("------------------PROFESORI---------------");
		Professor p1 = new  Professor();
		//System.out.println(p1);
		
		Professor p2 = new Professor("Karina", "Skirmante", Degree.mg);
		//System.out.println(p2);
		
		allPersons.addAll(Arrays.asList(p1, p2));
		
		try {
			createProfessor("Karlis", "Immers", Degree.mg);
			createProfessor("Raita",  "Rollande", Degree.dr);
			createProfessor("Juris", "Zagars", Degree.dr);
			//createProfessor("Karlis", "Immers", Degree.mg);//sagaidu izņēmumu šeit
			System.out.println("Pievienots jauns profesors: " + allPersons);
			System.out.println("10001 profesors: " + retrieveProfessorById(10001));
			
			updateProfessorById(10001, "Karina", "Krinkele", Degree.dr);
			System.out.println("Atjaunots eksistejoss profesors: " + allPersons);
			deleteProfessorById(10000);
			System.out.println("Izdzest testa profesors: " + allPersons);
			
			System.out.println("Profesori ar dr gradu: " + filterProfessorByDegree(Degree.dr) );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		System.out.println("------------------KURSI---------------");
		Course c1 = new Course();
		//System.out.println(c1);

		Course c2 = new Course("JAVA programesana", 6, p2);
		Course c4 = new Course("Datu Strukturas un pamatalgoritmi", 4, p2);
		//System.out.println(c2);
	
		Course c3;
		try {
			c3 = new Course("Operetajsistemas", 6, retrieveProfessorById(10002));
			allCourses.addAll(Arrays.asList(c1, c2, c3, c4));
		
		
		
			System.out.println(allCourses);
			System.out.println("Prof.Karina Krinkele vada " + howManyCoursesAreLeadByProfessorById(10001) + " kursus");
		
		
		System.out.println("------------------ATZIMES---------------");
		Grade g1 = new Grade();//testa atzime
		//System.out.println(g1);
		
		Grade g2 = new Grade(10, st2, c2);//10 nopelnīja Janis JAVA kursā
		//System.out.println(g2);
		
		Grade g3 = new Grade(8, st3, c2);//8 nopelnioja Anna Paula JAVA kursā
		Grade g4 = new Grade(3, st2, c3);//3 nopelnīja Jānis OS kursā
		Grade g5 = new Grade(5, st3, c3);//5 nopelnija Anna Paula OS kursā
		//System.out.println(g3);
		allGrades.addAll(Arrays.asList(g1, g2, g3, g4, g5));
		System.out.println(allGrades);
		
		System.out.println("Jana vid.atzime: " + calculateAvgGradeForStudentById(1));
		System.out.println(retreiveAllFailedGrades());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//CRUD
	//C-create
	public static void createProfessor(String name, String surname, Degree degree) throws Exception {
		//parbaudam, vai tads profesors jau eksiste
		for(Person tempP : allPersons) {
			if(tempP instanceof Professor)//parbauda vai persona ir profesors
			{
				Professor tempPP = (Professor)tempP;
				if(tempPP.getName().equals(name)
					&& tempPP.getSurname().equals(surname)
					&& tempPP.getDegree().equals(degree))
				{
					throw new Exception("Tads profesors jau eksiste sistema");
				}
			
			
		
				
			}
		}
		allPersons.add(new Professor(name, surname, degree));
		
	}
	
	//R - retrieve
	public static Professor retrieveProfessorById(int id) throws Exception{
		if(id < 0) {
			throw new Exception("Id nevar but negativs");
		}
		
		for(Person tempP : allPersons) {
			if(tempP instanceof Professor)
			{
				Professor tempPP = (Professor)tempP;
				if(tempPP.getpID() == id) {
					return tempPP;
				}
			}
		}
		
		throw new Exception("Profesors ar noradito id neeksiste");
		
	}

	//U - update
	public static void updateProfessorById(int id, String inputName, 
			String inputSurname, Degree inputDegree) throws Exception
	
	{
		Professor foundProfessor = retrieveProfessorById(id);
		
		if(inputName != null && !foundProfessor.getName().equals(inputName))
		{
			foundProfessor.setName(inputName);
		}
		
		if(inputSurname != null && !foundProfessor.getSurname().equals(inputSurname)) {
			foundProfessor.setSurname(inputSurname);
		}
		
		if(inputDegree != null && !foundProfessor.getDegree().equals(inputDegree)) {
			foundProfessor.setDegree(inputDegree);
		}
		
	}
	//D - delete
	public static void deleteProfessorById(int id) throws Exception {
		Professor foundProfessor = retrieveProfessorById(id);
		
		allProfessors.remove(foundProfessor);
	}
	
	//filtret profesorus pec grada
	public static ArrayList<Professor> filterProfessorByDegree(Degree inputDegree) throws Exception{
		
		if(inputDegree == null) {
			throw new Exception("Nav pareizi ievadit dati par gradu");
		}
		
		ArrayList<Professor> results = new ArrayList<Professor>();
		
		for(Professor tempP : allProfessors) {
			if(tempP.getDegree().equals(inputDegree)) {
				results.add(tempP);
			}
		}
		
		
		return results;
		
	}
	
	//aprēķina vidējo atzīmi, ja padod studenta id
	public static float calculateAvgGradeForStudentById(int id) throws Exception{

		retrieveStudentById(id);//parbaudam, vai students vispar eksistē, ja eksistē, tad turpinam ar nako rinduņu, ja ne, tad tiks izmest izņemums
		
		
		
		int howManyGrades = 0;
		float sum = 0;
		for(Grade tempG : allGrades) {
			if(tempG.getStudent().getStID() == id) {
				howManyGrades++;
				sum += tempG.getGrValue();
			}
		}
		
		if(howManyGrades == 0) {
			throw new Exception("Studentam nav piesaistita neviena atzime");
		}
		
		return sum/howManyGrades;
		
	}
	
	//R - retrieve
		public static Student retrieveStudentById(int id) throws Exception{
			if(id < 0) {
				throw new Exception("Id nevar but negativs");
			}
			
			for(Student tempS : allStudents) {
				if(tempS.getStID() == id) {
					return tempS;
				}
			}
			
			throw new Exception("Students ar noradito id neeksiste");
			
		}
	
	
	public static int howManyCoursesAreLeadByProfessorById(int id) throws Exception {
		
		retrieveProfessorById(id);
		
		int howManyCourses = 0;
		for(Course tempC: allCourses) {
			if(tempC.getProfessor().getpID() == id) {
				howManyCourses++;
			}
		}
		
		
		if(howManyCourses == 0) {
			throw new Exception("profesoram nav neviens piesaistits kurss");
		}
		
		return howManyCourses;
		
	}
	//izfiltrē un atgriež visas nesekmīgās atzīmes
	public static ArrayList<Grade> retreiveAllFailedGrades(){
		ArrayList<Grade> results = new ArrayList<Grade>();
		
		for(Grade tempG: allGrades) {
			if(tempG.getGrValue() < 4)
			{
				results.add(tempG);
			}
		}
		
		return results;
	}
	//saskaita, cik ir kursi pie noteikta CP skaita (CP->2KP, cik ir kursi tiesi ar 2KP)
	
}
