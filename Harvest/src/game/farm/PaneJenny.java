package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import game.farm.FarmScreenAll;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.Pane;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class PaneJenny extends Pane {

	private static final int _WIDTH = 225;
	private static final int _HEIGHT = 195;

	private Button harvest;
	private Button cancel;
	private Graphic img;
	private String src;
	private TextLabel label;
	private int x;
	private int y;

	public PaneJenny(FocusController focusController, int x, int y) {
		super(focusController, x, y, _WIDTH, _HEIGHT);
		this.x = x;
		this.y = y;
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
		setSrc("milk");
		harvest = new Button(35, _HEIGHT - 30, 60, 25, "Harvest", Color.lightGray, new Action() {

			public void act() {
				PaneJenny.this.setVisible(false);
			}
		});
		viewObjects.add(harvest);

		cancel = new Button(120, _HEIGHT - 30, 60, 25, "Cancel", Color.lightGray, new Action() {

			public void act() {
				img.setVisible(false);
				PaneJenny.this.setVisible(false);
			}
		});
		viewObjects.add(cancel);
		
		label = new TextLabel(15, 0, 150, 50, "You can harvest (one):");
		viewObjects.add(label);
	}
	
	public void updateImg(List<Visible> viewObjects) {
		img = new Graphic(getX() + (_WIDTH - 160), getY() + 50, getSrc());
		viewObjects.add(img);
	}
	
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = "resources/" + src + ".png";
	}
}