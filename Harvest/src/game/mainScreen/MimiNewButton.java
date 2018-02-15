package game.mainScreen;

import java.util.List;

import game.farm.FarmScreenAll;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import harvest.MainMenu;

public class MimiNewButton extends Button{
	
	private LubnaImageButton newbutton;

	public MimiNewButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		Thread runner = new Thread();
		runner.start();
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		newbutton = new LubnaImageButton(260,350,150,150,"",new Action() {
			
			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.screen2);
				
			}
		});
		viewObjects.add(newbutton);
	}

}
