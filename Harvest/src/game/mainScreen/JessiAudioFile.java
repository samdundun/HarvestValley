package game.mainScreen;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class JessiAudioFile implements LineListener{

	private File soundFile;
    private AudioInputStream ais;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip clip;
    private FloatControl gainControl;
    private boolean playing;
   // private volatile boolean playing;
    
    public JessiAudioFile(String fileName) {
    	soundFile = new File(fileName);
    	try {
    		ais = AudioSystem.getAudioInputStream(soundFile);
		format = ais.getFormat();
	    	info = new DataLine.Info(Clip.class, format);
	    	clip = (Clip) AudioSystem.getLine(info);
	    	clip.addLineListener(this);
	    	clip.open(ais);
	    	gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
    }
   
    //default volume
    public void play() {
    		play(-10);
    }
   
    public void play(float volume) {
    		gainControl.setValue(-10);
		clip.start();
		playing = true;
    }
    
    public  boolean isPlaying() {
    	return playing;
    }

	@Override
	public void update(LineEvent event) {
		if(event.getType() == LineEvent.Type.START)
			playing = true;
		else if(event.getType() == LineEvent.Type.STOP) {
			clip.stop();
			clip.flush();
			clip.setFramePosition(0);
			playing = false;
		}	
	}
    
}
