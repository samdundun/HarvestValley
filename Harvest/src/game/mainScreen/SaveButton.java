package game.mainScreen;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import harvest.MainMenu;

public class SaveButton extends Button {

	private Button save;
	
	public SaveButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}

	public void initAllObjects(List<Visible> viewObjects) {
		save = new Button(260,350,150,150,"SAVE",new Action() {
			
			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.screen2);
				
			}
		});
		viewObjects.add(save);
	}
	
}
