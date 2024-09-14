import java.util.ArrayList;
import customer.*;
import product.Media;

public class Moes {
	ArrayList<Media> library = new ArrayList<>();
	ArrayList<Student> customers = new ArrayList<>();
	
	public void addMedia(Media media) {
		library.add(media);
	}	
	
	public String getMediaList() {
		StringBuilder media_list = new StringBuilder();
		for (Media media : library) {
			media_list.append(media.toString()).append("\n");
		}
		return media_list.toString();
	}

	public void addStudent(Student customer) {
                customers.add(customer);
        }

        public String getStudentList() {
                StringBuilder student_list = new StringBuilder();
                for (Student customer : customers) {
                        student_list.append(customer.toString()).append("\n");
                }
                return student_list.toString();
        }
}
