package samErikMarket;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.StyledComponent;
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
	private TextBox description;
	private TextBox price;
	private TextLabel amount;
	private TextLabel gold;



	public BuyingScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		
		buying = new Button(40, 40, 100, 40, "BUYING", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub

			}
		});
		buying.setBackground(Color.red);
		buying.setActiveBorderColor(Color.white);
		buying.setCurve(0, 0);
		buying.update();
		viewObjects.add(buying);
		selling = new Button(180, 40, 100, 40, "SELLING", new Action() {

			@Override
			public void act() {
				// TODO Auto-generated method stub

			}
		});
		viewObjects.add(selling);

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
