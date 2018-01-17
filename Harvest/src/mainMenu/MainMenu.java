package mainMenu;

import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import guiTeacher.userInterfaces.Screen;

public class MainMenu extends GUIApplication {
	
	public static MainMenu game;
	public static boolean isGirl;
	public static ChooseGenderScreenLubna screen2;
	public static Screen nextScreen;
	
	
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
		nextScreen = new PlaceHolderScreen(getWidth(),getHeight());
		
		screen2 = new ChooseGenderScreenLubna(getWidth(), getHeight());

		SaveScreenMimi savemimi = new SaveScreenMimi(getWidth(), getHeight());
		
		
		//ObjectivesJessi objectives = new ObjectivesJessi(getWidth(), getHeight());
	
		
		//setScreen(objectives);
//143

		SaveScreenMimi savemimi = new SaveScreenMimi(getWidth(), getHeight());
		setScreen(screen);

	}

	public static void main(String[] args) {

		game = new MainMenu(870,550);
		Thread runner = new Thread(game);

		runner.start();
	}

}