package mainMenu;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class SaveScreenMimi extends ClickableScreen {
	
	private TextArea harval;

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
		Graphic title = new Graphic(150, 60, 600, 600, "resources/harvestvalley.png");
		viewObjects.add(title);
	}

}
//the pop up asking if you want to save the currency and inventory is a separate screen.