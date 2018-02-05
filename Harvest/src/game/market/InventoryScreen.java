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
	private Button eat;
	private Button discard;
	private Graphic grid;
	private Button exit;

	private Inventory invent;

	public static final Item[] items = {new Item("Corn Seeds", "Great crop to grow all year round", 100, 0,4),
			new Item("Pepper Seeds", "Yes", 100, 1,1),new Item("Potato Seeds", "Yes", 100, 2,3),
			new Item("Strawberry Seeds", "Yes", 100, 3,2),new Item("Tomato Seeds", "Yes", 100, 4,3),
			new Item("Wheat Seeds", "Yes", 100, 5,5),new Item("Corn", "Corn \nFresh to eat", 10,6,4),
			new Item("Pepper","Pepper \nSupah Hot Fire",20,7,1),new Item("Potato","Potato \nTime to make french fries",10,8,3),
			new Item("Strawberry","Strawberry \nStraw + Berry??",10,9,2),new Item("Tomato", "Tomato \nGreat for salads", 10,10,3),
			new Item("Wheat","Wheat \nJust plain old wheat",10,11,5)};



	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(new Color(224,120,8));

		invent = new Inventory();

		description = new CustomArea(100,400,300,150,"Description");
		//somehow change description to the item that is highlighted
		viewObjects.add(description);

		amount = new TextLabel(100,60,100,100,"Amount:");
		viewObjects.add(amount);
		gold = new TextLabel(540,60,100,100,"Gold:");
		viewObjects.add(gold);

		discard = new Button(600, 400, 100, 40, "DISCARD", new Action() {

			@Override
			public void act() {
				for(int i = 0; i < items.length; i++) {
					if(items[i].isSelected()) {
						invent.removeItem(items[i]);
					}
				}
				invent.save();

			}
		});
		discard.setBackground(Color.red);
		discard.setActiveBorderColor(Color.white);
		discard.setCurve(0, 0);
		discard.update();
		viewObjects.add(discard);

		eat = new Button(460, 400, 100, 40, "EAT", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub

			}
		});
		eat.setBackground(Color.red);
		eat.setActiveBorderColor(Color.white);
		eat.setCurve(0, 0);
		eat.update();
		viewObjects.add(eat);

		grid = new Graphic(100,180, "resources/inventory.png");
		viewObjects.add(grid);
		/*TODO
		figure out how to display quantity, price, etc when image is hovered ove
		play around with the items class
		items should change opacity when clicked on or hovered over
		 **/
		//how other classes will add items to the inventory

		int move = 1;
		int width = 48;
		int startingHeight = 202;
		int height = 48;

		invent.sort();
		for(Item i:invent.getItems()) {
			//only print new items
			i.setAction(new Action() {

				@Override
				public void act() {
					invent = new Inventory();
					invent.sort();
					description.setText(i.getDescription());
					amount.setText("Amount: " + Integer.toString(i.getAmount()));
					for(int j = 0; j < items.length;j++) {
						items[j].setSelected(false);
					}
					items[i.getImageIndex()].setSelected(true);;

					i.update();


				}
			});
			if(i.getAmount() > 0 && i.isAdded() == false) {
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

			}
		});
		exit.setBackground(Color.red);
		exit.setActiveBorderColor(Color.white);
		exit.setCurve(0, 0);
		exit.update();
		viewObjects.add(exit);
	}

}
