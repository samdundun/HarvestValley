package mainMenu;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SaveScreenMimi extends ClickableScreen {
	
	//the pop up asking if you want to save the currency and inventory is a separate screen.
	
	private TextArea save;

	public SaveScreenMimi(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic back = new Graphic(0, 0, getWidth(), getHeight(), "resources/background.png");
		viewObjects.add(back);
//		harval = new TextArea(315, 180, 700, 700, "HARVEST VALLEY");
//		harval.setCustomTextColor(Color.black);
//		harval.update();//143
//		viewObjects.add(harval);
		Graphic title = new Graphic(240, 40, 400, 400, "resources/harvestvalley.png");
		viewObjects.add(title);
		// put a box behind this text
		save = new TextArea(135, 200, 600, 250, "You are about to save the items in your inventory and your current amount of money. Progress made in the farm and barn will not be saved. Continue?");
		save.setCustomTextColor(Color.black);
		save.update();//143
		viewObjects.add(save);
		Graphic exit = new Graphic(500, 430, 100, 100, "resources/exitButton.png");
		viewObjects.add(exit);
	}

}