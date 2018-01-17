package mainMenu;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class MenuScreenLubna extends ClickableScreen implements Runnable {

	private Graphic title;

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

		
		//Graphic obj = new Graphic(getWidth()/2,getHeight()/2,1,"resources/objective.png");
		////viewObjects.add(obj);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}


}
