package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import game.market.BuyingScreen;
import game.market.Inventory;
import game.market.Item;
import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class SeedSelectionPaneJane extends Pane {

	private Button cancel;
	private Button select;
	private Graphic grid;
	private int seedSelectedInd;
	private Item[] items;
	private Action action;
	private static final int _WIDTH = 250;
	private static final int _HEIGHT = 230;
	public SeedSelectionPaneJane(FocusController focusController, int x, int y, Item[] selection, Action action) {
		super(focusController, x, y, _WIDTH, _HEIGHT);
		items=selection;
		this.action=action;
	}

	public void update(Graphics2D g){
		//customize the background
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(252,226,148));
		g.fillRoundRect(0, 0, _WIDTH, _HEIGHT,15,15);
		g.setColor(Color.black);
		g.drawRoundRect(0,0, _WIDTH-1,  _HEIGHT-1,15,15);
		//draw the objects
		super.drawObjects(g);
	}

	public void initAllObjects(List<Visible> viewObjects){
//		grid = new Graphic(20,20,280,150, "resources/seedPane.png");
//		viewObjects.add(grid);
//		int move = 1;
//		int width = 48;
//		int startingHeight = 35;
//		int height = 48;
//		for(Item i:items) {
//			i.setX(-2+move*width);
//			i.setY(startingHeight);
//			move++;
//			if(move == 13){
//				move = 1;
//				startingHeight = startingHeight+height;
//			}
//			viewObjects.add(i);
//		}
		
		select= new Button(30,_HEIGHT - 43, 60, 25, "Select",Color.lightGray, action); 
		viewObjects.add(select);
		
		cancel= new Button(115,_HEIGHT - 43, 60, 25, "Cancel",Color.lightGray, new Action() {

			@Override
			public void act() {
				SeedSelectionPaneJane.this.setVisible(false);

			}
		});
		viewObjects.add(cancel);
	}
	 public int setSeedSelected(int i) {
		 return seedSelectedInd = i;
	 }
	public int getSeedSelected() {
		return seedSelectedInd;
	}
}
