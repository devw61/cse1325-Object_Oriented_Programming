package test;

import product.Media;

public class TestMedia {
	public static void main(String[] args){
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 20);

		// indexes of returned string
		if (!media.toString().equals("The Little Shop of Horrors(https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 20 points)")){
			System.err.println("Error: media.toString() returned incorrect string: " + media.toString());
		}

	}
}
