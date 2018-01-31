package game.farm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import game.mainScreen.ImageButton;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import harvest.MainMenu;

public class FarmScreenAll extends FullFunctionScreen {

	private Graphic back;
	private Button shopJenny;
	private Button menuJenny;
	private Button itemJane;
	private SeedSelectionPane pane;

	private ImageButton sleepAlex;
	private ArrayList<CropJane> farmPatch;
	private Action action;

	private int animalLimit;

	public FarmScreenAll(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		animalLimit = 5;
		farmPatch = new ArrayList<CropJane>();
		back = new Graphic(0, 0, "resources/farm.PNG");
		viewObjects.add(back);

		menuJenny = new Button(5, 500, 80, 30, "Menu", new Color(230, 235, 210), new Action() {


			public void act() {
				MainMenu.game.setScreen(MainMenu.screen);

			}
		});
		viewObjects.add(menuJenny);

		shopJenny = new Button(90, 500, 80, 30, "Shop", new Color(230, 235, 210), new Action() {

			public void act() {
				MainMenu.game.setScreen(MainMenu.shop);

			}
		});
		viewObjects.add(shopJenny);
		
		sleepAlex = new ImageButton(815, 493, 39, 39, "resources/sleep.png", null);
		viewObjects.add(sleepAlex);
		
		itemJane = new Button(175, 500, 80, 30, "Inventory", new Color(230, 235, 210), new Action() {

			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.inventory);

			}
		});
		viewObjects.add(itemJane);
		addfarmingPatchJane(viewObjects);
		pane = new SeedSelectionPane(this, 100, 100, 200, 200);
		pane.update();
		viewObjects.add(pane);
	}

	private void addfarmingPatchJane(List<Visible> viewObjects) {
		int start = 593;
		int space = 77;
		for(int i=0; i<9; i++) {
			if(i<3) {
				CropJane patch= new CropJane(start+(i*68), 253, 63, 50, "", Color.BLACK, null);
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
			else if(i>=3&&i<6) {
				CropJane patch= new CropJane(start+((i-3)*68), 260+space, 63, 50, "", Color.BLACK, null);
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
			else {
				CropJane patch= new CropJane(start+((i-6)*68), 278+space+space, 63, 50, "", Color.BLACK, null);
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
		}
	}
}