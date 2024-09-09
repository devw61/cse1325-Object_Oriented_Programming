public class Media {
	String title;
	String url;

	public Media(String title, String url){
		this.title = title;
		this.url = url;
	}

	@Override
	public String toString() {
		return this.title + '(' + this.url + ')';
	}
}
