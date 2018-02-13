package game.mainScreen;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {
	
	public static final Sound sound1 = new Sound("/sound.wav");

	private AudioClip clip;
	
	public Sound(String filename) {
		try {
			clip = Applet.newAudioClip(Sound.class.getResource(filename));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		try {
			new Thread() { 
				public void run() {
					clip.play();
				}
			}.start();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
