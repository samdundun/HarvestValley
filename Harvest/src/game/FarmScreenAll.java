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
	private Button menuJenny;
	private Button itemJane;
	private ImageTextButton sleepAlex;
	private ArrayList<CropJane> farmPatch;
	
	private int animalLimit;

	public FarmScreenAll(int width, int height) {
		super(width, height);
		farmPatch = new ArrayList<CropJane>();
	}

	public void initAllObjects(List<Visible> viewObjects) {
		animalLimit = 5;
		
		back = new Graphic(0, 0, "resources/farm.PNG");
		viewObjects.add(back);
		
		menuJenny = new Button(5, 470, 80, 30, "Menu", new Color(230, 235, 210), null);
		viewObjects.add(menuJenny);

		shopJenny = new Button(90, 470, 80, 30, "Shop", new Color(230, 235, 210), null);
		viewObjects.add(shopJenny);
		
		
//		sleepAlex = new ImageTextButton("Click here","sleep.png", 0, 0, 150, 150, null);
//		viewObjects.add(sleepAlex);
		
		itemJane = new Button(175, 470, 80, 30, "Inventory", new Color(230, 235, 210), null);
		viewObjects.add(itemJane);
		addfarmingPatchJane(viewObjects);
;

	}

	private void addfarmingPatchJane(List<Visible> viewObjects) {
		int start = 547;
		int space = 77;
		for(int i=0; i<9; i++) {
			if(i<3) {
			CropJane patch= new CropJane(start+(i*68), 235, 63, 50, "", Color.BLACK, null);
			farmPatch.add(patch);
			viewObjects.add(patch);
			}
			else if(i>=3&&i<6) {
				CropJane patch= new CropJane(start+((i-3)*68), 235+space, 63, 50, "", Color.BLACK, null);
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
			else {
				CropJane patch= new CropJane(start+((i-6)*68), 248+space+space, 63, 50, "", Color.BLACK, null);
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
		}
	}
}