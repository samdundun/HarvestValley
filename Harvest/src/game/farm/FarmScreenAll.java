package game.farm;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;

import game.mainScreen.BoyCharacter;
import game.mainScreen.GirlCharacter;
import game.mainScreen.ImageButton;
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
	private ImageButton sleepAlex;
	private static String which;
	private static final int animalLimit = 5;
	private static List<Visible> viewObj;
	public static SelectionPaneJane pane;
	public static SelectionPaneJane first;

	public static ArrayList<CropJane> farmPatch;
	public static ArrayList<EmptyPatch> emptyFarmPatch;
	public static ArrayList<BoxJenny> animalBox;

	public static AnimatedComponent boy;
	public static AnimatedComponent girl;

	private int currentAnimals;

	public static PaneJenny animalPane;
	public static PaneJenny plantPane;
	public static PaneJenny patchPane;
	
	public FarmScreenAll(int width, int height) {
		super(width, height);
	}
	
	public static List<Visible> getView(){
		return viewObj;
	}

	public static ArrayList<BoxJenny> getAnimalBox() {
		return animalBox;
	}

	public void initAllObjects(List<Visible> viewObjects) {
		which = "";
		viewObj = viewObjects;
		farmPatch = new ArrayList<CropJane>();
		emptyFarmPatch = new ArrayList<EmptyPatch>();
		animalBox = new ArrayList<BoxJenny>();
		//animalBox = new ArrayList<Test>();

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

		sleepAlex = new ImageButton(815, 493, 39, 39, "resources/sleep.png", new Action() {

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
		
		//Mainscreen team work
		girl = game.mainScreen.GirlCharacter.addGirl(viewObjects);
		Thread rungurl = new Thread(girl);
		rungurl.start();
		
		
 		boy = game.mainScreen.BoyCharacter.addBoy(viewObjects);
 		Thread runboi = new Thread(boy);
 		runboi.start();
//		viewObjects.add(boy);
//
//		viewObjects.add(girl);
 		
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
		
		if(MainMenu.isGirl) {
			viewObjects.add(girl);
		}
		else if(!MainMenu.isGirl) {
			viewObjects.add(boy);
		}
		viewObjects.add(first);
		viewObjects.add(animalPane);
		viewObjects.add(patchPane);
		viewObjects.add(plantPane);
		viewObjects.add(pane);
	}
//	public static void patchPaneCreate() {
//			System.out.println(FarmScreenAll.farmPatch.size());
//			FarmScreenAll.patchPane.getLabel().setText("Enlarge your farm!");
//			FarmScreenAll.patchPane.getItem().setText("Patch for $1000");
////			FarmScreenAll.patchPane.setX(x-250);
////			FarmScreenAll.patchPane.setY(y-120);
//			FarmScreenAll.patchPane.setSrc("resources/farmPatch.png");
//			FarmScreenAll.patchPane.updateImg(FarmScreenAll.getView());
//			FarmScreenAll.patchPane.setVisible(true);
//			FarmScreenAll.disableEmptyPatch(false,1);
//			FarmScreenAll.patchPane.getHarvest().setAction(new Action() {
//				
//				@Override
//				public void act() {
//					//FarmScreenAll.removeEmptyPatch();
////					CropJane newPatch = convertToPatch();
////					newPatch.update();
////					FarmScreenAll.farmPatch.add(newPatch);
////					FarmScreenAll.getView().add(newPatch);
////					FarmScreenAll.patchPane.setVisible(false);
////					FarmScreenAll.patchPane.getImg().setVisible(false);
////					FarmScreenAll.disableEmptyPatch(true,1);
////					System.out.println(FarmScreenAll.emptyFarmPatch.size());
//				}
//
////				private CropJane convertToPatch() {
////					CropJane newPatch = new CropJane(x+68, y, w, h, "", color, null, i, new CropImageJane());
////					return newPatch;
////				}
//			});
//		
//	
//	}
	
	private void addAnimalJenny(List<Visible> viewObjects) {
		int start = 30;
		int space = 150;

		for(int i = 0; i < animalLimit; i++) {
			if(i < 3) {
				BoxJenny box = new BoxJenny(start + (i * 150), 140, "resources/star.png", null, viewObjects, i);
				box.update();
				animalBox.add(box);
				viewObjects.add(box);
			}
			else{
				BoxJenny box = new BoxJenny(start + ((i - 3) * 150), 140 + space, "resources/star.png", null, viewObjects, i);
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
		for(int i=0; i<6; i++) {
			if(i<3) {
				CropJane patch= new CropJane(start+(i*68), 253, 63, 50, "",new Color(200, 125, 10), null, i, new CropImageJane());
				patch.update();
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
			else if(i>=3&&i<6) {
				CropJane patch= new CropJane(start+((i-3)*68), 260+space, 63, 50,"",new Color(200, 125, 10), null, i, new CropImageJane());
				patch.update();
				farmPatch.add(patch);
				viewObjects.add(patch);
			}
		}
		for(int j=0; j<3; j++) {
			EmptyPatch emptyPatch= new EmptyPatch(729-(j*68), 278+space+space, 63, 50, "For Sale",new Color(200, 125, 10), null,j+6);
			emptyPatch.update();
			System.out.println("patch "+emptyFarmPatch.size());
			emptyFarmPatch.add(emptyPatch);
			viewObjects.add(emptyPatch);
		
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
		
	}

	public static String getWhich() {
		// TODO Auto-generated method stub
		return which;
	}

	public void setWhich(String s) {
		which = s;
	}

	public static void disableEmptyPatch(boolean b, int i) {
		for(int j=0; j<emptyFarmPatch.size(); j++) {
			emptyFarmPatch.get(j).setEnabled(b);
		}
		
	}

	public static void removeEmptyPatch() {
		for(int i=emptyFarmPatch.size()-1; i==0; i++) {
			emptyFarmPatch.replaceAll(null);
//			emptyFarmPatch.remove(i);
			viewObj.remove(emptyFarmPatch.get(i));
		}
		for(int j=0; j<emptyFarmPatch.size(); j++) {
			emptyFarmPatch.get(j).update();
		}
		
		
	}
	
}