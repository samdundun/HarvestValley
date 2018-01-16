package samErikMarket;

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

	public static Scanner in;
	private ArrayList<Item> items;
	
	public Inventory() {
		items = new ArrayList<Item>();
	}
	
	public static void main(String[] args){
		Inventory invent = new Inventory();
		in = new Scanner(System.in);
		invent.add();
		//maker.menu();
	}

	private void add() {
		String name = null;
		String description = null;
		int value = 0;
//		displayMessage("Please enter a title");
//		title = getStringInput();
//		displayMessage("Please enter an author");
//		author = getStringInput();
//		displayMessage("Please enter the number of pages.");
//		pages = getIntegerInput();
		addItem(new Item("Corn", "Fresh to eat", 10,"resources/pig.jpg"));
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
	
	public void addItem(Item b){
		items.add(b);
	}
	
	public void removeItem(Item b) {
		items.remove(b);
	}
}
