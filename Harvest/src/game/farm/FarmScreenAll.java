package game.farm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import game.mainScreen.BoyCharacter;
import game.mainScreen.GirlCharacter;
import game.mainScreen.ImageButton;
import game.market.BuyingScreen;
import game.market.InventoryScreen;
import game.market.Item;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import harvest.MainMenu;

public class FarmScreenAll extends FullFunctionScreen {

	private Graphic back;
	private Button shopJenny;
	private Button menuJenny;
	private Button itemJane;
	public static SelectionPaneJane pane;
	private ImageButton sleepAlex;
	public static ArrayList<CropJane> farmPatch;

	public static AnimatedComponent boy;
	public static AnimatedComponent girl;

	private static final int animalLimit = 5;
	private int currentAnimals;
	public static PaneJenny animalPane;
	private ArrayList<BoxJenny> animalBox;
	

	private Button test;
	private static List<Visible> viewObj;
	public static PaneJenny plantPane;
	
	public FarmScreenAll(int width, int height) {
		super(width, height);
	}
	
	public static List<Visible> getView(){
		return viewObj;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		viewObj = viewObjects;
		currentAnimals = 0;
		farmPatch = new ArrayList<CropJane>();
		animalBox = new ArrayList<BoxJenny>();

		back = new Graphic(0, 0, "resources/farm.PNG");
		viewObjects.add(back);

		test = new Button(400, 500, 80, 30, "test", new Color(230, 235, 210), new Action() {
			public void act() {
				addAnimalJenny(viewObjects, "resources/pig.png");
			}
		});
		viewObjects.add(test);
		addAnimalJenny(viewObjects, "resources/brownChicken.png");

		menuJenny = new Button(5, 500, 80, 30, "Menu", new Color(230, 235, 210), new Action() {
			public void act() {
				MainMenu.game.setScreen(MainMenu.screen);

			}
		});
		viewObjects.add(menuJenny);

		shopJenny = new Button(90, 500, 80, 30, "Shop", new Color(230, 235, 210), new Action() {
			public void act() {
				MainMenu.game.shop = new BuyingScreen(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.shop);

			}
		});
		viewObjects.add(shopJenny);

		sleepAlex = new ImageButton(815, 493, 39, 39, "resources/sleep.png", new Action() {

			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.sleep);

			}
		});
		viewObjects.add(sleepAlex);

		itemJane = new Button(175, 500, 80, 30, "Inventory", new Color(230, 235, 210), new Action() {
			public void act() {
				MainMenu.game.inventory = new InventoryScreen(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.inventory);

			}
		});
		viewObjects.add(itemJane);

		addfarmingPatchJane(viewObjects);
		
		//Mainscreen team work
		girl = game.mainScreen.GirlCharacter.addGirl(viewObjects);
		Thread rungurl = new Thread(girl);
		rungurl.start();
		
		
 		boy = game.mainScreen.BoyCharacter.addBoy(viewObjects);
 		Thread runboi = new Thread(boy);
 		runboi.start();
// 		viewObjects.add(boy);

// 		viewObjects.add(girl);
	
 		if(MainMenu.isGirl) {
 			viewObjects.add(girl);
 		}
 		else if(!MainMenu.isGirl) {
 			viewObjects.add(boy);
 		}
 		
		addfarmingPatchJane(viewObjects);
		pane = new SelectionPaneJane(this, 400, 300);
		pane.update();
		viewObjects.add(pane);
		pane.setVisible(false);

		animalPane = new PaneJenny(this, 400, 300);
		animalPane.update();
		viewObjects.add(animalPane);
		animalPane.setVisible(false);
		
		plantPane = new PaneJenny(this, 400, 300);
		plantPane.update();
		viewObjects.add(plantPane);
		plantPane.setVisible(false);
	}
	
	private void addAnimalJenny(List<Visible> viewObjects, String src) {
		currentAnimals++;
		int start = 40;
		int space = 150;

		if(currentAnimals <= animalLimit) {
			if(currentAnimals < 4) {
				BoxJenny box = new BoxJenny(start + ((currentAnimals - 1) * 130), 150, "resources/cow.png", null, viewObjects);
				animalBox.add(box);
				viewObjects.add(box);
			}
			else{
				BoxJenny box = new BoxJenny(start + ((currentAnimals - 4) * 130), 150 + space, src, null, viewObjects);
				animalBox.add(box);
				viewObjects.add(box);
			}
		}

	}

	private void addfarmingPatchJane(List<Visible> viewObjects) {
		int start = 593;
		int space = 77;
		for(int i=0; i<9; i++) {
			if(i<3) {
				CropJane patch= new CropJane(start+(i*68), 253, 63, 50, "",new Color(200, 125, 10), null, i, new CropImage());
				patch.update();
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
			else if(i>=3&&i<6) {
				CropJane patch= new CropJane(start+((i-3)*68), 260+space, 63, 50,"",new Color(200, 125, 10), null, i, new CropImage());
				patch.update();
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
			else {
				CropJane patch= new CropJane(start+((i-6)*68), 278+space+space, 63, 50, "",new Color(200, 125, 10), null,i, new CropImage());
				patch.update();
				farmPatch.add(patch);
				viewObjects.add(patch);
				//
			}
		}
	}

	public static void disableButton(boolean b) {
		for(int i=0; i<farmPatch.size(); i++) {
			farmPatch.get(i).setEnabled(b);
		}
		
	}
}