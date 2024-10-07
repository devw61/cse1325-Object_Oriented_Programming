package mdi;

import moes.Moes;
import mdi.Menu;
import customer.Student;
import product.Media;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Main mainInstance = new Main(new Moes(), new Menu(), "", true);
		mainInstance.mdi();
	}


	private Moes moes = new Moes();
	private Menu menu = new Menu();
	private String output;
	private boolean running;
	private static final String extension = ".txt";
	private String filename;
	private static String fileVersion = "1.0";
	private static String magicCookie = "MOES";

	private void newMoes() {
		moes = new Moes();
	}

	private void save() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			bw.write("" + magicCookie + '\n' + fileVersion + '\n');
			moes.save(bw);
		} catch (Exception e) {
			System.err.println("Failed to save in main: " + e);
		}
	}

	private void saveAs() {
		System.out.println("Current filename: " + filename);
		Scanner in = new Scanner(System.in);

		try {
			System.out.print("Enter new filename: ");
			String new_filename = in.nextLine();
			if (new_filename.endsWith(extension)) {
				filename = new_filename;
			} else {
				filename = new_filename + extension;
			}
			save();
		} catch (Exception e) {
			System.err.println("Failed to save: " + e);
		}
	}

	private void open() {
		System.out.println("Current filename: " + filename);
		Scanner in = new Scanner(System.in);

		try {
			System.out.print("Enter new filename: ");
                        String new_filename = in.nextLine();
                        if (!new_filename.endsWith(extension)) {
                                filename = new_filename + extension;
                        }

			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
				String file_magic_cookie = br.readLine();
				String file_version = br.readLine();
				if (file_magic_cookie == magicCookie && file_version == fileVersion) {
					try {
						moes = new Moes(br);
						filename = new_filename;
					} catch (Exception e) {
						System.err.println("Could not recreate moes: " + e);
					}
				
				} else {
					throw new IOException("ERROR: incorrect magic cookie or file version\nmagic cookie: " + file_magic_cookie + ", excpected: " + magicCookie + "\nfile version: " + file_version + ", expected: " + fileVersion);
				}

			} catch (Exception e) {
				System.err.println("Failed to save: " + e);
			}
		} catch (Exception e) {
			System.out.println("Skipping...");
		}
	}

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
		menu.addMenuItem(new MenuItem("save",     () -> save()));
		menu.addMenuItem(new MenuItem("save as",     () -> saveAs()));
		menu.addMenuItem(new MenuItem("open",     () -> open()));
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
