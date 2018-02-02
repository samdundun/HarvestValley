package game.market;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.Pane;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import harvest.MainMenu;

public class BuyingScreen extends FullFunctionScreen implements FileRequester{

	private static final long serialVersionUID = 7548071104587737267L;
	private Button buying;
	private Button selling;
	private Button exchange;
	private CustomArea description;
	private TextArea price;
	private TextLabel amount;
	private TextLabel gold;
	private Graphic grid;
	private Button exit;
	
	private int priceLevel;
	private int goldAmount;
	private int amountLevel;
	
	private Inventory invent;
	
	public static final Item[] items = {new Item("Corn Seeds", "Great crop to grow all year round", 300, 0, 4),new Item("Pepper Seeds", "Spicy", 50, 1,1),
			new Item("Potato Seeds", "Just like me", 150, 2, 3),new Item("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new Item("Tomato Seeds", "Make some good ketchup", 200, 4,3),new Item("Wheat Seeds", "Not weed", 400, 5,5)};


	public BuyingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		
		invent = new Inventory();
		
		StyledComponent.setButtonOutline(true);
		setBackground(new Color(252,226,148));
		
		buying = new Button(100, 40, 100, 40, "BUYING", new Action() {

			@Override
			public void act() {

			}
		});
		buying.setBackground(new Color(102,0,0));
		buying.setActiveBorderColor(Color.white);
		buying.setCurve(0, 0);
		buying.update();
		viewObjects.add(buying);
		
		selling = new Button(240, 40, 100, 40, "SELLING", new Action() {

			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.sell);
				invent.load();
				update();

			}
		});
		selling.setBackground(Color.red);
		selling.setActiveBorderColor(Color.white);
		selling.setCurve(0, 0);
		selling.update();
		viewObjects.add(selling);
		
		exit = new Button(750, 40, 40, 40, "X", new Action() {

			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.farmScreen);

			}
		});
		exit.setBackground(Color.red);
		exit.setActiveBorderColor(Color.white);
		exit.setCurve(0, 0);
		exit.update();
		viewObjects.add(exit);
		
		grid = new Graphic(100,180, "resources/inventory.png");
		viewObjects.add(grid);
		
		price = new CustomArea(100,400,250,125,"Price :" + priceLevel);
		viewObjects.add(price);
		
		
		description = new CustomArea(490, 400, 250, 125, "SELECT AN ITEM");
		viewObjects.add(description);
		
		exchange = new Button(360, 400, 100, 40, "BUY 1", new Action() {

			@Override
			public void act() {
				for(int i = 0; i < items.length; i++) {
					if(items[i].isSelected()) {
						invent.addItem(items[i]);
					}
				}
				invent.save();

			}
		});
		exchange.setBackground(Color.red);
		exchange.setActiveBorderColor(Color.white);
		exchange.setCurve(0, 0);
		exchange.update();
		viewObjects.add(exchange);
		
		int move = 1;
		int width = 48;
		int startingHeight = 202;
		int height = 48;
		
		for(int i = 0; i < items.length; i++) {
			Item z = items[i];
			z.setAction(new Action() {
				
				@Override
				public void act() {
					description.setText(z.getName() + "\n" + z.getDescription() + "\nGrowth time : " + z.getTime());
					price.setText("Price: "+ z.getValue());
					for(int i = 0; i < items.length;i++) {
						items[i].setSelected(false);
					}
					items[z.getImageIndex()].setSelected(true);;
					
				}
			});
			z.setX(80+move*width);
			z.setY(startingHeight);
			move++;
			if(move == 13){
				move = 1;
				startingHeight = startingHeight+height;
			}
			viewObjects.add(z);
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
