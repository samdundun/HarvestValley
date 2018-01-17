package samErikMarket;

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
		
		amount = new TextLabel(40,60,100,100,"Amount:");
		viewObjects.add(amount);
		gold = new TextLabel(500,60,100,100,"Gold:");
		viewObjects.add(gold);

		discard = new Button(600, 500, 100, 40, "DISCARD", new Action() {

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
		
		eat = new Button(460, 500, 100, 40, "EAT", new Action() {

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
		
		grid = new Graphic(60,180, "resources/inventory.png");
		viewObjects.add(grid);
		
//		addItems(0);
		
//		Item corn = new Item("Corn", "Fresh to eat", 10,"resources/Corn.png");
//		corn.setX(90);
//		corn.setY(200);
//		viewObjects.add(corn);
//		Item tomato = new Item("Corn", "Fresh to eat", 10,"resources/Tomato.png");
//		tomato.setX(138);
//		tomato.setY(200);
//		viewObjects.add(tomato);
		
		invent.add();
		int move = 1;
		int width = 48;
		int startingHeight = 200;
		int height = 48;
		for(Item i:invent.getItems()) {
			i.setX(40+move*width);
			i.setY(startingHeight);
			move++;
			if(move == 13){
				move = 1;
				startingHeight = startingHeight+height;
			}
			viewObjects.add(i);
		}
		
	}

	private void addItems(int index) {
		System.out.println(invent.getItem(index));
		Item i = invent.getItem(index);
		//x value for all books
		int x = 50;
		i.setX(x);
		//add book to screen
		addObject(i);
//		//mark book as having been added
//		b.setOnShelf(true);
//		//adjust y-values of all books
//		arrangeStack();
	}

}
