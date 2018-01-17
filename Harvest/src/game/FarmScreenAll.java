package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FarmScreenAll extends FullFunctionScreen {
	
	private Graphic back;
	private Button shopJenny;
	private Button menu;
	private Button itemJane;
	private ArrayList<CropJane> farmPatch;

	public FarmScreenAll(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		back = new Graphic(0, 0, "resources/farm.PNG");
		viewObjects.add(back);

		menu = new Button(5, 506, 80, 30, "Menu", new Color(230, 235, 210), null);
		viewObjects.add(menu);
		
		shopJenny = new Button(90, 506, 80, 30, "Shop",new Color(230, 235, 210), null);
		viewObjects.add(shopJenny);
		
		itemJane = new Button(175, 506, 80, 30, "Inventory", new Color(230, 235, 210), null);
		viewObjects.add(itemJane);
		
		addfarmingPatch(viewObjects);
		
		

	}

	private void addfarmingPatch(List<Visible> viewObjects) {
		for(int i=0; i<farmPatch.size(); i++) {
			
		}
		
	}
}
