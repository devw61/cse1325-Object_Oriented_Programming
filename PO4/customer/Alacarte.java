package customer;

import product.Media;

public class Alacarte extends Account {
	private int pointsRemaining;

	public int buyPoints(int points) {
		return pointsRemaining += points;
	}

	public int getPointsRemainin() {
		return pointsRemaining;
	}

	@Override
	public String Play(Media media) {
		if (pointsRemaining > media.getPoints()) {
			pointsRemaining -= media.getPoints();
			return Play(media);
		} else {
			return "Buy more points: Requires " + media.getPoints() + " points, you have " + pointsRemaining;
		}
	}
}
