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


import game.mainScreen.LubnaImageButton;
import game.market.ErikItem;
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
	private int originalBuyingPrice;
	
	private boolean infoDisplayed;
	
	public static ErikItem[] items = {new ErikItem("Corn Seeds", "Great crop to grow all year round", 300, 0, 4),new ErikItem("Pepper Seeds", "Spicy", 50, 1,1),
			new ErikItem("Potato Seeds", "Just like me", 150, 2, 3),new ErikItem("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new ErikItem("Tomato Seeds", "Make some good ketchup", 200, 4,3),new ErikItem("Wheat Seeds", "Not weed", 400, 5,5),

			new ErikItem("Corn", "Fresh to eat", 10,6,4), new ErikItem("Pepper","Supah Hot Fire",20,7,1),
			new ErikItem("Potato","Time to make french fries",10,8,3),new ErikItem("Strawberry","Berry??",10,9,2),
			new ErikItem("Tomato", "Great for salads", 10,10,3),	new ErikItem("Wheat","Just plain old wheat",10,11,5),

			new ErikItem("Brown Chicken", "Cluck cluck", 250, 12,1),new ErikItem("White Chicken", "Cluck cluck", 250, 13,1),
			new ErikItem("Black Chicken", "Cluck cluck", 250, 14,1),new ErikItem("Sheep", "BAAAAAAAAAAAH", 350, 15,2),
			new ErikItem("Cow", "Mooooooo", 500, 16,2),new ErikItem("Pig", "SNORT SNORT", 250, 17,1),

			new ErikItem("Brown Eggs", "", 300, 18, 0),new ErikItem("White Eggs", "", 50, 19,0),
			new ErikItem("Black Eggs", "", 150, 20, 0),new ErikItem("Wool", "", 100, 21,0),
			new ErikItem("Milk", "", 200, 22,0),new ErikItem("Meat", "", 400, 23,0)};
	
	private static ArrayList<Boolean> infoDisplayedArray = new ArrayList<Boolean>();
	
	private Button back;
	
	private static ArrayList<String> cropAnimalAndProductNames = new ArrayList<String>();
	//{"tomato","wheat","strawberry","corn","potato","pepper","cows","sheep","pigs","chicken"};
	/*
	 * ArrayLists will follow 
	 * */
	private static ArrayList<Integer> cropAnimalAndProductCount = new ArrayList<Integer>();
	//{tomato,wheat,strawberry,corn,potato,pepper,cows,sheep,pigs,chicken};
	
	private static ArrayList<Integer> cashFromCropAnimalProducts = new ArrayList<Integer>(12);
	private static ArrayList<Integer> sellingPriceCropAnimalProducts = new ArrayList<Integer>(12);
	
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
	 * a*/

	public SleepAlex(int width, int height) {
		super(width,height);
	}
	
	public void initAllObjects(List<Visible> viewObjects) {
		//ImageButton class works correctly when using the correct string address format -- include the package name
		//create a textArea superclass to extend that incorporates a certain colored background
		
		Graphic backgroundOne = new Graphic(0, 0,getWidth(),getHeight(), "resources/nightSky.png");
		viewObjects.add(backgroundOne);
		Graphic backgroundTwo = new Graphic(100, 0,getWidth(),getHeight(), "resources/nightSky.png");
		viewObjects.add(backgroundTwo);
		
		imageSources.add("resources/cornSt6.png");
		imageSources.add("resources/pepperSt6.png");
		imageSources.add("resources/potatoSt6.png");
		imageSources.add("resources/strawberrySt6.png");
		imageSources.add("resources/tomatoSt6.png");
		imageSources.add("resources/wheatSt5.png");
		
		imageSources.add("resources/brownEgg.png");
		imageSources.add("resources/whiteEgg.png");
		imageSources.add("resources/blackEgg.png");
		imageSources.add("resources/sheep.png");
		imageSources.add("resources/cow.png");
		imageSources.add("resources/pig.png");
		
		
		actionInteger = 0;
		addNamesAndCountToArray();
		
		//infoDisplayed = false;
//		for(int i = 0; i < 11;i++) {
//			infoDisplayedArray.add(infoDisplayed);
//		}
		TextArea info = new TextArea((getWidth()/2)-100, (getHeight()/2), 200, 500, "Click on an item.");
		info.setCustomTextColor(Color.white);
		viewObjects.add(info);
		
		for(int actionInteger = 0; actionInteger<imageSources.size();actionInteger++) {
			/*variables inside the setup part of a for loop are local -- be cautious when using them in the function -- especially in the action method of a button*/
			int xspacer = 68;
			int c = actionInteger;
			LubnaImageButton holder = new LubnaImageButton(actionInteger*xspacer,75,88,150, imageSources.get(actionInteger), new Action() {
				public void act() {
					System.out.println(cashFromCropAnimalProducts.get(c));
//					TextArea info = new TextArea(c*83, 300, 200, 500, "You have created" + 
//							cropAnimalAndProductCount.get(c) + cropAnimalAndProductNames.get(c) + "." + 
//							"You have made" +cashFromCropAnimalProducts.get(c)+ "from" + 
					info.setText("You have created " + 
							cropAnimalAndProductCount.get(c) + " " + cropAnimalAndProductNames.get(c) + ". " + 
							"You have made " +cashFromCropAnimalProducts.get(c)+ " from " + 
							cropAnimalAndProductNames.get(c)+".");
//					if(!infoDisplayed)
//						viewObjects.add(info);
//					infoDisplayed = true;
//					else {
//						
//					}		
					info.setTextColor(Color.white);
				}});
			viewObjects.add(holder);
		}
		
		
//		back = new Button(getWidth()-100, getHeight()-100,100, 100, "",Color.blue, new Action() {
//			public void act() {
//				MainMenu.game.setScreen(MainMenu.farmScreen);
//			}
//		});
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
		
		//use the strings from the SelectionPaneJane class
		cropAnimalAndProductNames.add("corn");
		cropAnimalAndProductNames.add("pepper");
		cropAnimalAndProductNames.add("potato");
		cropAnimalAndProductNames.add("strawberry");
		cropAnimalAndProductNames.add("tomato");
		cropAnimalAndProductNames.add("wheat");
		
		/*cropAnimalAndProductNames.add("brownChicken");
		cropAnimalAndProductNames.add("whiteChicken");
		cropAnimalAndProductNames.add("blackChicken");
		cropAnimalAndProductNames.add("sheep");
		cropAnimalAndProductNames.add("cows");
		cropAnimalAndProductNames.add("pigs");*/
		
		cropAnimalAndProductNames.add("brownEggs");
		cropAnimalAndProductNames.add("whiteEggs");
		cropAnimalAndProductNames.add("blackEggs");
		cropAnimalAndProductNames.add("wool");
		cropAnimalAndProductNames.add("milk");
		cropAnimalAndProductNames.add("meat");
		
		cropAnimalAndProductCount.add(corn);
		cropAnimalAndProductCount.add(pepper);
		cropAnimalAndProductCount.add(potato);
		cropAnimalAndProductCount.add(strawberry);
		cropAnimalAndProductCount.add(tomato);
		cropAnimalAndProductCount.add(wheat);
				
		/*cropAnimalAndProductCount.add(brownChicken);
		cropAnimalAndProductCount.add(whiteChicken);
		cropAnimalAndProductCount.add(blackChicken);
		cropAnimalAndProductCount.add(sheep);
		cropAnimalAndProductCount.add(cows);
		cropAnimalAndProductCount.add(pigs);*/
		
		cropAnimalAndProductCount.add(milk);
		cropAnimalAndProductCount.add(wool);
		cropAnimalAndProductCount.add(pork);
		cropAnimalAndProductCount.add(brownEggs);
		cropAnimalAndProductCount.add(whiteEggs);
		cropAnimalAndProductCount.add(blackEggs);
		
		originalBuyingPrice = 50;
		//try similar solution for creating different button actions
		for(int i = 0; i < 12;i++) {
			cashFromCropAnimalProducts.add(originalBuyingPrice);
			//System.out.println(cashFromCropAnimalProducts); -- used to check if values are being stored
			originalBuyingPrice+=50;
		}
		
		int sellingPrice = 60;
		for(int i = 0; i < 12;i++ ) {
			sellingPriceCropAnimalProducts.add(sellingPrice);
			//System.out.println("Selling: "+sellingPriceCropAnimalProducts); -- used to check if values are being stored
			sellingPrice+=60;
		}
		
		
		//System.out.println(cropAnimalAndProductCount);
		//System.out.println(cashFromCropAnimalProducts);
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
			LubnaImageButton holder = new LubnaImageButton(i*75, 0, 50, 50, SleepAlex.getImageSources().get(i), new Action() {
				
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
	public static void AnimalCropIncrement() {
		
		int myNum = CropJane.impNum;
		int mySecondNum = CropJane.impNum;
		
		for(int i = 0; i<6;i++) {
			if(cropAnimalAndProductNames.get(myNum).equals(cropAnimalAndProductNames.get(i))) {
				cropAnimalAndProductCount.set(i, cropAnimalAndProductCount.get(i)+1);
				//get the interface working
			}
			
		}
		for(int i =0;i<6;i++) {
			if(cropAnimalAndProductNames.get(mySecondNum).equals(cropAnimalAndProductNames.get(i+6))) {
				cropAnimalAndProductCount.set(i+6, cropAnimalAndProductCount.get(i+6)+1);
			}
			
		}
		/*
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
		}*/
		
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
