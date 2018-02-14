package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;
import game.market.SamBuyingScreen;
import game.market.SamInventory;
import game.market.ErikItem;
import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;
import harvest.MainMenu;

public class SelectionPaneJane extends Pane {
	public static ErikItem[] items = {new ErikItem("Corn Seeds", "Great crop to grow all year round", 300, 0, 4),new ErikItem("Pepper Seeds", "Spicy", 50, 1,1),
			new ErikItem("Potato Seeds", "Just like me", 150, 2, 3),new ErikItem("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new ErikItem("Tomato Seeds", "Make some good ketchup", 200, 4,3),new ErikItem("Wheat Seeds", "Not weed", 400, 5,5),

			new ErikItem("Corn", "Fresh to eat", 10,6,4), new ErikItem("Pepper","Supah Hot Fire",20,7,1),
			new ErikItem("Potato","Time to make french fries",10,8,3),new ErikItem("Strawberry","Berry??",10,9,2),
			new ErikItem("Tomato", "Great for salads", 10,10,3),	new ErikItem("Wheat","Just plain old wheat",10,11,5),

			new ErikItem("Brown Chicken", "Cluck cluck", 250, 12,1),new ErikItem("White Chicken", "Cluck cluck", 250, 13,1),
			new ErikItem("Black Chicken", "Cluck cluck", 250, 14,1),new ErikItem("Sheep", "BAAAAAAAAAAAH", 350, 15,2),
			new ErikItem("Cow", "Mooooooo", 500, 16,2),new ErikItem("Pig", "SNORT SNORT", 250, 17,1),

			new ErikItem("Brown Eggs", "Made by white chickens", 300, 18, 5),new ErikItem("White Eggs", "Made by white chickens", 50, 19,5),
			new ErikItem("Black Eggs", "A very special egg", 150, 20, 6),new ErikItem("Wool", "To keep you warm", 100, 21,2),
			new ErikItem("Milk", "Fresh milk!", 200, 22,1),new ErikItem("Meat", "Yum yum", 400, 23,10)};

	private Button cancel;
	private Button select;
	private Graphic grid;
	private SamInventory seedList;
	private int seedSelectedInd;
	private static String animalImg;
	private int animalIdx;
	private int index;
	private static final int _WIDTH = 235;
	private static final int _HEIGHT = 210;
	public SamInventory invent;

	private ArrayList<ErikItem> animal;

	private ArrayList<ErikItem> seeds;

	private Button sell;

	private int patchIndex;

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
		animalImg = "";
		invent = new SamInventory();
		invent.load();
		invent.sort();
		 animal=invent.getAnimalSelection();
		 seeds=invent.getSeedSelection();
		grid = new Graphic(15,22,280,150, "resources/seedPane.png");
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
		invent.sort();
		if(FarmScreenAll.getWhich().equals("crop")) {

			addImages(animal, 0, 45, 60, 60, label);
		}
		else {

			addImages(seeds, 0, 40, 55, 60, label);
		}
		select= new Button(35,_HEIGHT - 30, 60, 25, "Select",Color.lightGray, new Action() {

			public void act() {
				for(int i = 0; i < seeds.size(); i++) {
					if(seeds.get(i).isSelected()) {
						SelectionPaneJane.this.setSeedSelected(i);
						FarmScreenAll.farmPatch.get(index).setTime(seeds.get(i).getTime());
						FarmScreenAll.farmPatch.get(index).crop(seeds.get(i).getImageIndex());
						invent.removeItem(seeds.get(i));
						invent.save();
						SelectionPaneJane.this.setVisible(false);
						FarmScreenAll.disableButton(true);
					}

				}
				for(int j=0; j<animal.size(); j++) {
					if(animal.get(j).isSelected()) {
						animalIdx = j + 12;
						System.out.println(animalIdx);
						//setSrc(game.market.ErikItem.getGraphic()[animalIdx].getImageLocation());
						FarmScreenAll.animalBox.get(index).changeAction(animal.get(j).getImageIndex());
						invent.removeItem(animal.get(j));
						invent.save();
						SelectionPaneJane.this.setVisible(false);
						FarmScreenAll.disableButton(true);
					}
				}
				label.setText("Please select an item");
			}

		});
		viewObjects.add(select);
			sell = new Button(151,_HEIGHT - 30, 78, 25, "Sell Patch",Color.lightGray, new Action() {
				
				@Override
				public void act() {
					
					for(int i=6; i<FarmScreenAll.farmPatch.size(); i++) {
						if(getX()+250==FarmScreenAll.farmPatch.get(i).getX())
							index=i;
					}
					
					MainMenu.farmScreen.remove(FarmScreenAll.farmPatch.get(index));
					FarmScreenAll.farmPatch.remove(index);
					invent.setGold(invent.getGold()+1000);
					invent.save();
					MainMenu.farmScreen.addObjectToBack(FarmScreenAll.emptyFarmPatch.get(patchIndex));
					FarmScreenAll.emptyFarmPatch.get(patchIndex).setBought(false);
					FarmScreenAll.pane.setVisible(false);
					FarmScreenAll.disableButton(true);
					
				}
			});
			viewObjects.add(sell);
			sell.setVisible(false);
			sell.setEnabled(false);
		}

	public void setAnimal(ArrayList<ErikItem> animal) {
		this.animal = animal;
	}

	public  ArrayList<ErikItem> getSeeds() {
		return seeds;
	}

	public void setSeeds(ArrayList<ErikItem> seeds) {
		this.seeds = seeds;
	}

	public void addImages(ArrayList<ErikItem> item, int move, int startingHeight, int width, int height,TextLabel label) {


		for(int i = 0; i < item.size(); i++) {
			ErikItem z=item.get(i);
			z.setAction(new Action() {

				@Override
				public void act() {
					for(int i = 0; i < item.size();i++) {
						item.get(i).setSelected(false);
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

	public static void setSrc(String s) {
		animalImg = s;
	}

	public static String getSrc() {
		return animalImg;
	}

	public Button getCancel() {
		return cancel;
	}

	public Button getSelect() {
		return select;
	}

	public Button getSell() {
		return sell;
	}

	public void setPatchIndex(int patchIndex) {
		this.patchIndex=patchIndex;
		
	}
	 
}

