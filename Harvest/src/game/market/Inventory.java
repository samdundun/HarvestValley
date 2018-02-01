package game.market;

import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.Scanner;

import guiTeacher.components.Graphic;

public class Inventory {

	public static Scanner in;
	private ArrayList<Item> inventItems;
	private int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0};

	public static final Item[] items = {new Item("Corn Seeds", "Great crop to grow all year round", 100, 0),
			new Item("Pepper Seeds", "Yes", 100, 1),new Item("Potato Seeds", "Yes", 100, 2),
			new Item("Strawberry Seeds", "Yes", 100, 3),new Item("Tomato Seeds", "Yes", 100, 4),
			new Item("Wheat Seeds", "Yes", 100, 5),new Item("Corn", "Corn \nFresh to eat", 10,6),
			new Item("Pepper","Pepper \nSupah Hot Fire",20,7),new Item("Potato","Potato \nTime to make french fries",10,8),
			new Item("Strawberry","Strawberry \nStraw + Berry??",10,9),new Item("Tomato", "Tomato \nGreat for salads", 10,10),
			new Item("Wheat","Wheat \nJust plain old wheat",10,11)};
	
	//image index
	//cornseed,pepperseed,potatoseed,strawberryseed,tomatoseed,wheatseed,corn,pepper,potato,strawberry,tomato,wheat
	// 0           1          2            3             4          5      6    7       8       9         10    11
	public Inventory() {
		inventItems = new ArrayList<Item>();
	}
	
	public static void main(String[] args){
		Inventory invent = new Inventory();
		in = new Scanner(System.in);
	}

	public void addBasics() {	
		addItem(items[0]);
		addItem(items[1]);
		addItem(items[2]);
		addItem(items[3]);
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
	}
	
	public void removeItem(Item i) {
		inventItems.remove(i);
	}
	
	public int[] getAmountArray() {
		return amount;
	}
}
