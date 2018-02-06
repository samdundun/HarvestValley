package game.farm;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;

public class CropJane extends Button {
	
	private int index;
	public CropJane(int x, int y, int w, int h, String text, Color color, Action action, int i) {
		super(x, y, w, h, text, new Color(200, 125, 10), new Action() {
			public void act() {
				FarmScreenAll.pane.setX(x-250);
				FarmScreenAll.pane.setY(y-100);
				FarmScreenAll.pane.setVisible(true);
				FarmScreenAll.pane.update();
			}

			
		});
		index=i;
	}

	public CropJane(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}
	
	public int getIndex() {
		return index;
	}
}
