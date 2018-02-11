package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.DrawInstructions;
import guiTeacher.interfaces.Visible;

public class BoxJenny extends CustomImageButton implements Clickable{

	public BoxJenny(int x, int y, String imageAddress, Action action, List<Visible> viewObjects, int i) {
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
				FarmScreenAll.first.setX(x + 100);
				FarmScreenAll.first.setY(y - 100);
				FarmScreenAll.first.setVisible(true);
				FarmScreenAll.first.update();
				FarmScreenAll.first.setIndex(i);
				FarmScreenAll.disableButton(false);
			}
		});
	}
}
