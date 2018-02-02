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

public class Inventory {

	public static Scanner in;
	private ArrayList<Item> inventItems;
	private int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0};
	private ArrayList<Item> invent;

	public static final Item[] ITEMS = {new Item("Corn Seeds", "Great crop to grow all year round", 100, 0,4),
			new Item("Pepper Seeds", "Yes", 100, 1,1),new Item("Potato Seeds", "Yes", 100, 2,3),
			new Item("Strawberry Seeds", "Yes", 100, 3,2),new Item("Tomato Seeds", "Yes", 100, 4,3),
			new Item("Wheat Seeds", "Yes", 100, 5,5),new Item("Corn", "Corn \nFresh to eat", 10,6,4),
			new Item("Pepper","Pepper \nSupah Hot Fire",20,7,1),new Item("Potato","Potato \nTime to make french fries",10,8,3),
			new Item("Strawberry","Strawberry \nStraw + Berry??",10,9,2),new Item("Tomato", "Tomato \nGreat for salads", 10,10,3),
			new Item("Wheat","Wheat \nJust plain old wheat",10,11,5)};
	
	//image index
	//cornseed,pepperseed,potatoseed,strawberryseed,tomatoseed,wheatseed,corn,pepper,potato,strawberry,tomato,wheat
	// 0           1          2            3             4          5      6    7       8       9         10    11
	public Inventory() {
		inventItems = new ArrayList<Item>();
		invent = new ArrayList<Item>();
		//load();
	}

	public void addBasics() {	
		addItem(ITEMS[0]);
		addItem(ITEMS[1]);
		addItem(ITEMS[2]);
		addItem(ITEMS[3]);
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
		for(int i = 0; i < inventItems.size();i++) {
			amount[inventItems.get(i).getImageIndex()]++;
		}
		for(int j = 0; j < inventItems.size();j++) {
			inventItems.get(j).setAmount(amount[inventItems.get(j).getImageIndex()]);
		}
	}


	private static void displayMessage(String message){
		System.out.println(message);
	}

	private void menu() {
		//if we want to start something upon enter
	}

	public ArrayList<Item> getItems(){
		return inventItems;
	}

	public Item getItem(int index){
		return inventItems.get(index);
	}

	public void addItem(Item i){
		inventItems.add(i);
		invent.add(i);
	}

	public void removeItem(Item i) {
		inventItems.remove(i);
	}

	public int[] getAmountArray() {
		return amount;
	}

	private void load() {
		String fileName = "";
		//empty the catalog to prepare for a new load
		//use this boolean to control the while loop. The user should have multiple chances to enter a correct filename
		boolean opened = false;
		while(!opened){

			fileName = "invent.csv";
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
				System.out.print(param[0]);
				System.out.print(param[2]);
				invent.add(new Item(param[0],param[1],Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4])));

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
			FileWriter fw=new FileWriter("invent.csv");
			for(Item b: invent){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"invent.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}

	
}
