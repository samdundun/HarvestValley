package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import game.market.BuyingScreen;
import game.market.Item;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.Pane;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class paneJenny extends Pane {

	private static final int _WIDTH = 225;
	private static final int _HEIGHT = 195;

	private Button harvest;
	private Button cancel;
	private Graphic img;
	private String src;

	public paneJenny(FocusController focusController, int x, int y, String src) {
		super(focusController, x, y, _WIDTH, _HEIGHT);
	}

	public void update(Graphics2D g){
		//customize the background
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(252,226,148));
		g.fillRoundRect(0, 0, _WIDTH, _HEIGHT,15,15);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, _WIDTH-1,  _HEIGHT-1, 15, 15);
		//draw the objects
		super.drawObjects(g);
	}

	public void initAllObjects(List<Visible> viewObjects){
		harvest = new Button(35, _HEIGHT - 30, 60, 25, "Harvest", Color.lightGray, new Action() {

			public void act() {
				paneJenny.this.setVisible(false);
			}
		});
		viewObjects.add(harvest);

		cancel = new Button(120, _HEIGHT - 30, 60, 25, "Cancel", Color.lightGray, new Action() {

			public void act() {
				paneJenny.this.setVisible(false);
			}
		});
		viewObjects.add(cancel);
	}
}
