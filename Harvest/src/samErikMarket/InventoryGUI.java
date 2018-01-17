package samErikMarket;

import guiTeacher.GUIApplication;

public class InventoryGUI extends GUIApplication {

	private static final long serialVersionUID = 7548071104587737267L;
	
	public InventoryGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		InventoryScreen screen = new InventoryScreen(getWidth(), getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {
		InventoryGUI invent = new InventoryGUI(800, 600);
		Thread runner = new Thread(invent);
		runner.start();
		
	}

}
