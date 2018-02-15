package game.market;

import java.awt.ItemSelectable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;
import guiTeacher.components.Graphic;
import harvest.MainMenu;

public class SamInventory implements game.farm.ItemSelectionJane {

	public static Scanner in;
	private int[] amount;
	private ArrayList<ErikItem> invent;
	private int gold;

	public static final ErikItem[] ITEMS = {new ErikItem("Corn Seeds", "Great crop to grow all year round", 250, 0, 4),new ErikItem("Pepper Seeds", "Spicy", 50, 1,1),
			new ErikItem("Potato Seeds", "Just like me", 150, 2, 3),new ErikItem("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new ErikItem("Tomato Seeds", "Make some good ketchup", 200, 4,3),new ErikItem("Wheat Seeds", "Not weed", 300, 5,5),new ErikItem("Corn", "Fresh to eat", 300,6,4),
			new ErikItem("Pepper","Supah Hot Fire",60,7,1),new ErikItem("Potato","Time to make french fries",180,8,3),
			new ErikItem("Strawberry","Berry??",120,9,2),new ErikItem("Tomato", "Great for salads", 240,10,3),
			new ErikItem("Wheat","Just plain old wheat",360,11,5),new ErikItem("Brown Chicken", "Cluck cluck", 250, 12,1),new ErikItem("White Chicken", "Cluck cluck", 250, 13,1),
			new ErikItem("Black Chicken", "Cluck cluck", 250, 14,1),new ErikItem("Sheep", "BAAAAAAAAAAAH", 350, 15,2),
			new ErikItem("Cow", "Mooooooo", 400, 16,2),new ErikItem("Pig", "SNORT SNORT", 450, 17,1),
			new ErikItem("Brown Eggs", "Organic", 200, 18, 0),new ErikItem("White Eggs", "Non-Organic", 200, 19,0),
			new ErikItem("Black Eggs", "Does not contain egg whites", 200, 20, 0),new ErikItem("Wool", "Canada Goose", 300, 21,0),
			new ErikItem("Milk", "An utter-disaster", 350, 22,0),new ErikItem("Meat", "Mmmmmmm tasty", 500, 23,0)};

	//image index
	//cornseed,pepperseed,potatoseed,strawberryseed,tomatoseed,wheatseed,corn,pepper,potato,strawberry,tomato,wheat
	// 0           1          2            3             4          5      6    7       8       9         10    11

	public SamInventory() {
		invent = new ArrayList<ErikItem>();
		amount = new int[ITEMS.length];


	}

	public void addBasics() {	
		addItem(ITEMS[0]);
		addItem(ITEMS[1]);
		addItem(ITEMS[2]);
		addItem(ITEMS[3]);
		setGold(500);
		//		addItem(items[4]);
		//		addItem(items[5]);
		//		addItem(items[6]);
		//		addItem(items[7]);
		//		addItem(items[8]);
		//		addItem(items[9]);
		//		addItem(items[10]);
		//		addItem(items[11]);
		//		addItem(items[7]);
		//		addItem(items[8]);
		//		addItem(items[9]);
		/**
		 * strawberries
		 * corn
		 * tomato
		 * potato
		 * pepper
		 * wheat
		 * seeds^^
		 */

	}


	//	public void sort() {
	//		for(int i = 0; i < items.size();i++) {
	//			amount.get(items.get(i).getImageIndex())++;
	//		}
	//		
	//	}

	public void sort() {

		for(int k = 0; k < amount.length;k++) {
			amount[k] = 0;
		}

		for(ErikItem i: invent) {
			amount[i.getImageIndex()]++;
		}

		//		for(int i = 0; i < invent.size()/2;i++) {
		//			amount[invent.get(i).getImageIndex()]++;
		//		}
	}


	private static void displayMessage(String message){
		System.out.println(message);
	}

	private void menu() {
		//if we want to start something upon enter
	}

	public ArrayList<ErikItem> getItems(){
		return invent;
	}

	public ErikItem getItem(int index){
		return invent.get(index);
	}

	public void addItem(ErikItem i){
		invent.add(i);
	}

	public void removeItem(ErikItem i) {
		invent.remove(i);
		System.out.println("Inventory class: "+ invent);
	}

	public int[] getAmountArray() {
		return amount;
	}

	public void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){

			fileName = "resources/invent.csv";
			opened = read(new File(fileName));

		}

	}

	public boolean read(File f){
		try{
			FileReader fileReader = new FileReader(f);
			String line = "";
			//a BufferedReader enables us to read the file one line at a time
			BufferedReader br = new BufferedReader(fileReader);
			while ((line = br.readLine()) != null) {



				String[] param = line.split(",");
				if(param.length == 2) {
					this.setGold(Integer.parseInt(param[0]));
					MainMenu.isGirl = Boolean.parseBoolean(param[1]);
				}
				else {
					invent.add(new ErikItem(param[0],param[1],Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4])));
				}
			}
			br.close();
			return true;
		}catch(Exception e){
			System.out.println("The file name you specified does not exist.");
			return false;
		}
	}

	public void save() {
		try{    
			FileWriter fw=new FileWriter("resources/invent.csv");
			fw.write(Integer.toString(this.getGold())+","+ MainMenu.isGirl +"\n");
			for(ErikItem b: invent){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"invent.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}


	@Override
	public ArrayList<ErikItem> getSeedSelection() {
		ArrayList<ErikItem> seeds = new ArrayList<ErikItem>();
		for(ErikItem i: invent) {
			if(i.getImageIndex() < 6) {
				seeds.add(i);
			}
		}
		
		return seeds;
	}

	@Override
	public ArrayList<ErikItem> getAnimalSelection() {
		ArrayList<ErikItem> animals = new ArrayList<ErikItem>();
		for(ErikItem i: invent) {
			if(i.getImageIndex() > 11 && i.getImageIndex() < 18) {
				animals.add(i);
			}
		}
		
		return animals;
	}

	public ArrayList<ErikItem> getSeedInventory() {
		// TODO Auto-generated method stub
		return null;

	}


}
 