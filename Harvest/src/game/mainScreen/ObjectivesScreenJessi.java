package game.mainScreen;


import guiTeacher.components.Action;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.Screen;

import java.util.List;

import guiTeacher.components.*;

import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ObjectivesScreenJessi extends ClickableScreen implements Runnable {

	public ObjectivesScreenJessi(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic back = new Graphic(0,0,.5,"resources/background.png");
		viewObjects.add(back);
		
		//TextBox y = new TextBox(100, 100, 10, 100, "");
		//y.set
		TextArea x = new TextArea(140, 180, getWidth()/2, 400, "HARVEST VALLEY INSTRUCTIONS");
		x.setCustomTextColor(new Color(240,240,255));
		
		try {
			File fontFile = new File("resources/burnstown dam.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont = font.deriveFont(96f);
			x.setFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		viewObjects.add(x);
		//
		
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String args[]) {
		
		ArrayList<String> obj = new ArrayList<String>();
		
		for(int i = 0; i < obj.size(); i++) {
			 System.out.println("Rule #" + i + " : " + obj.get(i));

		}
	}


}
