package service;

import model.Degree;
import model.Professor;
import model.Student;

public class MainService {

	public static void main(String[] args) {
		Student st1 = new Student();
		System.out.println(st1);//0: Testa Students //toString tiek izsaukts automatiski
		
		Student st2 = new Student("Janis", "Berzins");
		System.out.println(st2);//1: Janis Berzins
		
		Student st3 = new Student("Anna Paula", "Jauka-Nejauka");
		System.out.println(st3);//2: Anna Paula Jauka-Nejauka
		
		Student st4 = new Student("786s78rfa6", "Skirm$ante");
		System.out.println(st4);//3: unknown unknown
		
		Professor p1 = new  Professor();
		System.out.println(p1);
		
		Professor p2 = new Professor("Karina", "Skirmante", Degree.mg);
		System.out.println(p2);

	}

}
