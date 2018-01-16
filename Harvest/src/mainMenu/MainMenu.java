package mainMenu;

import guiTeacher.GUIApplication;

public class MainMenu extends GUIApplication {

	public MainMenu(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		MenuScreenLubna screen = new MenuScreenLubna(getWidth(), getHeight());
		setScreen(screen);
	}
	
	public static void main(String[] args) {
		MainMenu s = new MainMenu(800,600);
		Thread runner = new Thread(s);
		runner.start();
	}

}