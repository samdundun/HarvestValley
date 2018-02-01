package game.farm;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
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
	private int pigs;
	private int pork;
	private int chicken;
	private int eggs;
	
	private ArrayList<String> cropAnimalNames = new ArrayList<String>();
	//{"tomato","wheat","strawberry","corn","potato","pepper","cows","sheep","pigs","chicken"};
	private ArrayList<Integer> cropAnimalCount = new ArrayList<Integer>();
	//{tomato,wheat,strawberry,corn,potato,pepper,cows,sheep,pigs,chicken};
	
	//private ArrayList<String> crops = new ArrayList<String>(6);
	//private ArrayList<String> animals = new ArrayList<String>(4);
	
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

	public void addNamesAndCountToArray() {
		cropAnimalNames.add("tomato");
		cropAnimalNames.add("wheat");
		cropAnimalNames.add("strawberry");
		cropAnimalNames.add("corn");
		cropAnimalNames.add("potato");
		cropAnimalNames.add("pepper");
		cropAnimalNames.add("cows");
		cropAnimalNames.add("sheep");
		cropAnimalNames.add("pigs");
		cropAnimalNames.add("chicken");
		
		cropAnimalCount.add(tomato);
		cropAnimalCount.add(wheat);
		cropAnimalCount.add(strawberry);
		cropAnimalCount.add(corn);
		cropAnimalCount.add(potato);
		cropAnimalCount.add(pepper);
		cropAnimalCount.add(cows);
		cropAnimalCount.add(sheep);
		cropAnimalCount.add(pigs);
		cropAnimalCount.add(chicken);
	}
	
	public void AnimalCropSelected(String animalCrop) {
		for(int i = 0;i < cropAnimalNames.size();i++) {
			if(animalCrop.equals(cropAnimalNames.get(i))) {
				cropAnimalCount.get(i);
			}
		}
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
