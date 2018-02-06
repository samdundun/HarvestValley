package game.mainScreen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.*;
import guiTeacher.components.TextField;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import harvest.MainMenu;

public class SaveScreenMimi extends Pane {
	
	private static FocusController FarmScreenAll;
	//the pop up asking if you want to save the currency and inventory is a separate screen.
	
	private TextArea text;
	private Button exit;
	private Button save;
	private SavePaneMimi SavePaneMimi;

	public SaveScreenMimi(int width, int height) {
		super(FarmScreenAll, width, height, height, height);
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
		text = new TextArea(135, 190, 600, 230, "You have saved the items in your inventory and your current amount of money. Progress made in the farm and barn cannot be saved.");
		text.setCustomTextColor(Color.black);
//		save.update();//143
//		viewObjects.add(save);
//		Graphic exit = new Graphic(390, 430, 100, 100, "resources/exitButton.png");
//		viewObjects.add(exit);
//		exit = new ImageButton(690, 410, 150, 150, "resources/exitButton.png",new Action() {
//			
//			@Override
//			public void act() {
//				MainMenu.isExit= true;
//				System.exit(0); // placeholder screen. replace this with the farm/barn screen.
//			}
//		});
//		viewObjects.add(exit);
		exit = new Button (690, 410, 150, 150, "OK", Color.red, new Action() {
			
			@Override
			public void act() {
				SavePaneMimi.setVisible(false);
			}
		});
		
		
	}

}