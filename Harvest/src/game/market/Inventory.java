package game.market;

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
	private ArrayList<Item> items;
	private int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0};
	private ArrayList<Item> invent;


	//image index
	//cornseed,pepperseed,potatoseed,strawberryseed,tomatoseed,wheatseed,corn,pepper,potato,strawberry,tomato,wheat
	// 0           1          2            3             4          5      6    7       8       9         10    11
	public Inventory() {
		items = new ArrayList<Item>();
		invent = new ArrayList<Item>();
		load();
	}

	public static void main(String[] args){
		Inventory invent = new Inventory();
		in = new Scanner(System.in);
	}

	public void addBasics() {	
		/**
		 * strawberries
		 * corn
		 * tomato
		 * potato
		 * pepper
		 * wheat
		 * seeds^^
		 */
		addItem(new Item("Corn", "Corn \nFresh to eat", 10,6));
		addItem(new Item("Tomato", "Tomato \nGreat for salads", 10,10));
		addItem(new Item("Corn", "Corn \nFresh to eat", 10,6));
		addItem(new Item("Tomato", "Tomato \nGreat for salads", 10,10));
		addItem(new Item("Corn", "Corn \nFresh to eat", 10,6));
		addItem(new Item("Tomato", "Tomato \nGreat for salads", 10,10));
		addItem(new Item("Corn", "Corn \nFresh to eat", 10,6));
		addItem(new Item("Tomato", "Tomato \nGreat for salads", 10,10));
		addItem(new Item("Corn", "Corn \nFresh to eat", 10,6));
		addItem(new Item("Tomato", "Tomato \nGreat for salads", 10,10));
		addItem(new Item("Corn", "Corn \nFresh to eat", 10,6));
		addItem(new Item("Tomato", "Tomato \nGreat for salads", 10,10));

	}


	//	public void sort() {
	//		for(int i = 0; i < items.size();i++) {
	//			amount.get(items.get(i).getImageIndex())++;
	//		}
	//		
	//	}

	public void sort() {
		for(int i = 0; i < items.size();i++) {
			amount[items.get(i).getImageIndex()]++;
		}
		for(int j = 0; j < items.size();j++) {
			items.get(j).setAmount(amount[items.get(j).getImageIndex()]);
		}
	}


	private static void displayMessage(String message){
		System.out.println(message);
	}

	private void menu() {
		//if we want to start something upon enter
	}

	public ArrayList<Item> getItems(){
		return items;
	}

	public Item getItem(int index){
		return items.get(index);
	}

	public void addItem(Item i){
		items.add(i);
		invent.add(i);
	}

	public void removeItem(Item i) {
		items.remove(i);
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
				//add a new Book for each line in the save file
				invent.add(new Item(param[0],param[1],Integer.parseInt(param[2]), Integer.parseInt(param[3])));



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
