package test;

import customer.Student;
import product.Media;

public class TestStudent {
	public static void main(String[] args) {
		Student student = new Student("Devin", 1002098917, "dtw8917@mavs.uta.edu");
		String info = student.toString();
		Integer num;
		Media media = new Media("Hummingbird", "https://open.spotify.com/track/6HexNTb392JS071DoTGo0y?si=1e173cc3f17747a1", 20);
		int error_num = 0;

		// verify toString() method 
		if (info.indexOf("Devin") != 0) {
			System.err.println("Error: invalid name in student's toString(), got " + info + " instead of Devin");
			error_num++;
		}
		if (info.indexOf("1002098917") == -1 || info.indexOf("1002098917") < info.indexOf("Devin")) {
			System.err.println("Error: ID is not in the correct format: " + info);
			error_num++;
		} 
		if (info.indexOf("dtw8917@mavs.uta.edu") == -1 || info.indexOf("dtw8917@mavs.uta.edu") < info.indexOf(1002098917)) {
			System.err.println("Error: EMAIL is not in the correct format: " + info);
			error_num++;
		} 
		try {
			num = Integer.valueOf(info.charAt(info.indexOf('#') + 1));	
		} catch (NumberFormatException e) {
         		System.err.println("Error: Account number is invalid: " + info);
			error_num++;
	        }
	
		// verify exception is thrown with incorrect email
		try {
			student = new Student("hacker", 1209840, "hacker7615@gmail.com");

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
