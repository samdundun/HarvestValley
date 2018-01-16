package game;

import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class FarmScreenAll extends FullFunctionScreen {
	
	private Graphic back;
	private ArrayList<CropJane> crops;

	public FarmScreenAll(int width, int height) {
		super(width, height);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		back = new Graphic(0, 0, "resources/farm.PNG");
		viewObjects.add(back);
	}

}
