package game.market;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextBox;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import harvest.MainMenu;

public class InventoryScreen extends FullFunctionScreen {

	CustomArea description;
	TextLabel amount;
	private TextLabel gold;
	private Button discard;
	private Graphic grid;
	private Button exit;

	private Inventory invent;

	public static final Item[] items = {new Item("Corn Seeds", "Great crop to grow all year round", 300, 0, 4),new Item("Pepper Seeds", "Spicy", 50, 1,1),
			new Item("Potato Seeds", "Just like me", 150, 2, 3),new Item("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new Item("Tomato Seeds", "Make some good ketchup", 200, 4,3),new Item("Wheat Seeds", "Not weed", 400, 5,5),new Item("Corn", "Corn \nFresh to eat", 10,6,4),
			new Item("Pepper","Pepper \nSupah Hot Fire",20,7,1),new Item("Potato","Potato \nTime to make french fries",10,8,3),
			new Item("Strawberry","Strawberry \nStraw + Berry??",10,9,2),new Item("Tomato", "Tomato \nGreat for salads", 10,10,3),
			new Item("Wheat","Wheat \nJust plain old wheat",10,11,5)};



	public InventoryScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(new Color(224,120,8));

		invent = new Inventory();
		invent.load();

		description = new CustomArea(100,400,300,100,"Description");
		viewObjects.add(description);

		amount = new TextLabel(100,60,100,100,"Amount:");
		viewObjects.add(amount);
		gold = new TextLabel(540,60,100,100,"Gold:"+invent.getGold());
		viewObjects.add(gold);

		discard = new Button(600, 400, 100, 40, "DISCARD", new Action() {

			@Override
			public void act() {
				Item removeI = null;
				for(Item i: items) {
					if(i.isSelected()) {
						for(Item it: invent.getItems()) {
							 if(i.getImageIndex() == it.getImageIndex()) {
								 removeI = it;
							 }
						}
						invent.getAmountArray()[i.getImageIndex()]--;
						amount.setText("Amount: " + invent.getAmountArray()[i.getImageIndex()]);
					}
				}
				invent.getItems().remove(removeI);
				invent.save();

				for(Item i: items) {
					if(i.isSelected() && invent.getAmountArray()[i.getImageIndex()] == 0) {
						MainMenu.game.inventory = new InventoryScreen(getWidth(),getHeight());
						MainMenu.game.setScreen(MainMenu.game.inventory);
					}
				}
			}
		});
		discard.setBackground(Color.red);
		discard.setActiveBorderColor(Color.white);
		discard.setCurve(0, 0);
		discard.update();
		viewObjects.add(discard);

		grid = new Graphic(100,180, "resources/inventory.png");
		viewObjects.add(grid);

		int move = 1;
		int width = 48;
		int startingHeight = 202;
		int height = 48;

		invent.sort();
		for(Item i:invent.getItems()) {
			i.setAction(new Action() {

				@Override
				public void act() {
					description.setText(i.getName()+"\n"+i.getDescription()  + "\nGrowth time : " + i.getTime() + " Days");
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

		exit = new Button(750, 40, 40, 40, "X", new Action() {

			@Override
			public void act() {
				amount.setText("Amount: ");
				description.setText("");
				MainMenu.game.setScreen(MainMenu.farmScreen);
				MainMenu.game.shop = new BuyingScreen(getWidth(),getHeight());

			}
		});
		exit.setBackground(Color.red);
		exit.setActiveBorderColor(Color.white);
		exit.setCurve(0, 0);
		exit.update();
		viewObjects.add(exit);
	}

}
