package game.farm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import game.mainScreen.BoyCharacter;
import game.mainScreen.GirlCharacter;
import game.mainScreen.ImageButton;
import game.market.BuyingScreen;
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
	private ArrayList<CropJane> farmPatch;
	private Action action;

	private int animalLimit;

	public static AnimatedComponent boy;
	public static AnimatedComponent girl;

	private int currentAnimals;
	public static SelectionPaneJane animalPane;
	private ArrayList<BoxJenny> animalBox;
	private Button test;

	public FarmScreenAll(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		animalLimit = 5;
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

		sleepAlex = new ImageButton(815, 493, 39, 39, "resources/sleep.png", new Action() {

			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.sleep);

			}
		});
		viewObjects.add(sleepAlex);

		itemJane = new Button(175, 500, 80, 30, "Inventory", new Color(230, 235, 210), new Action() {
			public void act() {
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

// 		/viewObjects.add(girl);
	
 		if(MainMenu.isGirl) {
 			viewObjects.add(girl);
 		}
 		else if(!MainMenu.isGirl) {
 			viewObjects.add(boy);
 		}
 		
		addfarmingPatchJane(viewObjects);


		pane = new SelectionPaneJane(this, 400, 300,BuyingScreen.items,new Action() {


			public void act() {
				for(int i = 0; i <BuyingScreen.items.length; i++) {
					if(BuyingScreen.items[i].isSelected()) {
						pane.setSeedSelected(i);
					}
					pane.setVisible(false);

				}

			}});
		pane.update();
		viewObjects.add(pane);
		pane.setVisible(false);

		animalPane = new SelectionPaneJane(this, 400, 300, AnimalProduceJenny.produce,new Action() {
			public void act() {
				for(int i = 0; i < AnimalProduceJenny.produce.length; i++) {
					if(AnimalProduceJenny.produce[i].isSelected()) {
						pane.setSeedSelected(i);
					}
					pane.setVisible(false);

				}

			}});
		animalPane.update();
		viewObjects.add(animalPane);
		animalPane.setVisible(false);
	}

	private void addAnimalJenny(List<Visible> viewObjects, String src) {
		currentAnimals++;
		int start = 40;
		int space = 150;

		if(currentAnimals <= animalLimit) {
			if(currentAnimals < 4) {
				BoxJenny box = new BoxJenny(start + ((currentAnimals - 1) * 130), 150, src, null);
				animalBox.add(box);
				viewObjects.add(box);
			}
			else{
				BoxJenny box = new BoxJenny(start + ((currentAnimals - 4) * 130), 150 + space, src, null);
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
				//
			}
		}
	}
}