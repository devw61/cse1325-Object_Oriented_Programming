package customer;

import product.Media;

public class Unlimited extends Account{

	@Override
	public String Play(Media media){
                StringBuilder media_playing = new StringBuilder();
                for (int i = 0; i<media.toString().length(); i++) {
                        if (i < media.toString().indexOf('(')){
                                media_playing.append(media.toString().charAt(i) );
                        } else {
                                break;
                        }
                }
                return "Playing " + media_playing;
        }
}
