import java.util.Scanner;

public class Hello {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String name = System.getProperty("user.name");				
                System.out.println("Hello, " + name);
        }		
}
