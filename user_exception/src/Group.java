package ua.org.oa.moskalenkod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Group {

	int groupSize = 0;
	private Student[] group;
	
	
	public Student[] getGroup() {
		return group;
	}
	public void setGroup(Student[] group) {
		setGroup(group);
	}

	

	Scanner sc = new Scanner(System.in);

	public Group(int groupSize) {
		group = new Student[groupSize];
	}

	public Student createStudent() {
		Student std = null;
		System.out.println("Input student name:");
		String name = sc.nextLine();
		System.out.println("Input student age:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Input student ID:");
		String iD = sc.nextLine();
		while (std == null) {
			try {
				std = new Student(name, age, iD);
			} catch (StudentNameException e) {
				System.out.println(e.getMessage());
				System.out.println("Input correct name!");
				name = sc.nextLine();
			} catch (StudentAgeException e) {
				System.out.println(e.getMessage());
				System.out.println("Input correct age!");
				age = sc.nextInt();
				sc.nextLine();
			} catch (StudentIDException e) {
				System.out.println(e.getMessage());
				System.out.println("Input correct ID!");
				iD = sc.nextLine();
				
			}
		}
		return std;
		
	}

	 public void fillGroup(){
		 
		 if (group.length != 0){
			 for (int i =0; i < group.length; i++) {
			
				 System.out.println("Add new student-->");
				 System.out.println(group [i] = createStudent());
			 }
		 }
		
	 }
	 
	 public void printGroup(){
		 System.out.println("\nPrinting all group------>");
		 for (Student el: group) {
			 System.out.println(el);
		 }
		
	}
	
}
