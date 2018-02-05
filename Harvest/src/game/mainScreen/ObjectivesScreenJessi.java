
package game.mainScreen;


import harvest.MainMenu;

import java.util.List;

import game.market.Inventory;
import game.market.Item;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import java.awt.Color;
import java.awt.Font;
import java.io.File;

public class ObjectivesScreenJessi extends ClickableScreen implements Runnable, MessageDisplayerJessi,  ObjectiveScreen {

	private Button exit;
	private TextBox intro;
	public ObjectivesScreenJessi(int width, int height) {
		super(width, height);
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
		
		intro = new TextBox(getWidth()/2-250, 150, 600, 400, "intro");
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

	@Override
	public void showline() {
		//for the android app
		
	}


	public void displayObjectives() {
		// TODO Auto-generated method stub
		String[] rules = {"Grow your crops and raise your animals!!!","Our game leads you through an enjoyable farming experience with wide variety of crops, animals, and merchandise.","The main menu provides the player with four options.\r\n Create new game, Load existing game, Directions on how to play, Exit menu." + 
				""};
		intro.setText(rules[0] + "\n");
		Thread printer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i< rules.length; i++) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String contents = intro.getText() + rules[i] + "\n";
					intro.setText(contents);
				}
			}
		});
		printer.start();
	}




}
