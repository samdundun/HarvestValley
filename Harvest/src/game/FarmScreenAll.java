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
	private ArrayList<CropJane> farmPatch;

	public FarmScreenAll(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		back = new Graphic(0, 0, "resources/farm.PNG");
		viewObjects.add(back);

<<<<<<< HEAD
		menu = new Button(5, 506, 80, 30, "Menu", new Color(230, 235, 210), null);
		viewObjects.add(menu);
=======
		menuJenny = new Button(5, 470, 80, 30, "Menu", new Color(230, 235, 210), null);
		viewObjects.add(menuJenny);
>>>>>>> branch 'farm' of https://github.com/samdundun/HarvestValley.git
		
<<<<<<< HEAD
		shopJenny = new Button(90, 506, 80, 30, "Shop",new Color(230, 235, 210), null);
=======
		shopJenny = new Button(90, 470, 80, 30, "Shop", new Color(230, 235, 210), null);
>>>>>>> branch 'farm' of https://github.com/samdundun/HarvestValley.git
		viewObjects.add(shopJenny);
		
<<<<<<< HEAD
		itemJane = new Button(175, 506, 80, 30, "Inventory", new Color(230, 235, 210), null);
		viewObjects.add(itemJane);
		
		addfarmingPatch(viewObjects);
		
		

=======
		itemJane = new Button(175, 470, 80, 30, "Inventory", new Color(230, 235, 210), null);
		viewObjects.add(itemJane);
>>>>>>> branch 'farm' of https://github.com/samdundun/HarvestValley.git
	}

	private void addfarmingPatch(List<Visible> viewObjects) {
		for(int i=0; i<farmPatch.size(); i++) {
			
		}
		
	}
}
