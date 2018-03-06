// This class is currently not in used
// Only used when there's a single sound track to play
package game.mainScreen;

import java.applet.Applet;
import java.applet.AudioClip;

public class JessiSound {
	
	public static final JessiSound sound1 = new JessiSound("/sound.wav");
//
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

//06 - Spring (The Valley Comes Alive) sound
//05 - Spring (It's A Big World Outside) sound2
//13 - Summer (Nature's Crescendo) sound3
//27 - Winter (Nocturne Of Ice) sound4
//20 - Fall (The Smell Of Mushroom) sound5

