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

public class Inventory implements game.farm.seedSelection {

	public static Scanner in;
	private int[] amount;
	private ArrayList<Item> invent;
	private int gold;

	public static final Item[] ITEMS = {new Item("Corn Seeds", "Great crop to grow all year round", 250, 0, 4),new Item("Pepper Seeds", "Spicy", 50, 1,1),
			new Item("Potato Seeds", "Just like me", 150, 2, 3),new Item("Strawberry Seeds", "Sweeter than you", 100, 3,2),
			new Item("Tomato Seeds", "Make some good ketchup", 200, 4,3),new Item("Wheat Seeds", "Not weed", 300, 5,5),new Item("Corn", "Fresh to eat", 300,6,4),
			new Item("Pepper","Supah Hot Fire",60,7,1),new Item("Potato","Time to make french fries",180,8,3),
			new Item("Strawberry","Berry??",120,9,2),new Item("Tomato", "Great for salads", 240,10,3),
			new Item("Wheat","Just plain old wheat",360,11,5),new Item("Brown Chicken", "Cluck cluck", 250, 12,1),new Item("White Chicken", "Cluck cluck", 250, 13,1),
			new Item("Black Chicken", "Cluck cluck", 250, 14,1),new Item("Sheep", "BAAAAAAAAAAAH", 350, 15,2),
			new Item("Cow", "Mooooooo", 400, 16,2),new Item("Pig", "SNORT SNORT", 450, 17,1),
			new Item("Brown Eggs", "", 200, 18, 0),new Item("White Eggs", "", 200, 19,0),
			new Item("Black Eggs", "", 200, 20, 0),new Item("Wool", "", 300, 21,0),
			new Item("Milk", "", 350, 22,0),new Item("Meat", "", 500, 23,0)};

	//image index
	//cornseed,pepperseed,potatoseed,strawberryseed,tomatoseed,wheatseed,corn,pepper,potato,strawberry,tomato,wheat
	// 0           1          2            3             4          5      6    7       8       9         10    11
	public Inventory() {

		invent = new ArrayList<Item>();
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

		for(Item i: invent) {
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

	public ArrayList<Item> getItems(){
		return invent;
	}

	public Item getItem(int index){
		return invent.get(index);
	}

	public void addItem(Item i){
		invent.add(i);
	}

	public void removeItem(Item i) {
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
					invent.add(new Item(param[0],param[1],Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4])));
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
			for(Item b: invent){
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
	public ArrayList<Item> getSeedInventory() {
		ArrayList<Item> seeds = new ArrayList<Item>();
		for(Item i: invent) {
			if(i.getImageIndex() < 6) {
				seeds.add(i);
			}
		}
		
		return seeds;
	}


}
 