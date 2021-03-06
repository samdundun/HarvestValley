package game.mainScreen;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import game.farm.FarmScreenAll;
import game.market.SamInventory;
import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import harvest.MainMenu;

public class LubnaChooseGenderScreen extends ClickableScreen implements Runnable {


	private LubnaImageButton girl;
	private LubnaImageButton boy;
	private Graphic back;
	private Graphic title;
	private static boolean girlAction; 
	
	private SamInventory invent;

	public LubnaChooseGenderScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}
	
//	public void resize(int w, int h){
//		back.loadImages("resources/background.png", w, h);
//		back.update();
//		girl.setX(w/2-girl.getWidth());
//		girl.setY(h/2-girl.getHeight());
//		boy.setX(w/2+boy.getWidth());
//		boy.setY(h/2+boy.getHeight());
//		super.resize(w, h);
//	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		invent = new SamInventory();
		invent.load();
		
		back = new Graphic(0,0,getWidth(),getHeight(),"resources/background.png");
		viewObjects.add(back);
		girl = new LubnaImageButton(260,350,150,150,"resources/girlButton.png",new Action() {
			
			@Override
			public void act() {
				MainMenu.isGirl = true;
				invent.save();
				MainMenu.game.farmScreen = new FarmScreenAll(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.farmScreen);
				
			}
		});
		viewObjects.add(girl);
		boy = new LubnaImageButton(470,350, 150,150,"resources/boyButton.png", new Action() {
			
			@Override
			public void act() {
				MainMenu.isGirl = false;
				invent.save();
				MainMenu.game.farmScreen = new FarmScreenAll(getWidth(),getHeight());
				MainMenu.game.setScreen(MainMenu.farmScreen);
				
			}
		});
		
		
		viewObjects.add(boy);
		title = new Graphic(150, 60, 600, 600, "resources/harvestvalley.png");
		viewObjects.add(title);
	}

	@Override
	public void run() {
		

	}
	//
}

