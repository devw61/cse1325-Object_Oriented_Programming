package customer;

import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Unlimited extends Account{
	public Unlimited() {}	
	
	public Unlimited(BufferedReader br) throws IOException {super.Account(br);}

	@Override
	public void save(BufferedWriter bw) throws IOException {super.save(bw);}


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
