package game.mainScreen;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import harvest.MainMenu;

public class SaveButtonJessi extends Button {

	private ImageButton saveButton;
	
	public SaveButtonJessi(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}

	public void initAllObjects(List<Visible> viewObjects) {
		saveButton = new ImageButton(260,350,50,50,"",new Action() {
			
			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.saveMimi);
				
			}
		});
		viewObjects.add(saveButton);
	}
	
}
