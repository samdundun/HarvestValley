package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;

import game.mainScreen.ImageButton;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;

public class CropJane extends CustomImageButton {
	
	private int index;
	public CropJane(int x, int y, int w, int h, String text, Color color, Action action, int i) {
		super(x, y, w, h,new DrawInstructions() {

			Graphic image = new Graphic(0,0,48,48,"resources/farmPatch.PNG");

			@Override
			public void draw(Graphics2D g, boolean highlight) {
				if(highlight){
					float scaleFactor = 0.9f;
					//RescaleOp op = new RescaleOp(scaleFactor, 0, null)
					//BufferedImage light = op.filter(image.getImage(), null);
					g.drawImage(image.getImage(), 0, 0, null);
					g.setColor(new Color(0,0,0,30));
					g.fillRect(0, 0, w, h);
					//bufferedImage = op.filter(image.getImage(), null);

				}
				else {
					g.drawImage(image.getImage(), 0, 0, null);
				}
				//				g.setColor(new Color(100+(int)(100*Math.random()),100+(int)(100*Math.random()),100+(int)(100*Math.random())));
				//				g.fillRect(22, 0, WIDTH-23, HEIGHT-1);
				//				g.setColor(Color.black);
				//				g.drawString(name, 26, HEIGHT/2-6);
				//				g.drawRect(22, 0, WIDTH-23, HEIGHT-1)
			}
		}, new Action() {
			public void act() {
				FarmScreenAll.pane.setX(x-250);
				FarmScreenAll.pane.setY(y-120);
				FarmScreenAll.pane.setVisible(true);
				FarmScreenAll.pane.update();
				FarmScreenAll.pane.setIndex(i);
			}
		});
		index=i;
	}
//	 public updateImage(Graphic img) {
//		 
//	 }
	public void printSelected(int x) {
		System.out.println(x);
	}
	
	public int getIndex() {
		return index;
	}
	public void setColor(Color red) {
		this.setForeground(red);
		
	}
	public void setImage(int imageIndex) {
		
		
	}
}
