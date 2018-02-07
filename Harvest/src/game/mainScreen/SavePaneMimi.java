package game.mainScreen;

import java.awt.Color;

import game.farm.FarmScreenAll;
import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class SavePaneMimi extends Button {

	public SavePaneMimi(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, new Color(200, 125, 10), new Action() {
			
			@Override
			public void act() {
				FarmScreenAll.pane.setX(x-250);
				FarmScreenAll.pane.setY(y-100);
				FarmScreenAll.pane.setVisible(true);
				FarmScreenAll.pane.update();
			}
		});
		
	}

	public SavePaneMimi(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
	}

}
