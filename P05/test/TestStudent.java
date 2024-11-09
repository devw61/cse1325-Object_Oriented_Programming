package test;

import customer.Student;
import product.Media;

public class TestStudent {
	public static void main(String[] args) {
		Student student = new Student("Devin", 1002098917, "dtw8917@mavs.uta.edu", true);
		String actual = student.toString();
		String expected = "Devin(1002098917, dtw8917@mavs.uta.edu, Account: #1)";
		Integer num;
		Media media = new Media("Hummingbird", "https://open.spotify.com/track/6HexNTb392JS071DoTGo0y?si=1e173cc3f17747a1", 20);
		int error_num = 0;

		// verify toString() method 
		if (!actual.equals(expected)) {
			System.err.println("Error: expected " + expected + " but got " + actual);
		}

		try {
			num = Integer.valueOf(actual.charAt(actual.indexOf('#') + 1));	
		} catch (NumberFormatException e) {
         		System.err.println("Error: Account number is invalid: " + actual);
			error_num++;
	        }
	
		// verify exception is thrown with incorrect email
		try {
			student = new Student("hacker", 1209840, "hacker7615@gmail.com", false);

			System.err.println("Error: No error was thrown with incorrect email");
			error_num++;
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.err.println("Error: " + e);	
			error_num++;
		}
		
		//verify requestMedia
		if (!student.requestMedia(media).equals("Playing Hummingbird")){
			System.err.println("Error: request media did not return correct string, instead: " + student.requestMedia(media));
			error_num++;
		}

		System.out.println("Number of errors: " + error_num);
	}
}
