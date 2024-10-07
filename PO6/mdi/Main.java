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
		Main mainInstance = new Main(new Moes(), new Menu(), "", true, false);
		mainInstance.mdi();
	}


	private Moes moes = new Moes();
	private Menu menu = new Menu();
	private String output;
	private boolean running;
	private static final String extension = ".txt";
	private String filename = "file.txt";
	private static String fileVersion = "1.0";
	private static String magicCookie = "MOES";
	private boolean dirty;

	private void newMoes() {
		if (dirty) {
			String choice = Menu.getString("Current file has unsaved changes, do you want to save before opening a new file? (yes/no)", "");
			if (choice.equals("yes")) {
				save();
			}
		}
		moes = new Moes();
	}

	private void save() {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			bw.write("" + magicCookie + '\n' + fileVersion + '\n');
			moes.save(bw);
			dirty = false;
		} catch (Exception e) {
			System.err.println("Failed to save in main: " + e);
		}
	}

	private void saveAs() {
		System.out.println("Current filename: " + filename);
		Scanner in = new Scanner(System.in);
			System.out.print("Enter new filename: ");
			String new_filename = in.nextLine();
		if (!new_filename.equals("")) {
			if (new_filename.endsWith(extension)) {
				filename = new_filename;
			} else {
				filename = new_filename + extension;
			}
			save();
			dirty = false;
		} else {
			System.out.println("No filename entered, no changes made.");
		}
	}

	private void open() {
		System.out.println("Current filename: " + filename);

		String new_filename = Menu.getString("Enter new filename: ", "");
		if (!new_filename.endsWith(extension)) {
				new_filename = new_filename + extension;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			if (dirty) {
				String choice = Menu.getString("Current file has unsaved changes, do you want to save before opening a new file? (yes/no)", "");
				if (choice.equals("yes")) {
					save();
				}
			}
			String file_magic_cookie = br.readLine();
			String file_version = br.readLine();
			if (file_magic_cookie.equals(magicCookie) && file_version.equals(fileVersion)) {
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
	}

	private void addStudent(){
		String name = Menu.getString("Student name? ", ""); if (name == null) return;
		Integer id = Menu.getInt("Student ID? ", ""); if (id == null) return;
		String email = Menu.getString("Student email? ", ""); if (email == null) return;
		String account = Menu.getString("Alacarte or Unlimited? ", ""); if (account == null) return;
		Student student = new Student(name, id, email, (account.equals("Unlimited")));
		moes.addStudent(student);

		dirty = true;
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

		dirty = true;
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

		dirty = true;
	}

	public Main(Moes moes, Menu menu, String output, boolean running, boolean dirty) {
		this.moes = moes;
	    this.menu = menu;
		this.output = output;
		this.running = running;
		this.dirty = dirty;
		
		menu.addMenuItem(new MenuItem("Add a Student",     () -> addStudent()));
		menu.addMenuItem(new MenuItem("List Students",       () -> listStudents()));
		menu.addMenuItem(new MenuItem("Add Media",      () -> addMedia()));
		menu.addMenuItem(new MenuItem("Play Media",         () -> playMedia()));
		menu.addMenuItem(new MenuItem("List Media",       () -> listMedia()));
		menu.addMenuItem(new MenuItem("List Available Points",     () -> listAvailablePoints()));
		menu.addMenuItem(new MenuItem("Buy Points",     () -> buyPoints()));
		menu.addMenuItem(new MenuItem("New Moes",     () -> newMoes()));
		menu.addMenuItem(new MenuItem("Save",     () -> save()));
		menu.addMenuItem(new MenuItem("Save as",     () -> saveAs()));
		menu.addMenuItem(new MenuItem("Open",     () -> open()));
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
