// class not used
// the character and items in the inventory are auto saved
package game.mainScreen;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import harvest.MainMenu;

public class JessiSaveButton extends Button {

	private LubnaImageButton saveButton;
	
	public JessiSaveButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}

	public void initAllObjects(List<Visible> viewObjects) {
		saveButton = new LubnaImageButton(260,350,50,50,"",new Action() {
			
			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.saveMimi);
				
			}
		});
		viewObjects.add(saveButton);
	}
	
}
