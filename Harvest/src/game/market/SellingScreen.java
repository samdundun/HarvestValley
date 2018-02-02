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



	public SellingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(new Color(252,226,148));
		
		invent = new Inventory();
		
		buying = new Button(100, 40, 100, 40, "BUYING", new Action() {

			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.shop);
				invent.load();
				update();

			}
		});
		buying.setBackground(Color.red);
		buying.setActiveBorderColor(Color.white);
		buying.setCurve(0, 0);
		buying.update();
		viewObjects.add(buying);
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
				

			}
		});
		exchange.setBackground(Color.red);
		exchange.setActiveBorderColor(Color.white);
		exchange.setCurve(0, 0);
		exchange.update();
		viewObjects.add(exchange);
		
		price = new CustomArea(100,400,250,125,"Price :" + priceLevel);
		viewObjects.add(price);
		
		
		description = new CustomArea(490, 400, 250, 125, "SELECT AN ITEM");
		viewObjects.add(description);
		
		amount = new TextLabel(100,100,100,100,"");
		viewObjects.add(amount);

		invent.load();
		//how other classes will add items to the inventory
//		invent.addItem(new Item("Corn", "Fresh to eat", 10,0));
//		invent.addItem(new Item("Corn", "Fresh to eat", 10,0));
//		invent.addItem(new Item("Corn", "Fresh to eat", 10,0));
//		invent.addItem(new Item("Corn", "Fresh to eat", 10,1))
		int move = 1;
		int width = 48;
		int startingHeight = 202;
		int height = 48;
		for(Item i:invent.getItems()) {
			i.setAction(new Action() {	
				@Override
				public void act() {
					description.setText(i.getDescription());
					amount.setText("Amount: " + i.getAmount());
				}
			});
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
