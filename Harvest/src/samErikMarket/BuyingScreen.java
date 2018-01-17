package samErikMarket;

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

public class BuyingScreen extends FullFunctionScreen implements FileRequester{

	private static final long serialVersionUID = 7548071104587737267L;
	ArrayList<Inventory> a;
	private Button buying;
	private Button selling;
	private Button exchange;
	private Button description;
	private TextArea price;
	private TextLabel amount;
	private TextLabel gold;
	private Graphic grid;



	public BuyingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(new Color(252,226,148));
		
		buying = new Button(60, 40, 100, 40, "BUYING", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub

			}
		});
		buying.setBackground(new Color(102,0,0));
		buying.setActiveBorderColor(Color.white);
		buying.setCurve(0, 0);
		buying.update();
		viewObjects.add(buying);
		
		selling = new Button(200, 40, 100, 40, "SELLING", new Action() {

			@Override
			public void act() {
				InventoryGUI.market.setScreen(InventoryGUI.sell);

			}
		});
		selling.setBackground(Color.red);
		selling.setActiveBorderColor(Color.white);
		selling.setCurve(0, 0);
		selling.update();
		viewObjects.add(selling);
		
		grid = new Graphic(60,180, "resources/inventory.png");
		viewObjects.add(grid);
		
		price = new TextArea(60,400,100,100,"Price :");
		viewObjects.add(price);
		
		description = new Button(450,400,250,150, "INSERT DESCRIPTION", new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		description.setBackground(new Color(130,199,165));
		description.setCurve(0, 0);
		description.update();
		viewObjects.add(description);
		
		exchange = new Button(300, 400, 100, 40, "BUY 1", new Action() {

			@Override
			public void act() {
				

			}
		});
		exchange.setBackground(Color.red);
		exchange.setActiveBorderColor(Color.white);
		exchange.setCurve(0, 0);
		exchange.update();
		viewObjects.add(exchange);
		

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
