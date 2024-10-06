package mdi;

import moes.Moes;
import mdi.Menu;
import customer.Student;
import product.Media;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main mainInstance = new Main(new Moes(), new Menu(), "", true);
		mainInstance.mdi();
	}


	private Moes moes = new Moes();
	private Menu menu = new Menu();
	private String output;
	private boolean running;

	private void addStudent(){
		Scanner in = new Scanner(System.in);

		System.out.print("Enter student name: ");
		String name = in.nextLine();

		System.out.print("Enter student ID: ");
		int id;
	        while (!in.hasNextInt()) { 
        	    System.out.println("Invalid input. Please enter an integer for ID: ");
	            in.nextLine(); 
        	}
	        id = in.nextInt();
		in.nextLine();

		System.out.print("Enter student email: ");
		String email = in.nextLine();
		System.out.print("Does account have unlimited media? (true/false): ");

		boolean act_type;
	        while (!in.hasNextBoolean()) { 
        	    System.out.println("Invalid input. Please enter 1 or 0 for account type: ");
	            in.nextLine(); 
        	}
	        act_type = in.nextBoolean();

		Student student = new Student(name, id, email, act_type);
	
		moes.addStudent(student);
	}
	
	private void listStudents() {
		System.out.print(moes.getStudentList());
	}	

	private void addMedia() {
		Scanner in = new Scanner(System.in);

		// title url an points
		System.out.print("Enter media title: ");
		String title = in.nextLine();

		System.out.print("Enter media URL: ");
		String url = in.nextLine();

		System.out.print("Enter media cost: ");
		int cost;
		while (!in.hasNextInt()) { 
	            System.out.println("Invalid input. Please enter an integer for ID: ");
        	    in.nextLine(); 
	        }
        	cost = in.nextInt();
	
		Media media = new Media(title, url, cost);

		moes.addMedia(media);	
	}

	private void listMedia() {
		System.out.print(moes.getMediaList());
	}

	private void playMedia(){
		Scanner in = new Scanner(System.in);

		System.out.print("Enter Student's index: ");
		int student_index;
                while (!in.hasNextInt()) {
                    System.out.print("Invalid input. Please enter an integer for ID: ");
                    in.nextLine();
                }
                student_index = in.nextInt();

		in.nextLine();

		System.out.print("Enter Media index: ");
		int media_index;
		while (!in.hasNextInt()) {
                    System.out.print("Invalid input. Please enter an integer for ID: ");
                    in.nextLine();
                }
		media_index = in.nextInt();

		System.out.println(moes.playMedia(student_index, media_index));
	}

	private void listAvailablePoints() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Student's index: ");
		int student_index;
                while (!in.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer for ID: ");
                    in.nextLine();
                }
                student_index = in.nextInt();

		System.out.println(moes.getPoints(student_index));
	}

	private void buyPoints() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter Student's index: ");                
                int student_index = in.nextInt();

		int points = moes.getPoints(student_index);

		int bought_points = -1;
		while (bought_points <= 0){
			System.out.print("Enter the amount of points you want to buy: ");
			bought_points = in.nextInt();
			if (bought_points < 0) {System.out.println("Invalid Amount!");} 
		}
		in.nextLine();

		System.out.println(moes.buyPoints(student_index, bought_points));
	}

	public Main(Moes moes, Menu menu, String output, boolean running){
		this.moes = moes;
	    this.menu = menu;
		this.output = output;
		this.running = running;
		
		menu.addMenuItem(new MenuItem("Add a Student",     () -> addStudent()));
		menu.addMenuItem(new MenuItem("List Students",       () -> listStudents()));
		menu.addMenuItem(new MenuItem("Add Media",      () -> addMedia()));
		menu.addMenuItem(new MenuItem("Play Media",         () -> playMedia()));
		menu.addMenuItem(new MenuItem("List Media",       () -> listMedia()));
		menu.addMenuItem(new MenuItem("List Available Points",     () -> listAvailablePoints()));
		menu.addMenuItem(new MenuItem("Buy Points",     () -> buyPoints()));
		menu.addMenuItem(new MenuItem("Exit",               () -> endApp()));
	
	}

	private void mdi(){
		Scanner in = new Scanner(System.in);
		System.out.print("\033[H\033[2J"); // clear the console
		System.out.println("Welcome to Moes!");
		
		while (running) {
			System.out.println("======================");
			System.out.print(menu.toString());

			System.out.print("Choice: ");
			int choice = in.nextInt();
			in.nextLine();

			boolean valid = choice >= 0;
			System.out.println("======================");
			if (valid) {menu.run(choice);} else {System.out.println("Invalid choice!");}
		}
	}

	private void endApp(){
		this.running = false;
	}
}
