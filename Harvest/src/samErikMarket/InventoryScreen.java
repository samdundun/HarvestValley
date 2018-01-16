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

	}

}
