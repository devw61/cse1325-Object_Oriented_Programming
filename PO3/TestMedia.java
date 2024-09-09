public class TestMedia {
	public static void main(String[] args){
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");

		// indexes of returned string
		int index_title, index_op, index_url, index_cp;

		index_title = media.toString().indexOf("The Little Shop of Horrors");
		index_op = media.toString().indexOf('(');
		index_url = media.toString().indexOf("https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");
		index_cp = media.toString().indexOf(')');

		if (index_title == -1){
			throw new IllegalArgumentException("Error: title not in media's returned string");
		} else if (index_op == -1 ){
			throw new IllegalArgumentException("Error: '(' not in media's returned string");
		} else if (index_url == -1 ){
			throw new IllegalArgumentException("Error: URL not in media's returned string");
		} else if (index_cp == -1) {
			throw new IllegalArgumentException("Error: ')' not in media's returned string");
		} else if (index_url < index_op || index_url > index_cp) {
			throw new IllegalArgumentException("Error: URL is not in parenthesis");
		} else if (index_title > index_op) {
			throw new IllegalArgumentException("Error: title is NOT before the URL in parentheses");
		}
		
	}
}
