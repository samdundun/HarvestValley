package game.mainScreen;

import java.applet.Applet;
import java.applet.AudioClip;

public class JessiSound {
	
	public static final JessiSound sound1 = new JessiSound("/sound.wav");

	private AudioClip clip;
	
	public JessiSound(String filename) {
		try {
			clip = Applet.newAudioClip(JessiSound.class.getResource(filename));
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
