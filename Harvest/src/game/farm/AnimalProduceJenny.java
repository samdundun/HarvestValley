package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;

import game.market.ErikItem;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;

public class AnimalProduceJenny extends CustomImageButton {
	
	public static final ErikItem[] produce = {new ErikItem("Brown Eggs", "", 300, 0, 0),new ErikItem("White Eggs", "", 50, 1,0),
			new ErikItem("Black Eggs", "", 150, 2, 0),new ErikItem("Wool", "", 100, 3,0),
			new ErikItem("Milk", "", 200, 4,0),new ErikItem("Meat", "", 400, 5,0)};
	
	public static final Graphic[] items = {new Graphic(0,0,48,48,"resources/brownEgg.png"),
			new Graphic(0,0,48,48,"resources/whiteEgg.png"),new Graphic(0,0,48,48,"resources/blackEgg.png"),
			new Graphic(0,0,48,48,"resources/wool.png"),new Graphic(0,0,48,48,"resources/milk.png"),
			new Graphic(0,0,48,48,"resources/meat.png")};

	private boolean selected;
	public static final int HEIGHT = 48;
	public static final int WIDTH = 48;

	public AnimalProduceJenny(int index) {
		super(0,0,48,48,new DrawInstructions() {

		Graphic image = items[index];

		@Override
		public void draw(Graphics2D g, boolean highlight) {
			if(highlight){
				float scaleFactor = 0.9f;
				g.drawImage(image.getImage(), 0, 0, null);
				g.setColor(new Color(0,0,0,30));
				g.fillRect(0, 0, WIDTH, HEIGHT);

			}
			else {
				g.drawImage(image.getImage(), 0, 0, null);
			}
		}
	}, null);
		selected = false;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return selected;
	}
}
