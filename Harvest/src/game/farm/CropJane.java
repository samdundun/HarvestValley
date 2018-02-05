package game.farm;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CropJane extends Button {
	
	public CropJane(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, new Color(200, 125, 10), new Action() {
		
			public void act() {
				FarmScreenAll.pane.setX(x-250);
				FarmScreenAll.pane.setY(y-100);
				FarmScreenAll.pane.setVisible(true);
				FarmScreenAll.pane.update();
			}

			
		});
	}

	public CropJane(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}

}
