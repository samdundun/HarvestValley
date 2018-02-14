package game.mainScreen;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import java.io.File;
import java.util.ArrayList;

public class JessiMusicPlayer implements Runnable {
    
    private ArrayList<JessiAudioFile> musicFiles;
    private int currentSongIndex;
    private boolean running;
    
    public JessiMusicPlayer(String... files){
        musicFiles = new ArrayList<JessiAudioFile>();
        for(String file : files)
            musicFiles.add(new JessiAudioFile("./resources/audio/" + file + ".wav"));
    }

    @Override
    public void run() {
    		running = true;
    		JessiAudioFile song = musicFiles.get(currentSongIndex);
    		song.play();
    		while(running) {
    			if(!song.isPlaying()) {
    				currentSongIndex++;
    				if(currentSongIndex >= musicFiles.size())
    					currentSongIndex = 0;
    				song = musicFiles.get(currentSongIndex);
    				song.play();
    				}
    			try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
       }
    }

}