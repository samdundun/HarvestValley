package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import game.mainScreen.ImageButton;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.ImageTextButton;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.FileRequester;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import harvest.MainMenu;

public class SleepAlex extends FullFunctionScreen {//can use ImageTextButton, CustomImageButton, ClickableGraphic
	
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
	
	private int actionInteger;
	private int adjustTA;
	
	private Button back;
	
	private ArrayList<String> cropAnimalAndProductNames = new ArrayList<String>();
	//{"tomato","wheat","strawberry","corn","potato","pepper","cows","sheep","pigs","chicken"};
	/*
	 * ArrayLists will follow 
	 * */
	private ArrayList<Integer> cropAnimalAndProductCount = new ArrayList<Integer>();
	//{tomato,wheat,strawberry,corn,potato,pepper,cows,sheep,pigs,chicken};
	
	private ArrayList<Integer> cashFromCropAnimalProducts = new ArrayList<Integer>(12);
	private ArrayList<Integer> sellingPriceCropAnimalProducts = new ArrayList<Integer>(12);
	
	//private ArrayList<ImageButton> imagesCropAnimalProducts = new ArrayList<ImageButton>();
	private static ArrayList<String> imageSources  = new ArrayList<String>();
	
	
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

	public SleepAlex(int width, int height) {
		super(width,height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		//ImageButton class works correctly when using the correct string address format -- include the package name
		//create a textArea superclass to extend that incorporates a certain colored background
		//addNamesAndCountToArray();
		Graphic backgroundOne = new Graphic(0, 0,getWidth(),getHeight(), "resources/nightSky.png");
		viewObjects.add(backgroundOne);
		Graphic backgroundTwo = new Graphic(100, 0,getWidth(),getHeight(), "resources/nightSky.png");
		viewObjects.add(backgroundTwo);
		
		imageSources.add("resources/pepperSt6.png");
		imageSources.add("resources/strawberrySt6.png");
		imageSources.add("resources/tomatoSt6.png");
		imageSources.add("resources/cornSt6.png");
		imageSources.add("resources/wheatSt5.png");
		imageSources.add("resources/cow.png");
		imageSources.add("resources/sheep.png");
		imageSources.add("resources/pig.png");
		imageSources.add("resources/brownEgg.png");
		imageSources.add("resources/whiteEgg.png");
		imageSources.add("resources/blackEgg.png");
		
		actionInteger = 0;
		
		for(int actionInteger = 0; actionInteger<imageSources.size();actionInteger++) {
			/*variables inside the setup part of a for loop are local -- be cautious when using them in the function -- especially in the action method of a button*/
			int xspacer = 83;
			int c = actionInteger;
			ImageButton holder = new ImageButton(actionInteger*xspacer,75,90,150, imageSources.get(actionInteger), new Action() {
				public void act() {
					/*TextArea info = new TextArea(actionInteger*83, 300, 100, 100, "You have created" + 
							cropAnimalAndProductCount.get(actionInteger) + cropAnimalAndProductNames.get(actionInteger) + "." + 
							"You have made" +cashFromCropAnimalProducts.get(actionInteger)+ "from" + 
							cropAnimalAndProductNames.get(actionInteger));
							viewObjects.add(info);*/
					TextArea test = new TextArea(c*83, 300, 200, 200, "DATA IS COOL");
					viewObjects.add(test);
				}});
			viewObjects.add(holder);
		}
		back = new Button(getWidth()-100, getHeight()-100,100, 100, "",Color.blue, new Action() {
			public void act() {
				MainMenu.game.setScreen(MainMenu.farmScreen);
			}
		});
		viewObjects.add(back);}
		//add objects to array
		//call method and add arrayobjects to screen in initallobjects
	
		/*holder = new ImageButton(180,350,150,150,"resources/nightSky.png",new Action() {

			@Override
			public void act() {
				//MainMenu.isNew = true;
				//MainMenu.game.setScreen(MainMenu.screen2);
				TextArea info = new TextArea(0, 0, 100, 100, "You have created 5 corns. You have made $50 from corn.");
				viewObjects.add(info);
			}
		});
		viewObjects.add(holder);*/
	
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
			int buyingPrice = 50;
			cashFromCropAnimalProducts.set(i, buyingPrice);
			buyingPrice+=50;
		}
		
		for(int i = 0; i < sellingPriceCropAnimalProducts.size();i++ ) {
			int sellingPrice = 60;
			sellingPriceCropAnimalProducts.set(i, sellingPrice);
			sellingPrice+=60;
		}
			//create textboxes or clickable boxes for each item of information about crops and animals
			//have a panel that lightens all products the player can buy and darkens (perhaps an image of a lock) of all the products the user may not by.
			//create a class that makes an image lighten or darken w/ a lock image under specific game conditions
	}
	
	private void addCAPImages(List<Visible> viewObjects) {
		//create an array of images AND place them strategically
		//ensure proper spacing
		imageSources.add("pepperSt6.png");
		//create an ArrayList of string addresses or an ArrayList of ImageButtons, not both
		/*
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");
		imagesCropAnimalProducts.add("resources/sleep.png");*/
		
		for(int i = 0; i<imageSources.size();i++) {
			ImageButton holder = new ImageButton(i*75, 0, 50, 50, SleepAlex.getImageSources().get(i), new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					//create a text label that has a semi-defined string -- variables will include the name of the product
					//and buying and selling price
					//"You have created" + num + CAP. "You have made" + cash + "from" + CAP
				}
			});
			viewObjects.add(holder);
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

	public static ArrayList<String> getImageSources() {
		return imageSources;
	}

	public static void setImageSources(ArrayList<String> imageSources) {
		SleepAlex.imageSources = imageSources;
	}
}
