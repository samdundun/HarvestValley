package game.farm;

import java.util.ArrayList;

import guiTeacher.components.Pane;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class paneJenny extends Pane {

	public paneJenny(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
	}

	public paneJenny(FocusController focusController, int x, int y, int width, int height,
			ArrayList<Visible> initWithObjects) {
		super(focusController, x, y, width, height, initWithObjects);
	}

}
