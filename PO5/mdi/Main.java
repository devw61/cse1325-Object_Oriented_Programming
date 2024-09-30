package mdi;

import moes.Moes;
import mdi.Menu;
import customer.Student;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	}


	private Moes moes = new Moes();
	private Menu menu = new Menu();
	String output;
	boolean running;

	private void addStudent(){
		Scanner in = new Scanner(System.in);

		System.out.print("Enter student name: ");
		String name = in.nextLine();

		System.out.print("Enter student ID: ");
		int id;
	        while (!in.hasNextInt()) { 
        	    System.out.println("Invalid input. Please enter an integer for ID: ");
	            in.nextLine(); // Clear invalid input
        	}
	        id = in.nextInt();
		in.nextLine();

		System.out.print("Enter student email: ");
		String email = in.nextLine();
		System.out.print("Does account have unlimited media? (true/false): ");

		boolean act_type;
	        while (!in.hasNextBoolean()) { 
        	    System.out.println("Invalid input. Please enter 1 or 0 for account type: ");
	            in.nextLine(); // Clear invalid input
        	}
	        act_type = in.nextBoolean();

		Student student = new Student(name, id, email, act_type);
	
		moes.addStudent(student);
	}
	
	private void listStudents() {
		System.out.print(moes.getStudentList());
	}	
}
