package game.mainScreen;

import java.util.ArrayList;

import javax.sound.sampled.FloatControl;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class SoundButton extends LubnaImageButton{

	
	public SoundButton(int x, int y, int w, int h, String text, Action action, int vol) {
		super(x, y, w, h, text, new Action() {
			
			@Override
			public void act() {
//				if(vol==0) {
//					JessiAudioFile.clip.stop();
//					JessiAudioFile.clip.close();
//				}
				JessiAudioFile.gainControl.setValue(6);
				
			}
		});
		
		
		
	}
	
	
	
	
}
