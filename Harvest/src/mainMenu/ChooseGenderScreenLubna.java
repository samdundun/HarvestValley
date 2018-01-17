package mainMenu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class ChooseGenderScreenLubna extends ClickableScreen implements Runnable {


	private ImageButton girl;
	private ImageButton boy;
	private Graphic back;
	private Graphic title;

	public ChooseGenderScreenLubna(int width, int height) {
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
		back = new Graphic(0,0,getWidth(),getHeight(),"resources/background.png");
		viewObjects.add(back);
		girl = new ImageButton(260,350,150,150,"resources/girlButton.png",new Action() {
			
			@Override
			public void act() {
				MainMenu.isGirl = true;
				MainMenu.game.setScreen(MainMenu.nextScreen);
				
			}
		});
		viewObjects.add(girl);
		boy = new ImageButton(470,350, 150,150,"resources/boyButton.png", new Action() {
			
			@Override
			public void act() {
				MainMenu.isGirl= false;
				MainMenu.game.setScreen(MainMenu.nextScreen);
				
			}
		});
		viewObjects.add(boy);
		title = new Graphic(150, 60, 600, 600, "resources/harvestvalley.png");
		viewObjects.add(title);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}

