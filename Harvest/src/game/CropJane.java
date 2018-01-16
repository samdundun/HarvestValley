package game;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CropJane extends Button {

	public CropJane(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, "Plant here", new Color(200, 125, 10), new Action() {
			
			@Override
			public void act() {
				
				
			}
		});
		// TODO Auto-generated constructor stub
	}

	public CropJane(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}

}
