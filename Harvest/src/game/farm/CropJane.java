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
	
	private int crop;
	private int index;
	private CropImage image;
	
	public CropJane(int x, int y, int w, int h, String text, Color color, Action action, int i, CropImage image) {
		super(x, y, w, h,image, new Action() {
			public void act() {
				FarmScreenAll.pane.setX(x-250);
				FarmScreenAll.pane.setY(y-120);
				FarmScreenAll.pane.setVisible(true);
				FarmScreenAll.pane.update();
				FarmScreenAll.pane.setIndex(i);
			}
		});
		index=i;
		this.image=image;
	}
	
	public void crop(int i) {
		image.setIndex(i);
		update();
	}
	
	@Override
	public void drawButton(Graphics2D g, boolean hovered){
		if(image != null) {
			clear();
			System.out.println("redrawing with index "+image.getIndex());
			image.draw(g, hovered);
		}
	}
	
	public void printSelected(int x) {
		System.out.println(x);
	}
	
	public int getIndex() {
		return index;
	}
	public void setColor(Color red) {
		this.setForeground(red);
		
	}
	
}
