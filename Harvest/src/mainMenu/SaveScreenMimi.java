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
		Graphic back = new Graphic(0,0,1,"resources/background.png");
		viewObjects.add(back);
		harval = new TextArea(830, 400, 500, 500, "HARVEST VALLEY");
		harval.setCustomTextColor(Color.white);
		harval.update();
		viewObjects.add(harval);
	}

}
//the pop up asking if you want to save the currency and inventory is a separate screen.