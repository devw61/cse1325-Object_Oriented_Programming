public class TestMedia {
	public static void main(String[] args){
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");

		// indexes of returned string
		if (!media.toString().equals("The Little Shop of Horrors(https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)")){
			System.err.println("Error: media.toString() returned incorrect string: " + media.toString());
		}

		if (!media.toString().equals("random thing")){
			System.err.println("Error: media.toString() returned did not return 'random thing' instead: " + media.toString());
		}
	}
}
