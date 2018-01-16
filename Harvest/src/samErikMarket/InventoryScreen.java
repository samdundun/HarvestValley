package samErikMarket;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class InventoryScreen extends ClickableScreen implements FileRequester{

	ArrayList<Inventory> a;
	
	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

}
