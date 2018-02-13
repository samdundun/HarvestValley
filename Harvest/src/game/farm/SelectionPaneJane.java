package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;
import game.market.BuyingScreen;
import game.market.Inventory;
import game.market.Item;
import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class SelectionPaneJane extends Pane {
	public static Item[] items = {new Item("Corn Seeds", "Great crop to grow all year round", 300, 0, 4),new Item("Pepper Seeds", "Spicy", 50, 1,1),
			new Item("Potato Seeds", "Just like me", 150, 2, 3),new Item("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new Item("Tomato Seeds", "Make some good ketchup", 200, 4,3),new Item("Wheat Seeds", "Not weed", 400, 5,5),

			new Item("Corn", "Fresh to eat", 10,6,4), new Item("Pepper","Supah Hot Fire",20,7,1),
			new Item("Potato","Time to make french fries",10,8,3),new Item("Strawberry","Berry??",10,9,2),
			new Item("Tomato", "Great for salads", 10,10,3),	new Item("Wheat","Just plain old wheat",10,11,5),

			new Item("Brown Chicken", "Cluck cluck", 250, 12,1),new Item("White Chicken", "Cluck cluck", 250, 13,1),
			new Item("Black Chicken", "Cluck cluck", 250, 14,1),new Item("Sheep", "BAAAAAAAAAAAH", 350, 15,2),
			new Item("Cow", "Mooooooo", 500, 16,2),new Item("Pig", "SNORT SNORT", 250, 17,1),

			new Item("Brown Eggs", "", 300, 18, 0),new Item("White Eggs", "", 50, 19,0),
			new Item("Black Eggs", "", 150, 20, 0),new Item("Wool", "", 100, 21,0),
			new Item("Milk", "", 200, 22,0),new Item("Meat", "", 400, 23,0)};
	private Button cancel;
	private Button select;
	private Graphic grid;
	private Inventory seedList;
	private int seedSelectedInd;
	private static String animalImg;
	private int animalIdx;
	private int index;
	private static final int _WIDTH = 225;
	private static final int _HEIGHT = 210;
	private Inventory invent;

	public SelectionPaneJane(FocusController focusController, int x, int y) {
		super(focusController, x, y, _WIDTH, _HEIGHT);

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
		index = 0;
		animalImg = "";
		invent = new Inventory();
		invent.load();

		grid = new Graphic(11,22,280,150, "resources/seedPane.png");
		viewObjects.add(0,grid);

		cancel= new Button(120,_HEIGHT - 30, 60, 25, "Cancel",Color.lightGray, new Action() {

			public void act() {
				SelectionPaneJane.this.setVisible(false);
				FarmScreenAll.disableButton(true);
			}
		});
		viewObjects.add(cancel);
		
		TextLabel label = new TextLabel(15, 0, 150, 50, "Please select an item");
		viewObjects.add(label);

		//		int move = 0;
		//		int width = 55;
		//		int startingHeight =40 ;
		//		int height = 60;

		if(FarmScreenAll.getWhich().equals("crop"))
			addImages(12, 18, 0, 45, 55, 60, label);
		else
			addImages(0, 6, 0, 40, 55, 60, label);

		select= new Button(35,_HEIGHT - 30, 60, 25, "Select",Color.lightGray, new Action() {

			public void act() {
				for(int i = 0; i < items.length; i++) {
					if(items[i].isSelected()) {
						if(items[i].getImageIndex() < 6) {
							SelectionPaneJane.this.setSeedSelected(i);
							FarmScreenAll.farmPatch.get(index).setTime(items[i].getTime());
							FarmScreenAll.farmPatch.get(index).crop(items[i].getImageIndex());
							SelectionPaneJane.this.setVisible(false);
							FarmScreenAll.disableButton(true);
						}
						else {
							System.out.println(FarmScreenAll.getWhich());
							animalIdx = i;
							setSrc(game.market.Item.getGraphic()[animalIdx].getImageLocation());
							FarmScreenAll.animalBox.get(index).changeAction();
							SelectionPaneJane.this.setVisible(false);
							FarmScreenAll.disableButton(true);
						}
					}	
				}
				label.setText("Please select an item");

			}});
		viewObjects.add(select);
	}

	public void addImages(int start, int end, int move, int startingHeight, int width, int height,TextLabel label) {
		invent.sort();
		ArrayList<Item> seeds=invent.getSeedInventory();
		System.out.println(seeds);
		for(int i = start; i < end; i++) {
			Item z=items[i];
			z.setAction(new Action() {

				@Override
				public void act() {
					for(int i = 0; i < items.length;i++) {
						items[i].setSelected(false);
					}
					System.out.println(z.getName());
					z.setSelected(true);
					label.setText(z.getName());
				}
			});

			z.setX(35+move*width);
			z.setY(startingHeight);
			move++;
			if(move == 3){
				move = 0;
				startingHeight = startingHeight+height;
			}
			viewObjects.add(z);
		}
	}

	public int setSeedSelected(int i) {
		return seedSelectedInd = i;
	}
	public int getSeedSelected() {
		return seedSelectedInd;
	}

	public void setIndex(int i) {
		index=i;

	}

	public void setSrc(String s) {
		animalImg = s;
	}
	
	public static String getSrc() {
		return animalImg;
	}
}
