package game.market;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

	public static Scanner in;
	private ArrayList<Item> items;
	private ArrayList<Integer> amount;
	
	public Inventory() {
		items = new ArrayList<Item>();
		amount = new ArrayList<Integer>();
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
		addItem(new Item("Corn", "Fresh to eat", 10,0));
		addItem(new Item("Corn", "Fresh to eat", 10,1));
		addItem(new Item("Corn", "Fresh to eat", 10,0));
		addItem(new Item("Corn", "Fresh to eat", 10,1));
		addItem(new Item("Corn", "Fresh to eat", 10,0));
		addItem(new Item("Corn", "Fresh to eat", 10,1));
		addItem(new Item("Corn", "Fresh to eat", 10,0));
		addItem(new Item("Corn", "Fresh to eat", 10,1));
		addItem(new Item("Corn", "Fresh to eat", 10,0));
		addItem(new Item("Corn", "Fresh to eat", 10,1));
	}
	
//	public void sort() {
//		for(int i = 0; i < items.size();i++) {
//			amount.get(items.get(i).getImageIndex())++;
//		}
//		
//	}
	
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
	}
	
	public void removeItem(Item i) {
		items.remove(i);
	}
}
