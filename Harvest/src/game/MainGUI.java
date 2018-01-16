package game;

import guiTeacher.GUIApplication;

public class MainGUI extends GUIApplication {

	public MainGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		FarmScreenAll screen = new FarmScreenAll(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		MainGUI m = new MainGUI(864, 540);
		Thread go = new Thread(m);
		go.start();
	}

}
