package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import game.farm.FarmScreenAll;

import game.market.BuyingScreen;
import game.market.Item;
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
	private TextLabel item;
	private int x;
	private int y;
	private List<Visible> viewObjects;

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
		this.viewObjects=viewObjects;
		harvest = new Button(35, _HEIGHT - 30, 60, 25, "Harvest", Color.lightGray, new Action() {

			public void act() {
				PaneJenny.this.setVisible(false);
				FarmScreenAll.disableButton(true);
			}
		});
		viewObjects.add(harvest);

		cancel = new Button(120, _HEIGHT - 30, 60, 25, "Cancel", Color.lightGray, new Action() {

			public void act() {
				//img.setVisible(false);
				PaneJenny.this.setVisible(false);
				FarmScreenAll.disableButton(true);
			}
		});
		viewObjects.add(cancel);
		
		label = new TextLabel(15, 0, 200, 50, "You can harvest (one):");
		viewObjects.add(label);
		item = new TextLabel(20, 80, 200, 50, "Item");
		viewObjects.add(item);
//		img = new Graphic(getX() , getY() + 50, getSrc());
//		viewObjects.add(img);
	}
	
	public void updateImg(String src) {
		img = new Graphic(getX() , getY() + 50, src);
		this.viewObjects.add(img);
		cancel.setAction(new Action() {
			
			@Override
			public void act() {
				img.setVisible(false);
				PaneJenny.this.setVisible(false);
				FarmScreenAll.disableButton(true);
				
			}
		});
	}
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = "resources/" + src + ".png";
	}
	
	public Button getHarvest() {
		return harvest;
	}

	public Graphic getImg() {
		return img;
	}

	public TextLabel getLabel() {
		return label;
	}
	public TextLabel getItem() {
		return item;
	}
}
