public class TestStudent {
	public static void main(String[] args) {
		Student student = new Student("Devin", 1002098917, "dtw8917@mavs.uta.edu");
		String info = student.toString();
		Integer num;
		
		// verify toString() method 
		if (info.indexOf("Devin") != 0) {
			System.err.println("Error: invalid name in student's toString(), got " + info + " instead of Devin");
		}
		if (info.indexOf("1002098917") == -1 || info.indexOf("1002098917") < info.indexOf("Devin")) {
			System.err.println("Error: ID is not in the correct format: " + info);
		} 
		if (info.indexOf("dtw8917@mavs.uta.edu") == -1 || info.indexOf("dtw8917@mavs.uta.edu") < info.indexOf(1002098917)) {
			System.err.println("Error: EMAIL is not in the correct format: " + info);
		} 
		try {
			num = Integer.valueOf(info.charAt(info.indexOf('#') + 1));	
		} catch (NumberFormatException e) {
         		System.err.println("Error: Account number is invalid: " + info);
	        }
	
		// verify exception is thrown with incorrect email
		try {
			student = new Student("hacker", 1209840, "hacker7615@gmail.com");

			System.err.println("Error: No error was thrown with incorrect email");
		} catch (IllegalArgumentException e) {
		} catch (Exception e) {
			System.err.println("Error: " + e);	
		}
				
	}
}
