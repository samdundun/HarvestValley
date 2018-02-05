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
	private int numAnimalProducts;
	
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
	private int brownChicken;
	private int whiteChicken;
	private int blackChicken;
	private int brownEggs;
	private int whiteEggs;
	private int blackEggs;
	
	private ArrayList<String> cropAnimalAndProductNames = new ArrayList<String>();
	//{"tomato","wheat","strawberry","corn","potato","pepper","cows","sheep","pigs","chicken"};
	/*
	 * ArrayLists will follow 
	 * */
	private ArrayList<Integer> cropAnimalAndProductCount = new ArrayList<Integer>();
	//{tomato,wheat,strawberry,corn,potato,pepper,cows,sheep,pigs,chicken};
	
	private ArrayList<Integer> cashFromCropAnimalProducts = new ArrayList<Integer>();
	
	//private ArrayList<String> crops = new ArrayList<String>(6);
	//private ArrayList<String> animals = new ArrayList<String>(4);
	
	private boolean IsCropPlanted;
	private boolean IsAnimalPurchased;
	private boolean IsProductCreated;
	
	
	//Holiday card is in orcmathGui version2.2
	// Day-In-review should contain
	/*
	 * Total crops planted
	 * Total animals purchased
	 * Total animal products created
	 * Total crops created
	 * */

	public void addNamesAndCountToArray() {
		//execute once
		//First 6 items are crops -- Next 4 are animals -- Next 4 are animal products
		cropAnimalAndProductNames.add("tomato");
		cropAnimalAndProductNames.add("wheat");
		cropAnimalAndProductNames.add("strawberry");
		cropAnimalAndProductNames.add("corn");
		cropAnimalAndProductNames.add("potato");
		cropAnimalAndProductNames.add("pepper");
		
		cropAnimalAndProductNames.add("cows");
		cropAnimalAndProductNames.add("sheep");
		cropAnimalAndProductNames.add("pigs");
		cropAnimalAndProductNames.add("brownChicken");
		cropAnimalAndProductNames.add("whiteChicken");
		cropAnimalAndProductNames.add("blackChicken");
		
		cropAnimalAndProductNames.add("milk");
		cropAnimalAndProductNames.add("wool");
		cropAnimalAndProductNames.add("pork");
		cropAnimalAndProductNames.add("brownEggs");
		cropAnimalAndProductNames.add("whiteEggs");
		cropAnimalAndProductNames.add("blackEggs");
		
		cropAnimalAndProductCount.add(tomato);
		cropAnimalAndProductCount.add(wheat);
		cropAnimalAndProductCount.add(strawberry);
		cropAnimalAndProductCount.add(corn);
		cropAnimalAndProductCount.add(potato);
		cropAnimalAndProductCount.add(pepper);
		
		cropAnimalAndProductCount.add(cows);
		cropAnimalAndProductCount.add(sheep);
		cropAnimalAndProductCount.add(pigs);
		cropAnimalAndProductCount.add(brownChicken);
		cropAnimalAndProductCount.add(whiteChicken);
		cropAnimalAndProductCount.add(blackChicken);
		
		cropAnimalAndProductCount.add(milk);
		cropAnimalAndProductCount.add(wool);
		cropAnimalAndProductCount.add(pork);
		cropAnimalAndProductCount.add(brownEggs);
		cropAnimalAndProductCount.add(whiteEggs);
		cropAnimalAndProductCount.add(blackEggs);
		
		for(int i = 0; i < cashFromCropAnimalProducts.size();i++ ) {
			//generate buying and selling prices for crops and animals automatically
			//use 2D ArrayList
			//create textboxes for each item of information about crops and animals
			//have a panel that lightens all products the player can buy and darkens (perhaps an image of a lock) of all the products the user may not by.
		}
		
	}
	
	//call when: 
	public void AnimalCropIncrement(String animalCrop) {
		for(int i = 0;i < cropAnimalAndProductNames.size();i++) {
			if(animalCrop.equals(cropAnimalAndProductNames.get(i))) {
				cropAnimalAndProductCount.set(i,cropAnimalAndProductCount.get(i) + 1);
					if(i < 6) {
						numCropsPlanted++;
						IsCropPlanted = true;
					}
					else if(i < 10 && i > 5){
						numAnimalsPurchased++;
						IsAnimalPurchased = true;
					}
					else {
						numAnimalProducts++;
						IsProductCreated = true;
					}
			}
		}
		
		//if the index is low, then the item is a fruit
		//set the boolean IsPlanted to true AND increment total number of crops or animals purchased
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
