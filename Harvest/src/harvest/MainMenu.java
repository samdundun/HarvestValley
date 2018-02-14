package harvest;

import java.awt.Font;
import java.io.File;

import game.farm.FarmScreenAll;
import game.mainScreen.MimiGirlCharacter;
import game.farm.SleepAlex;
import game.mainScreen.LubnaChooseGenderScreen;
import game.mainScreen.LubnaMenuScreen;
import game.mainScreen.JessiMusicPlayer;
import game.mainScreen.JessiObjectivesScreen;
import game.mainScreen.PlaceHolderScreen;
import game.mainScreen.MimiSaveScreen;
import game.mainScreen.JessiSound;
import game.mainScreen.JessiSoundScreen;
import game.market.SamBuyingScreen;
import game.market.ErikInventoryScreen;
import game.market.ErikSellingScreen;
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
	public static LubnaChooseGenderScreen screen2;
	public static FarmScreenAll farmScreen;
	public static SamBuyingScreen shop;
	public static ErikSellingScreen sell;
	public static LubnaMenuScreen screen;
	public static JessiObjectivesScreen objectives;
	//public static JessiSoundScreen soundTracks;
	public static ErikInventoryScreen inventory;
	public static PlaceHolderScreen placeHolder;
	public static MimiSaveScreen saveMimi;
	public static SleepAlex sleep;
	
//	public static boolean isSaved;
	
	private JessiSound sound;
	
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

		screen = new LubnaMenuScreen(getWidth(), getHeight());
		sleep = new SleepAlex(getWidth(), getHeight());
		farmScreen = new FarmScreenAll(getWidth(),getHeight());
		shop = new SamBuyingScreen(getWidth(),getHeight());
		screen2 = new LubnaChooseGenderScreen(getWidth(), getHeight());
		inventory = new ErikInventoryScreen(getWidth(), getHeight());
		sell = new ErikSellingScreen(getWidth(), getHeight());
		placeHolder = new PlaceHolderScreen(getWidth(), getHeight());
		//don't delete the place holder please.

		saveMimi = new MimiSaveScreen(getWidth(), getHeight());
		
		
		objectives = new JessiObjectivesScreen(getWidth(), getHeight());
		
		
		//soundTracks = new JessiSoundScreen(getWidth(), getHeight());

		setScreen(screen);

	JessiSound.sound1.play();
	}

	public static void main(String[] args) {

		game = new MainMenu(870,550);
		Thread runner = new Thread(game);

		runner.start();
		
		JessiMusicPlayer player = new JessiMusicPlayer("sound","sound2","sound3","sound4","sound5");
		//06 - Spring (The Valley Comes Alive) sound
		//05 - Spring (It's A Big World Outside) sound2
		//13 - Summer (Nature's Crescendo) sound3
		//27 - Winter (Nocturne Of Ice) sound4
		//20 - Fall (The Smell Of Mushroom) sound5
	}
	//

}
