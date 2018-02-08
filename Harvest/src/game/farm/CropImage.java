package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;

public class CropImage implements DrawInstructions {

	private int index;
	Graphic image = new Graphic(0,0,63,50,"resources/farmPatch.PNG");
	
	public CropImage() {
		index=-1;
	}

	
	public void draw(Graphics2D g, boolean highlight) {
		if(highlight){
				float scaleFactor = 0.9f;
				//RescaleOp op = new RescaleOp(scaleFactor, 0, null)
				//BufferedImage light = op.filter(image.getImage(), null);
				g.setColor(new Color(0,0,0,30));
//				g.drawImage(image.getImage(), 0, 0, null);
				if(index!=-1) {
					System.out.println("test "+index);	
					g.drawImage(PlantJane.plants[index].getImage(), 0, 0, null);
				}
				g.fillRect(0, 0, 63, 50);
				//bufferedImage = op.filter(image.getImage(), null);

			}
			else {
//				g.drawImage(image.getImage(), 0, 0, null);
				if(index!=-1) {
					g.drawImage(PlantJane.plants[index].getImage(), 0, 0, null);
				}
			}
			//				g.setColor(new Color(100+(int)(100*Math.random()),100+(int)(100*Math.random()),100+(int)(100*Math.random())));
			//				g.fillRect(22, 0, WIDTH-23, HEIGHT-1);
			//				g.setColor(Color.black);
			//				g.drawString(name, 26, HEIGHT/2-6);
			//				g.drawRect(22, 0, WIDTH-23, HEIGHT-1)
		}


	public void setIndex(int i) {
		index=i;
	}

	public int getIndex() {
		return index;
	}
	
}
