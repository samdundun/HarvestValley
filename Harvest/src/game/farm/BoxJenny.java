package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;

public class BoxJenny extends CustomImageButton {

	public BoxJenny(int x, int y, String imageAddress, Action action) {
		super(x, y, new Graphic(0,0,imageAddress).getWidth(), new Graphic(0,0,imageAddress).getHeight(), new DrawInstructions() {
			Graphic image = new Graphic(0,0,imageAddress);

			public void draw(Graphics2D g, boolean highlight) {
				g.drawImage(image.getImage(), 0, 0, null);
				if(highlight) {
					g.setColor(new Color(0,0,0,20));
					g.fillRect(0, 0, image.getWidth(), image.getHeight());
				}
			}
		}, new Action() {
			public void act() {
				FarmScreenAll.animalPane.setX(x-250);
				FarmScreenAll.animalPane.setY(y);
				FarmScreenAll.animalPane.setVisible(true);
				FarmScreenAll.animalPane.update();
			}
		});
	}
}
