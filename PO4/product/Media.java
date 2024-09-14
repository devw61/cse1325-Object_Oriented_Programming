/*
*                the product Media
*
*  @author:      Devin T. Wingfield
*  @version:     1.0
*  @since:       1,0
*/

package product;

public class Media {
	private String title;
	private String url;
	private int points;

	/*
	*                Creates instance of Media
	*	
	*  @param:       String title, String url, int points
	*  @returns      null
	*  @since:       1.0
	*/

	public Media(String title, String url, int points){
		this.title = title;
		this.url = url;
		this.points = points;
	}

	/*
        *                returns the cost of the media
        *
        *  @param:       nu;;
        *  @returns      cost of playing the media
        *  @since:       1.0
        */

	public int getPoints() {
		return this.points;
 	}	
	
	/*
        *                returns formatted option of the media instance
        *
        *  @param:       null
        *  @returns      formatted string of the media instance
        *  @since:       1.0
        */

	@Override
	public String toString() {
		return this.title + '(' + this.url + ", " + this.points + " points)";
	}
}
