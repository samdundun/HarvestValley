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

public class SellingScreen extends FullFunctionScreen implements FileRequester{

	private static final long serialVersionUID = 7548071104587737267L;
	ArrayList<Inventory> a;
	private Button buying;
	private Button selling;
	private Button exchange;
	private CustomArea description;
	private CustomArea price;
	private TextLabel amount;
	private TextLabel gold;
	private Graphic grid;
	private Button exit;
	
	private Inventory invent;
	
	private int priceLevel;

	public static final Item[] items = {new Item("Corn Seeds", "Great crop to grow all year round", 300, 0, 4),new Item("Pepper Seeds", "Spicy", 50, 1,1),
			new Item("Potato Seeds", "Just like me", 150, 2, 3),new Item("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new Item("Tomato Seeds", "Make some good ketchup", 200, 4,3),new Item("Wheat Seeds", "Not weed", 400, 5,5),new Item("Corn", "Corn \nFresh to eat", 10,6,4),
			new Item("Pepper","Pepper \nSupah Hot Fire",20,7,1),new Item("Potato","Potato \nTime to make french fries",10,8,3),
			new Item("Strawberry","Strawberry \nStraw + Berry??",10,9,2),new Item("Tomato", "Tomato \nGreat for salads", 10,10,3),
			new Item("Wheat","Wheat \nJust plain old wheat",10,11,5)};

	public SellingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(new Color(252,226,148));
		
		invent = new Inventory();
		invent.load();
		
		buying = new Button(100, 40, 100, 40, "BUYING", new Action() {

			@Override
			public void act() {
				MainMenu.game.shop = new BuyingScreen(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.shop);

			}
		});
		buying.setBackground(Color.red);
		buying.setActiveBorderColor(Color.white);
		buying.setCurve(0, 0);
		buying.update();
		viewObjects.add(buying);
		
		gold = new TextLabel(540,60,100,100,"Gold: "+invent.getGold());
		viewObjects.add(gold);
		
		selling = new Button(240, 40, 100, 40, "SELLING", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub

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
				invent.load();
				update();

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
				Item removeI = null;
				for(Item i: items) {
					if(i.isSelected()) {
						for(Item it: invent.getItems()) {
							 if(i.getImageIndex() == it.getImageIndex()) {
								 //removeI has to be an item from the inventory array to remove it
								 removeI = it;
							 }
						}
						invent.getAmountArray()[i.getImageIndex()]--;
						amount.setText("Amount: " + invent.getAmountArray()[i.getImageIndex()]);
						invent.setGold(invent.getGold() + i.getValue());
						if(invent.getAmountArray()[i.getImageIndex()] == 1) {
							MainMenu.game.sell = new SellingScreen(getWidth(), getHeight());
							MainMenu.game.setScreen(MainMenu.game.sell);
							
							i.setSelected(false);
						}
					}
				}
				invent.getItems().remove(removeI);
				//invent.removeItem(removeI);
				invent.save();
				gold.setText("Gold: "+ invent.getGold());
				MainMenu.game.setScreen(MainMenu.sell);
				System.out.println(invent.getGold());
			}
		});
		exchange.setBackground(Color.red);
		exchange.setActiveBorderColor(Color.white);
		exchange.setCurve(0, 0);
		exchange.update();
		viewObjects.add(exchange);
		
		price = new CustomArea(100,400,250,125,"Price :");
		viewObjects.add(price);
		
		
		description = new CustomArea(490, 400, 250, 125, "Description");
		viewObjects.add(description);
		
		amount = new TextLabel(100,100,100,100,"Amount:");
		viewObjects.add(amount);
		
		int move = 1;
		int width = 48;
		int startingHeight = 202;
		int height = 48;
		
		invent.sort();
		for(Item i:invent.getItems()) {
			i.setAction(new Action() {

				@Override
				public void act() {
					description.setText(i.getName()+"\n"+i.getDescription());
					price.setText("Price: "+ i.getValue());
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
				for(Item it:invent.getItems()) {
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
