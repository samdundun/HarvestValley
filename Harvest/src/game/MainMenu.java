package game;

import java.awt.Font;
import java.io.File;

import guiTeacher.GUIApplication;
import guiTeacher.components.StyledComponent;
import guiTeacher.userInterfaces.Screen;

public class MainMenu extends GUIApplication {
	
	public static MainMenu game;
	public static boolean isGirl;
	public static boolean isNew;
	public static boolean isLoad;
	public static boolean isExit;
	public static boolean isObj;
	public static ChooseGenderScreenLubna screen2;
	public static FarmScreenAll farmScreen;
	public static BuyingScreen shop;
	public static SellingScreen sell;
	public static MenuScreenLubna screen;
	public static ObjectivesScreenJessi objectives;
	public static InventoryScreen inventory;
	public static PlaceHolderScreen placeHolder;
	public static SaveScreenMimi saveMimi;
	
	public MainMenu(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
//		try {
//			File fontFile = new File("resources/burnstown dam.ttf");
//			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
//			Font baseFont=font.deriveFont(36f);
//			StyledComponent.setBaseFont(baseFont);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		screen = new MenuScreenLubna(getWidth(), getHeight());
		farmScreen = new FarmScreenAll(getWidth(),getHeight());
		shop = new BuyingScreen(getWidth(),getHeight());
		screen2 = new ChooseGenderScreenLubna(getWidth(), getHeight());
		inventory = new InventoryScreen(getWidth(), getHeight());
		sell = new SellingScreen(getWidth(), getHeight());
		placeHolder = new PlaceHolderScreen(getWidth(), getHeight());
		//don't delete the place holder please.

		 saveMimi = new SaveScreenMimi(getWidth(), getHeight());
		
		
		objectives = new ObjectivesScreenJessi(getWidth(), getHeight());

		setScreen(screen);

	}

	public static void main(String[] args) {

		game = new MainMenu(870,550);
		Thread runner = new Thread(game);

		runner.start();
	}

}