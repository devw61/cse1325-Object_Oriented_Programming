package moes;

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

	public int getPoints(int studentIndex) {
		Student student = customers.get(studentIndex);
		if (student.getAccount() instanceof Alacarte) {
			return ((Alacarte) student.getAccount()).getPointsRemaining();
		} else if (student.getAccount() instanceof Unlimited) {
			return Integer.MAX_VALUE;
		}
		throw new UnsupportedOperationException("Unknown subclass of Account");
	}

	public String buyPoints(int studentIndex, int points) {
		Student student = customers.get(studentIndex);
		if (student.getAccount() instanceof Alacarte) {
                        return "You now have " + ((Alacarte) student.getAccount()).buyPoints(points) + " points";
                } else if (student.getAccount() instanceof Unlimited) {
                        return "You have unlimited points, no need to buy them :)";
                } 
		throw new UnsupportedOperationException("Unknown subclass of Account");
	}

	public String playMedia(int studentIndex, int mediaIndex) {
		Student student = customers.get(studentIndex);
		Media media = library.get(mediaIndex);

		return student.requestMedia(media);
	}
}
