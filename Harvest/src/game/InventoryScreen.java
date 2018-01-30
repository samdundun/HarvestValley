package game;

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

public class InventoryScreen extends FullFunctionScreen {

	private TextBox description;
	private TextLabel amount;
	private TextLabel gold;
	private Button eat;
	private Button discard;
	private Graphic grid;
	private Button exit;

	private Inventory invent;

	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(new Color(224,120,8));

		invent = new Inventory();

		amount = new TextLabel(100,60,100,100,"Amount:");
		viewObjects.add(amount);
		gold = new TextLabel(540,60,100,100,"Gold:");
		viewObjects.add(gold);

		discard = new Button(600, 400, 100, 40, "DISCARD", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub

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
		figure out how to display quantity, price, etc when image is hovered over
		play around with the items class
		items should change opacity when clicked on or hovered over
		 **/
		invent.addBasics();
		//how other classes will add items to the inventory
		invent.addItem(new Item("Corn", "Fresh to eat", 10,0));
		invent.addItem(new Item("Corn", "Fresh to eat", 10,0));
		invent.addItem(new Item("Corn", "Fresh to eat", 10,0));
		invent.addItem(new Item("Corn", "Fresh to eat", 10,1));
		int move = 1;
		int width = 48;
		int startingHeight = 202;
		int height = 48;
		for(Item i:invent.getItems()) {
			i.setX(80+move*width);
			i.setY(startingHeight);
			move++;
			if(move == 13){
				move = 1;
				startingHeight = startingHeight+height;
			}
			viewObjects.add(i);
		}

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

	}

}
