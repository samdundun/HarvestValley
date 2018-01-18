package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.ImageTextButton;

public class SleepAlex extends ClickableGraphic {//can use ImageTextButton, CustomImageButton, ClickableGraphic
	
	//Holiday card is in orcmathGui version2.2
	// Day-In-review should contain
	/*
	 * Total crops planted
	 * Total animals purchased
	 * Total animal products created
	 * Total crops created
	 * 
	 * */
	private Action action;

	public SleepAlex(int x, int y, int w, int h, String imageLocation, Action action) {
		super(0, 0, 150, 150, null);
		this.action = action;
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
