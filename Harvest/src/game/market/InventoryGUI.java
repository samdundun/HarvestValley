package game.market;


import guiTeacher.GUIApplication;

public class InventoryGUI extends GUIApplication {

	private static final long serialVersionUID = 7548071104587737267L;
	
	public static InventoryGUI market;
	public static SamBuyingScreen buy;
	public static ErikSellingScreen sell;
	
	public InventoryGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public void initScreen() {
		buy = new SamBuyingScreen(getWidth(), getHeight());
		sell = new ErikSellingScreen(getWidth(), getHeight());
		ErikInventoryScreen whatever = new ErikInventoryScreen(getWidth(),getHeight());
		setScreen(whatever);

	}

	public static void main(String[] args) {
		market = new InventoryGUI(800, 600);
		Thread runner = new Thread(market);
		runner.start();
		
	}

}
