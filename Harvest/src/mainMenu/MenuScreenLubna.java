package mainMenu;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class MenuScreenLubna extends ClickableScreen implements Runnable {
	
	

	public MenuScreenLubna(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic back = new Graphic(0,0,1,"resources/background.png");
		viewObjects.add(back);
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	
}
