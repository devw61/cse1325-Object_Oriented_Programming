/**
*                the product Media
*
*  @author      Devin T. Wingfield
*  @version     2.0
*  @since       1.0
*/

package product;

/**
*
*  struct for media
*
*/

public class Media {
	private String title;
	private String url;
	private int points;

	/**
	*                Creates instance of Media
	*	
	*  @param title       String - title of the media
	*  @param url         String - url of the media
	*  @param points      int - cost of plaing the media 
	*  @since            1.0
	*/

	public Media(String title, String url, int points){
		this.title = title;
		this.url = url;
		this.points = points;
	}

	/**
        *                returns the cost of the media
        *
        *  @return       cost of playing the media
        *  @since       1.0
        */

	public int getPoints() {
		return this.points;
 	}	
	
	/**
        *                returns formatted option of the media instance
        *
        *  @return      formatted string of the media instance
        *  @since       1.0
        */

	@Override
	public String toString() {
		return this.title + '(' + this.url + ", " + this.points + " points)";
	}
}
