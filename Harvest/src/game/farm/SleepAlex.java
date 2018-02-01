package game.farm;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.ImageTextButton;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class SleepAlex extends FullFunctionScreen implements FileRequester {//can use ImageTextButton, CustomImageButton, ClickableGraphic
	
	private int numCropsPlanted;
	private int numAnimalsPurchased;
	private int cropsGold;
	private int animalsGold;
	private int tomato;
	private int wheat;
	private int strawberry;
	private int corn;
	private int potato;
	private int pepper;
	private int cows;
	private int milk;
	private int sheep;
	private int wool;
	private int pig;
	private int pork;
	private int chicken;
	private int eggs;
	
	private boolean IsCropPlanted;
	private boolean IsAnimalPurchased;
	
	
	//Holiday card is in orcmathGui version2.2
	// Day-In-review should contain
	/*
	 * Total crops planted
	 * Total animals purchased
	 * Total animal products created
	 * Total crops created
	 * */

	public void AnimalCropSelected(String animalCrop) {
		
	}
	
	public SleepAlex(int width, int height) {
		super(width,height);
	}

	public void act(){
		if(action != null) action.act();
	}
	
	public void setAction(Action a){
		this.action = a;
	}

	@Override
	public void setFile(File f) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JFrame getWindow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
}
