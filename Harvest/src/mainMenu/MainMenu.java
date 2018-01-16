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
		ChooseGenderScreen screen2 = new ChooseGenderScreen(getWidth(), getHeight());
		setScreen(screen2);
	}
	
	

	public static void main(String[] args) {
		MainMenu s = new MainMenu(870,550);
		Thread runner = new Thread(s);
		runner.start();
	}

}