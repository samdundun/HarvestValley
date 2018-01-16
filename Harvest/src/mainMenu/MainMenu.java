package mainMenu;

import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;

public class MainMenu extends GUIApplication {

	public MainMenu(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		try {
			File fontFile = new File("resources/burnstown dam.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(36f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MenuScreenLubna screen = new MenuScreenLubna(getWidth(), getHeight());
		SaveScreenMimi savemimi = new SaveScreenMimi(getWidth(), getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		MainMenu s = new MainMenu(800,600);
		Thread runner = new Thread(s);
		runner.start();
	}

}