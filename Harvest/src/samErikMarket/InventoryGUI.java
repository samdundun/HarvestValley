package samErikMarket;

import guiTeacher.GUIApplication;

public class InventoryGUI extends GUIApplication {

	private static final long serialVersionUID = 7548071104587737267L;
	
	public static InventoryGUI market;
	public static BuyingScreen buy;
	public static SellingScreen sell;
	
	public InventoryGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		buy = new BuyingScreen(getWidth(), getHeight());
		sell = new SellingScreen(getWidth(), getHeight());
		InventoryScreen whatever = new InventoryScreen(getWidth(),getHeight());
		setScreen(whatever);

	}

	public static void main(String[] args) {
		market = new InventoryGUI(800, 600);
		Thread runner = new Thread(market);
		runner.start();
		
	}

}
