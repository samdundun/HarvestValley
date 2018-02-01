package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class SeedSelectionPaneJane extends Pane {

	private Button cancel;
	private Button select;
	private static final int _WIDTH = 250;
	private static final int _HEIGHT = 200;
	public SeedSelectionPaneJane(FocusController focusController, int x, int y) {
		super(focusController, x, y, _WIDTH, _HEIGHT);
		// TODO Auto-generated constructor stub
	}

	public void update(Graphics2D g){
		//customize the background
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(252,226,148));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		//draw the objects
		super.drawObjects(g);
	}

	public void initAllObjects(List<Visible> viewObjects){
		select= new Button(5,_HEIGHT - 43, 50, 20, "Select",Color.GRAY, new Action() {

			@Override
			public void act() {
				SeedSelectionPaneJane.this.setVisible(false);

			}
		});
		viewObjects.add(select);
		cancel= new Button(70,_HEIGHT - 43, 50, 20, "Cancel",Color.GRAY, new Action() {

			@Override
			public void act() {
				FarmScreenAll.pane.setVisible(false);

			}
		});
		viewObjects.add(cancel);
	}

}
