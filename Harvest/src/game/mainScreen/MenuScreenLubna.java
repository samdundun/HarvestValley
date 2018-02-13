package game.mainScreen;

import java.awt.Color;
import java.util.List;

import game.farm.FarmScreenAll;
import game.market.BuyingScreen;
import game.market.Inventory;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import harvest.MainMenu;

public class MenuScreenLubna extends ClickableScreen implements Runnable {

	private Graphic title;
	private ImageButton newGame;
	private ImageButton load;
	private ImageButton exit;
	private ImageButton obj;
//	private ImageButton save;
	private Button sound;

	private Inventory invent;
	
	public MenuScreenLubna(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		invent = new Inventory();
		Graphic back = new Graphic(0,0,getWidth(),getHeight(),"resources/background.png");
		viewObjects.add(back);
		title = new Graphic(150, 60, 600, 600, "resources/harvestvalley.png");
		viewObjects.add(title);

		newGame = new ImageButton(180,350,150,150,"resources/newButton.png",new Action() {

			@Override
			public void act() {
				invent = new Inventory();
				invent.addBasics();
				invent.save();
				MainMenu.game.screen2 = new ChooseGenderScreenLubna(getWidth(), getHeight());
				MainMenu.game.setScreen(MainMenu.screen2);

			}
		});
		viewObjects.add(newGame);
		load = new ImageButton(380,350, 150,150,"resources/loadButton.png", new Action() {

			@Override
			public void act() {
				invent.load();
				MainMenu.game.setScreen(MainMenu.farmScreen);
				//using farmScreen rn but eventually will use the saved info.

			}
		});
		viewObjects.add(load);
		exit = new ImageButton(580,350, 150,150,"resources/exitButton.png", new Action() {

			@Override
			public void act() {
				MainMenu.isExit= true;
				System.exit(0);
				// place holder, i don't know how to exit the java program.
			}
		});
		viewObjects.add(exit);
		obj = new ImageButton(750,480, 60,60,"resources/objective.png", new Action() {

			@Override
			public void act() {
				MainMenu.isObj= true;
				MainMenu.game.setScreen(MainMenu.objectives);
				MainMenu.objectives.displayObjectives();

			}
		});
		viewObjects.add(obj);
//		save = new ImageButton(680,480, 60,60,"resources/saveButton.png", new Action() {
//
//			@Override
//			public void act() {
//				MainMenu.isSaved= true;
//				MainMenu.game.setScreen(MainMenu.saveMimi);
//
//			}
//		});
//		viewObjects.add(save);
		sound = new Button(90, 500, 80, 30, "Sound", new Color(230, 235, 210), new Action() {
			public void act() {
				MainMenu.soundTracks = new SoundScreen(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.soundTracks);

			}
		});
		viewObjects.add(sound);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}


}
