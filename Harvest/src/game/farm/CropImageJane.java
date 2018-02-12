package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;

public class CropImageJane implements DrawInstructions {

	private int index;
	private Graphic image; 
	
	public CropImageJane() {
		index=-1;
	}

	
	public void draw(Graphics2D g, boolean highlight) {
		image = new Graphic(0,0,63,50,"resources/farmPatch.png");
		if(highlight){
				float scaleFactor = 0.9f;
				//RescaleOp op = new RescaleOp(scaleFactor, 0, null)
				//BufferedImage light = op.filter(image.getImage(), null);
				g.setColor(new Color(0,0,0,30));
				g.fillRect(0, 0, 63, 50);
					if(index==-1) {
						g.drawImage(image.getImage(), 0, 0, null);
					}	
					else if(index==0&& index==5) {
						g.drawImage(PlantJane.plants[index].getImage(), 35, 0, null);
					}
					else {
						g.drawImage(PlantJane.plants[index].getImage(), 15, 0, null);
					}
				//bufferedImage = op.filter(image.getImage(), null);

			}
		.
			else {
				if(index==-1) {
					g.drawImage(image.getImage(), 0, 0, null);
				}
				else if(index==0&& index==5) {
					g.drawImage(PlantJane.plants[index].getImage(), 35, 0, null);
				}
				else {
					g.drawImage(PlantJane.plants[index].getImage(), 15, 0, null);
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
