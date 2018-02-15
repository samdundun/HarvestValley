package game.market;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import harvest.MainMenu;

public class ErikSellingScreen extends FullFunctionScreen implements FileRequester{

	private static final long serialVersionUID = 7548071104587737267L;
	ArrayList<SamInventory> a;
	private Button buying;
	private Button selling;
	private Button exchange;
	private SamCustomArea description;
	private SamCustomArea price;
	private TextLabel amount;
	private TextLabel gold;
	private Graphic grid;
	private Button exit;
	
	private SamInventory invent;
	
	private int priceLevel;

	public static final ErikItem[] items = {new ErikItem("Corn Seeds", "Great crop to grow all year round", 250, 0, 4),new ErikItem("Pepper Seeds", "Spicy", 50, 1,1),
			new ErikItem("Potato Seeds", "Just like me", 150, 2, 3),new ErikItem("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new ErikItem("Tomato Seeds", "Make some good ketchup", 200, 4,3),new ErikItem("Wheat Seeds", "Not weed", 300, 5,5),new ErikItem("Corn", "Fresh to eat", 300,6,4),
			new ErikItem("Pepper","Supah Hot Fire",60,7,1),new ErikItem("Potato","Time to make french fries",180,8,3),
			new ErikItem("Strawberry","Berry??",120,9,2),new ErikItem("Tomato", "Great for salads", 240,10,3),
			new ErikItem("Wheat","Just plain old wheat",360,11,5),new ErikItem("Brown Chicken", "Cluck cluck", 250, 12,1),new ErikItem("White Chicken", "Cluck cluck", 250, 13,1),
			new ErikItem("Black Chicken", "Cluck cluck", 250, 14,1),new ErikItem("Sheep", "BAAAAAAAAAAAH", 350, 15,2),
			new ErikItem("Cow", "Mooooooo", 400, 16,2),new ErikItem("Pig", "SNORT SNORT", 450, 17,1),
			new ErikItem("Brown Eggs", "Organic", 200, 18, 0),new ErikItem("White Eggs", "Non-Organic", 200, 19,0),
			new ErikItem("Black Eggs", "Does not contain egg whites", 200, 20, 0),new ErikItem("Wool", "Canada Goose", 300, 21,0),
			new ErikItem("Milk", "An utter-disaster", 350, 22,0),new ErikItem("Meat", "Mmmmmmm tasty", 500, 23,0)};

	public ErikSellingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(new Color(252,226,148));
		
		invent = new SamInventory();
		invent.load();
		
		buying = new Button(100, 40, 100, 40, "BUYING", new Action() {

			@Override
			public void act() {
				MainMenu.game.shop = new SamBuyingScreen(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.shop);

			}
		});
		buying.setBackground(Color.red);
		buying.setActiveBorderColor(Color.white);
		buying.setCurve(0, 0);
		buying.update();
		viewObjects.add(buying);
		
		gold = new TextLabel(100,100,100,100,"Gold: "+invent.getGold());
		viewObjects.add(gold);
		
		amount = new TextLabel(100,150,100,100,"Amount:");
		viewObjects.add(amount);
		
		
		selling = new Button(240, 40, 100, 40, "SELLING", new Action() {

			@Override
			public void act() {
				
			}
		});
		selling.setBackground(new Color(102,0,0));
		selling.setActiveBorderColor(Color.white);
		selling.setCurve(0, 0);
		selling.update();
		viewObjects.add(selling);
		
		grid = new Graphic(100,180, "resources/inventory.png");
		viewObjects.add(grid);
		
		exit = new Button(750, 40, 40, 40, "X", new Action() {

			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.farmScreen);
				MainMenu.game.inventory = new ErikInventoryScreen(getWidth(),getHeight());


			}
		});
		exit.setBackground(Color.red);
		exit.setActiveBorderColor(Color.white);
		exit.setCurve(0, 0);
		exit.update();
		viewObjects.add(exit);
		
		exchange = new Button(360, 400, 100, 40, "SELL 1", new Action() {

			@Override
			public void act() {
				ErikItem removeI = null;
				for(ErikItem i: items) {
					if(i.isSelected()) {
						for(ErikItem it: invent.getItems()) {
							 if(i.getImageIndex() == it.getImageIndex()) {
								 removeI = it;
							 }
						}
						invent.getAmountArray()[i.getImageIndex()]--;
						amount.setText("Amount: " + invent.getAmountArray()[i.getImageIndex()]);
						invent.setGold(invent.getGold() + i.getValue());
					}
				}
				invent.getItems().remove(removeI);
				invent.save();
				for(ErikItem i: items) {
					if(i.isSelected() && invent.getAmountArray()[i.getImageIndex()] == 0) {
						MainMenu.game.sell = new ErikSellingScreen(getWidth(),getHeight());
						MainMenu.game.setScreen(MainMenu.game.sell);
						i.setSelected(false);
					}
				}
				gold.setText("Gold: "+ invent.getGold());
				System.out.println(invent.getGold());
			}
		});
		exchange.setBackground(Color.red);
		exchange.setActiveBorderColor(Color.white);
		exchange.setCurve(0, 0);
		exchange.update();
		viewObjects.add(exchange);
		
		price = new SamCustomArea(100,400,250,125,"Selling Price :");
		viewObjects.add(price);
		
		
		description = new SamCustomArea(490, 400, 250, 125, "Description");
		viewObjects.add(description);
		
		int move = 1;
		int width = 48;
		int startingHeight = 202;
		int height = 48;
		
		invent.sort();
		for(ErikItem i:invent.getItems()) {
			i.setAction(new Action() {

				@Override
				public void act() {
					description.setText(i.getName()+"\n"+i.getDescription() + "\nGrowth time : " + i.getTime() + " Days");
					price.setText("Selling Price: "+ items[i.getImageIndex()].getValue());
					amount.setText("Amount: " + Integer.toString(invent.getAmountArray()[i.getImageIndex()]));

					for(int k = 0; k < items.length;k++) {
						items[k].setSelected(false);
					}

					items[i.getImageIndex()].setSelected(true);

					i.update();
					
				}
			});
			if(invent.getAmountArray()[i.getImageIndex()] > 0 && i.isAdded() == false) {
				i.setAdded(true);
				for(ErikItem it:invent.getItems()) {
					if(it.getImageIndex() == i.getImageIndex()) {
						it.setAdded(true);
					}
				}
				i.setX(80+move*width);
				i.setY(startingHeight);
				move++;
				if(move == 13){
					move = 1;
					startingHeight = startingHeight+height;
				}
				viewObjects.add(i);
			}
		}
		
		
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub

	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
