package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import game.market.Inventory;
import game.market.Item;
import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class SeedSelectionPaneJane extends Pane {

	private Button cancel;
	private Button select;
	private Graphic grid;
	private Inventory seedList;
	private static final int _WIDTH = 300;
	private static final int _HEIGHT = 250;
	public SeedSelectionPaneJane(FocusController focusController, int x, int y) {
		super(focusController, x, y, _WIDTH, _HEIGHT);
		// TODO Auto-generated constructor stub
	}

	public void update(Graphics2D g){
		//customize the background
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(252,226,148));
		g.fillRoundRect(0, 0, _WIDTH, _HEIGHT,15,15);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, _WIDTH-1,  _HEIGHT-1,15,15);
		//draw the objects
		super.drawObjects(g);
	}

	public void initAllObjects(List<Visible> viewObjects){
		grid = new Graphic(20,20,280,150, "resources/seedPane.png");
		viewObjects.add(grid);
		seedList = new Inventory();
		seedList.addItem(new Item("Corn", "Fresh to eat", 10,0)/*placeHolder until the interface is done*/);
		int move = 1;
		int width = 48;
		int startingHeight = 35;
		int height = 48;
		for(Item i:seedList.getItems()) {
			i.setX(1+move*width);
			i.setY(startingHeight);
			move++;
			if(move == 13){
				move = 1;
				startingHeight = startingHeight+height;
			}
			viewObjects.add(i);
		}
		
		select= new Button(15,_HEIGHT - 43, 60, 25, "Select",Color.lightGray, new Action() {

			@Override
			public void act() {
				SeedSelectionPaneJane.this.setVisible(false);

			}
		});
		viewObjects.add(select);
		cancel= new Button(100,_HEIGHT - 43, 60, 25, "Cancel",Color.lightGray, new Action() {

			@Override
			public void act() {
				FarmScreenAll.pane.setVisible(false);

			}
		});
		viewObjects.add(cancel);
	}

}
