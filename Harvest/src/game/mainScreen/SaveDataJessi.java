package game.mainScreen;

import guiTeacher.components.Action;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import game.market.SamInventory;
import guiTeacher.components.*;

public class SaveDataJessi {
	private boolean save;

//	public static Scanner in;
//	private ArrayList<Inventory> items;
	
	//make an interface.

//	public boolean read(File f){
//		try{
//			FileReader fileReader = new FileReader(f);
//			String line = "";
//			//a BufferedReader enables us to read the file one line at a time
//			BufferedReader br = new BufferedReader(fileReader);
//			while ((line = br.readLine()) != null) {
//
//
//
//				String[] param = line.split(",");
//				if(param.length == 1) {
//					this.setGold(Integer.parseInt(param[0]));
//				}
//				else {
//					data.add(new Item(param[0],param[1],Integer.parseInt(param[2]), Integer.parseInt(param[3]), Integer.parseInt(param[4])));
//				}
//			}
//			br.close();
//			return true;
//		}catch(Exception e){
//			System.out.println("The file name you specified does not exist.");
//			return false;
//		}
//	}
///
//	public void save() {
//		try{    
//			FileWriter fw=new FileWriter("resources/invent.csv");
//			fw.write(Integer.toString(this.getGold())+"\n");
//			for(Item b: invent){
//				fw.write(b+"\n");    	
//			}
//
//			fw.close();    
//			System.out.println("Success! File \"invent.csv\" saved!");
//		}catch(IOException e){
//			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
//		}
//
//	
}
