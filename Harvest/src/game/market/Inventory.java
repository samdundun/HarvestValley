package game.market;

import java.util.ArrayList;
import java.util.Scanner;

import guiTeacher.components.Graphic;

public class Inventory {

	public static Scanner in;
	private ArrayList<Item> items;
	private int[] amount = {0,0,0,0,0,0,0,0,0,0,0,0};
	
	//image index
	//cornseed,pepperseed,potatoseed,strawberryseed,tomatoseed,wheatseed,corn,pepper,potato,strawberry,tomato,wheat
	// 0           1          2            3             4          5      6    7       8       9         10    11
	public Inventory() {
		items = new ArrayList<Item>();
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
	
	public void sort() {
		for(int i = 0; i < items.size();i++) {
			items.get(i).setAmount(amount[items.get(i).getImageIndex()]++);
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
	}
	
	public void removeItem(Item i) {
		items.remove(i);
	}
	
	public int[] getAmountArray() {
		return amount;
	}
}
