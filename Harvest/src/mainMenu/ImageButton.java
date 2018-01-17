package mainMenu;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;
/**
 * A simple class for making imageButton brightened when hovered.
 * @author Lubna Khalid
 *
 */
public class ImageButton extends CustomImageButton {

	public ImageButton(int x, int y, int w, int h, String imageAddress, Action action) {
		super(x, y, w, h, new DrawInstructions() {

			Graphic image = new Graphic(0,0,imageAddress);
			
			@Override
			public void draw(Graphics2D g, boolean highlight) {
				g.drawImage(image.getImage(), 0, 0, null);
				if(!highlight) {
					g.setColor(new Color(0,0,0,50));
					g.fillRect(0, 0, image.getWidth(), image.getHeight());
				}
			}
		}, action);
		// TODO Auto-generated constructor stub
	}

}
