package game.mainScreen;


import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.Screen;
import harvest.MainMenu;

import java.util.List;
import java.util.Scanner;

import game.market.Inventory;
import game.market.Item;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ObjectivesScreenJessi extends ClickableScreen implements Runnable, MessageDisplayerJessi  {

	private Button exit;
	public static Scanner in;
	private ArrayList<String> rules;
	public ObjectivesScreenJessi(int width, int height) {
		super(width, height);
		rules = new ArrayList<String>();
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic back = new Graphic(0,0,.5,"resources/background.png");
		viewObjects.add(back);
		
		TextArea x = new TextArea(getWidth()/2-250, 50, 800, 800, "HARVEST VALLEY INSTRUCTIONS");
		x.setCustomTextColor(new Color(0,0,0));
		
		try {
			File fontFile = new File("resources/burnstown dam.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont = font.deriveFont(42f);
			x.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		viewObjects.add(x);
		
		TextBox intro = new TextBox(getWidth()/2-250, 150, 600, 400, "intro");
		viewObjects.add(intro);
		
		exit = new Button(880, 70, 40, 40, "X", new Action() {

			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.screen);

			}
		});
		exit.setBackground(Color.blue);
		exit.setActiveBorderColor(Color.green);
		exit.setCurve(0, 0);
		exit.update();
		viewObjects.add(exit);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) {
		//ObjectivesScreenJessi rules = new ObjectivesScreenJessi();
		in = new Scanner(System.in);
	}

	@Override
	public void showline() {
		
		
	}



}
