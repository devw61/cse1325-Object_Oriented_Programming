package customer;

import product.Media;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;


public class Alacarte extends Account {
	private int pointsRemaining;
	
	public Alacarte() {}

        public Alacarte(BufferedReader br) throws IOException {super.Account(br); pointsRemaining = Integer.parseInt(br.readLine());}

        @Override
        public void save(BufferedWriter bw) throws IOException {super.save(bw); bw.write("" + pointsRemaining + '\n');}


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
