package game.mainScreen;

import java.util.ArrayList;
import java.util.Scanner;

import game.mainScreen.JessiSound;
import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.DrawInstructions;

public class JessiSoundTracks extends CustomImageButton implements Clickable{
	
	public static Scanner in;
	private int[] soundTracks;
	private ArrayList<JessiSound> sound;
	
	public JessiSoundTracks(int x, int y, int w, int h, DrawInstructions toDraw, Action action) {
		super(x, y, w, h, toDraw, action);
		// TODO Auto-generated constructor stub
	}

}

