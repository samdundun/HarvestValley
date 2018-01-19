package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class SeedSelectionPane extends Pane {

	private TextLabel label;
	public SeedSelectionPane(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public void update(Graphics2D g){
		//customize the background
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.red);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		//draw the objects
		super.drawObjects(g);
	}

	public void initAllObjects(List<Visible> viewObjects){
		label = new TextArea(0,0,10,10,"This is a sample alert message. The entire red box is one pane. All of the text and the buttons move as one unit. Click 'OK' to watch this in action");
		
		viewObjects.add(label);
	}

}
