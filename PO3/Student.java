public class Student {
	String name;
	int id;
	String email;
	Account account = new Account();

	public Student(String name, int id, String email){
		this.name = name;
		this.id = id;
		this.email = email;
	}

	public void requestMedia(Media media){

	}

	@Override
	public String toString() {

	}
}
