package harvest;

import java.awt.Font;
import java.io.File;

import game.farm.FarmScreenAll;
import game.mainScreen.GirlCharacter;
import game.farm.SleepAlex;
import game.mainScreen.ChooseGenderScreenLubna;
import game.mainScreen.MenuScreenLubna;
import game.mainScreen.ObjectivesScreenJessi;
import game.mainScreen.PlaceHolderScreen;
import game.mainScreen.SaveScreenMimi;
import game.mainScreen.Sound;
import game.market.BuyingScreen;
import game.market.InventoryScreen;
import game.market.SellingScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.Graphic;
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
	public static SleepAlex sleep;
	
//	public static boolean isSaved;
	
//	private Sound sound;
	
	public MainMenu(int width, int height) {
		super(width, height);
		setIconImage(new Graphic(0, 0, 25, 25, "resources/icon.png").getImage());
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
		sleep = new SleepAlex(getWidth(), getHeight());
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

	//Sound.sound1.play();

	}

	public static void main(String[] args) {

		game = new MainMenu(870,550);
		Thread runner = new Thread(game);

		runner.start();
	}
	//

}
