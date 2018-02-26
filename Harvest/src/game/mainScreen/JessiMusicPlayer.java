package game.mainScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JessiMusicPlayer implements Runnable {
    
    private ArrayList<JessiAudioFile> musicFiles;
    private int currentSongIndex;
    private boolean running;
    private boolean refresh;
    private Map<String, Integer> indexMap = new HashMap<String, Integer>();
    
    public JessiMusicPlayer(String... files){
        musicFiles = new ArrayList<JessiAudioFile>();
        for(String file : files)
        {
            musicFiles.add(new JessiAudioFile("./resources/" + file + ".wav", file));
            indexMap.put(file, musicFiles.size()-1);
        }
    }

    @Override
    public void run() {
    		running = true;
    		JessiAudioFile song = musicFiles.get(currentSongIndex);
    		song.play();
    		while(running) {
    			if (refresh)
    			{
    				refresh = false;
    				currentSongIndex = -1;
    				song.stop();
    			}
    			if(!song.isPlaying() && musicFiles.size() != 0) {
    				currentSongIndex++;
    				if(currentSongIndex >= musicFiles.size() || currentSongIndex < 0)
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
    		song.stop();    		
    }

    public void refresh()
    {
    		refresh = true;
    }
    
    public void stop() {
    		running = false;
    }
    
	public void add(String string) {
		musicFiles.add(new JessiAudioFile("./resources/" + string + ".wav", string));	
		indexMap.put(string, musicFiles.size()-1);
	}
	
	public void remove(String string) {
		int index = indexMap.getOrDefault(string, -1);
		if (index != -1) {
			musicFiles.remove(index);
		}
		indexMap.clear();
		for (int i=0; i<musicFiles.size(); i++) {
			indexMap.put(musicFiles.get(i).getName(), i);
		}
	}
	
	public boolean isSongSelected(String string) {
		int index = indexMap.getOrDefault(string, -1);
		System.out.println("index is " + index);
		if (index != -1) return true;
		else return false;
	}

}