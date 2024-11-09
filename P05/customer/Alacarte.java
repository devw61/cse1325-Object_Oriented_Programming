package customer;

import product.Media;

public class Alacarte extends Account {
	private int pointsRemaining;

	public int buyPoints(int points) {
		pointsRemaining += points;
		return pointsRemaining;
	}

	public int getPointsRemaining() {
		return pointsRemaining;
	}

	@Override
	public String Play(Media media) {
		if (pointsRemaining >= media.getPoints()) {
			pointsRemaining -= media.getPoints();
			StringBuilder media_playing = new StringBuilder();
                	for (int i = 0; i<media.toString().length(); i++) {
        	                if (i < media.toString().indexOf('(')){
    	                            media_playing.append(media.toString().charAt(i) );
	                        } else {
                        	        break;
                	        }
        	        }
	                return "Playing " + media_playing;

		} else {
			return "Buy more points: Requires " + media.getPoints() + " points, you have " + pointsRemaining;
		}
	}
}
