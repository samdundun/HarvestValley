package playground;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Song extends Component{

	private String title;
	private String artist;
	private int songlength;
	
	public Song(String title, String artist, int songlength) {
		super(40, 40, 35, 50);
		this.title = title;
		this.artist = artist;
		this.songlength = songlength;
		//catalog = new ArrayList<Catalog>();
		//catalog.add(new Catalog("TT", "Twice", 180));
		//addSequence("resources/sam.png", 100, 270, 24, 34, 50, 6);
		//Thread animation = new Thread(this);
		//animation.start();
		update();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		//super.update(g);
	}

	public String toString() {
		return title + ", "+ artist + ", " + songlength;
	}
}
