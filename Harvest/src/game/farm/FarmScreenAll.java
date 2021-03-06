package game.farm;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;


import game.mainScreen.JessiBoyCharacter;
import game.mainScreen.MimiGirlCharacter;
import game.mainScreen.LubnaImageButton;
import game.mainScreen.MimiMovableCharacter;
import game.market.SamBuyingScreen;
import game.market.ErikInventoryScreen;
import game.market.ErikItem;
import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import harvest.MainMenu;

public class FarmScreenAll extends FullFunctionScreen {

	private Graphic back;
	private Button shopJenny;
	private Button menuJenny;
	private Button itemJane;
	private LubnaImageButton sleepAlex;
	private static String which;
	private static List<Visible> viewObj;
	public static SelectionPaneJane pane;
	public static SelectionPaneJane first;

	public static ArrayList<CropJane> farmPatch;
	public static ArrayList<EmptyPatch> emptyFarmPatch;
	public static ArrayList<BoxJenny> animalBox;


	public static MimiMovableCharacter boy1;
	public static MimiMovableCharacter girl1;

	private static final int animalLimit = 5;
	public static AnimatedComponent boy;
	public static AnimatedComponent girl;

	public static PaneJenny animalPane;
	public static PaneJenny plantPane;
	public static PaneJenny patchPane;
	public static FarmScreenAll farm;

	public FarmScreenAll(int width, int height) {
		super(width, height);
	}

	public static List<Visible> getView(){
		return viewObj;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		//		game.mainScreen.Character c = new game.mainScreen.Character(0,0);
		which = "";
		viewObj = viewObjects;
		farm=this;
		farmPatch = new ArrayList<CropJane>();
		emptyFarmPatch = new ArrayList<EmptyPatch>();
		animalBox = new ArrayList<BoxJenny>();

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
				MainMenu.game.shop = new SamBuyingScreen(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.shop);

			}
		});
		viewObjects.add(shopJenny);


		sleepAlex = new LubnaImageButton(815, 493, 39, 39, "resources/sleep.png", new Action() {


			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.sleep);

			}
		});
		viewObjects.add(sleepAlex);

		itemJane = new Button(175, 500, 80, 30, "Inventory", new Color(230, 235, 210), new Action() {
			public void act() {
				MainMenu.game.inventory = new ErikInventoryScreen(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.inventory);

			}
		});
		viewObjects.add(itemJane);

		patchPane = new PaneJenny(this, 400, 300);
		patchPane.update();
		patchPane.setVisible(false);

		addfarmingPatchJane(viewObjects);
		addAnimalJenny(viewObjects);

		pane = new SelectionPaneJane(this, 400, 300);
		setWhich("crop");
		pane.update();
		pane.setVisible(false);

		plantPane = new PaneJenny(this, 400, 300);
		plantPane.update();
		plantPane.setVisible(false);

		first = new SelectionPaneJane(this, 400, 300);
		setWhich("animal");
		first.update();
		first.setVisible(false);

		animalPane = new PaneJenny(this, 400, 300);
		animalPane.update();
		animalPane.setVisible(false);


		//Main Screen teamwork.
		girl1 = new MimiGirlCharacter(480, 220, 50, 100);
		Thread rungurl = new Thread(girl1);
		rungurl.start();


		boy1 = new JessiBoyCharacter(480, 220, 50, 100);
		Thread runboi = new Thread(boy1);
		runboi.start();

		if(MainMenu.isGirl) {
			viewObjects.add(girl1);
			moveFocus(girl1);
		}
		else if(!MainMenu.isGirl) {
			viewObjects.add(boy1);
			moveFocus(boy1);
		}
		
		viewObjects.add(first);
		viewObjects.add(pane);
		viewObjects.add(patchPane);
		viewObjects.add(plantPane);
		viewObjects.add(animalPane);
	}

	private void addAnimalJenny(List<Visible> viewObjects) {
		int start = 30;
		int space = 150;

		for(int i = 0; i < animalLimit; i++) {
			if(i < 3) {
				BoxJenny box = new BoxJenny(start + (i * 150), 140, "resources/nothing.png", null, viewObjects, i);
				box.update();
				animalBox.add(box);
				viewObjects.add(box);
			}
			else{
				BoxJenny box = new BoxJenny(start + ((i - 3) * 150), 140 + space, "resources/nothing.png", null, viewObjects, i);
				box.update();
				animalBox.add(box);
				viewObjects.add(box);
			}
		}
	}

	public void addObjectToBack(Visible v) {
		super.addObject(v);
		moveToBack(v);
		moveToBack(back);
	}

	private void addfarmingPatchJane(List<Visible> viewObjects) {
		int start = 593;
		int space = 77;
		for(int i=0; i<9; i++) {
			if(i<3) {
				CropJane patch= new CropJane(start+(i*68), 253, 63, 50, "",new Color(200, 125, 10), null, i, new CropImageJane(),-1);
				patch.update();
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
			else if(i>=3&&i<6) {
				CropJane patch= new CropJane(start+((i-3)*68), 260+space, 63, 50,"",new Color(200, 125, 10), null, i, new CropImageJane(),-1);
				patch.update();
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
			else {
				EmptyPatch emptyPatch= new EmptyPatch(start+((i-6)*68), 278+space+space, 63, 50, "For Sale",new Color(200, 125, 10), null,i,i-6);
				emptyPatch.update();
				emptyFarmPatch.add(emptyPatch);
				viewObjects.add(emptyPatch);
			}
		}




		//			EmptyPatch emptyPatch= new EmptyPatch(593, 278+space+space, 63, 50, "For Sale",new Color(200, 125, 10), null,6);
		//			emptyPatch.update();
		//			System.out.println("patch "+emptyFarmPatch.size());
		//			emptyFarmPatch.add(emptyPatch);
		//			viewObjects.add(emptyPatch);

	}


	public static void disableButton(boolean b) {
		for(int i=0; i<farmPatch.size(); i++) {
			farmPatch.get(i).setEnabled(b);
		}
		for(int j=0; j<animalBox.size(); j++) {
			animalBox.get(j).setEnabled(b);
		}
		disableEmptyPatch(b);

	}

	public static String getWhich() {
		// TODO Auto-generated method stub
		return which;
	}

	public void setWhich(String s) {
		which = s;
	}

	public static void disableEmptyPatch(boolean b) {
		for(int j=0; j<emptyFarmPatch.size(); j++) {
			emptyFarmPatch.get(j).setEnabled(b);
		}

	}
	
}