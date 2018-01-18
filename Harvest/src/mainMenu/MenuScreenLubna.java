package mainMenu;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class MenuScreenLubna extends ClickableScreen implements Runnable {

	private Graphic title;
	private ImageButton newGame;
	private ImageButton load;
	private ImageButton exit;
	private ImageButton obj;

	public MenuScreenLubna(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic back = new Graphic(0,0,getWidth(),getHeight(),"resources/background.png");
		viewObjects.add(back);
		title = new Graphic(150, 60, 600, 600, "resources/harvestvalley.png");
		viewObjects.add(title);

		newGame = new ImageButton(200,350,150,150,"resources/newButton.png",new Action() {
			/**
			 * mimi's part?
			 */
			@Override
			public void act() {
				MainMenu.isNew = true;
				MainMenu.game.setScreen(MainMenu.screen2);
				
			}
		});
		viewObjects.add(newGame);
		load = new ImageButton(400,350, 150,150,"resources/loadButton.png", new Action() {
			
			@Override
			public void act() {
				/**
				 * lubna's part.
				 */
				MainMenu.isLoad= false;
				MainMenu.game.setScreen(MainMenu.nextScreen);
				
			}
		});
		viewObjects.add(load);
		exit = new ImageButton(600,350, 150,150,"resources/exitButton.png", new Action() {
			/*
			 * lubna's part.
			 * (non-Javadoc)
			 * @see guiTeacher.components.Action#act()
			 */
			@Override
			public void act() {
				MainMenu.isExit= false;
				MainMenu.game.setScreen(MainMenu.nextScreen);
				
			}
		});
		viewObjects.add(exit);
		obj = new ImageButton(750,480, 60,60,"resources/objective.png", new Action() {
			/*
			 * jessi's part.
			 * (non-Javadoc)
			 * @see guiTeacher.components.Action#act()
			 */
			@Override
			public void act() {
				MainMenu.isObj= false;
				MainMenu.game.setScreen(MainMenu.objectives);
				
			}
		});
		viewObjects.add(obj);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}


}
