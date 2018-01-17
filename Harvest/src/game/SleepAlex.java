package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ImageTextButton;

public class SleepAlex extends ImageTextButton {//can use ImageTextButton, CustomImageButton, ClickableGraphic
	
	//Holiday card is in orcmathGui version2.2
	
	private Action action;
	//Image icon;
	ImageIcon icon = createImageIcon("sleep.png",
            "Click here");
	ImageIcon myicon = new ImageIcon("sleep.png");

	public SleepAlex(String text, Image icon, int x, int y, int width, int height, Action action) {
		super("Click here",icon, 0, 0, 150, 150, action);
		this.icon = icon;
		update();
	}
	
	public void update(Graphics2D g) {
		super.update(g);
		if(icon != null){
			g.drawImage(icon, 2, 0, null);
		}
	}
	
	public ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		return new ImageIcon(imgURL, description);
	}

	public static void main(String[] args) {

	}

	public void act(){
		if(action != null) action.act();
	}
	
	public void setAction(Action a){
		this.action = a;
	}
}
