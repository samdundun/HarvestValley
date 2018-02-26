package game.mainScreen;

import harvest.MainMenu;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class JessiSoundScreen extends ClickableScreen  {
	
	private Button exit;
	
	private Button sound1;
	private Button sound2;
	private Button sound3;
	private Button sound4;
	private Button sound5;
	
	private boolean sound1Selected;
	private boolean sound2Selected;
	private boolean sound3Selected;
	private boolean sound4Selected;
	private boolean sound5Selected;	

	public JessiSoundScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic back = new Graphic(0,0,getWidth(),getHeight(),"resources/background.png");
		viewObjects.add(back);
		
		TextArea x = new TextArea(getWidth()/2-280, 50, 800, 800, "HARVEST VALLEY SOUNDTRACKS");
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
		
		exit = new Button(800, 70, 40, 40, "X", new Action() {
			@Override
			public void act() {
				MainMenu.game.setScreen(MainMenu.screen);

			}
		});
		exit.setBackground(Color.blue);
		exit.setForeground(Color.white);
		exit.setActiveBorderColor(Color.green);
		exit.setCurve(10,10);
		exit.update();
		viewObjects.add(exit);
		
		sound1 = new Button(200, 150, 250, 40, "Spring (The Valley Comes Alive)", new Action() {
			@Override
			public void act() {
				if(sound1Selected == false) {
					sound1Selected = true;
					sound1.setBackground(Color.cyan);
					sound1.setForeground(Color.black);
					sound1.setActiveBorderColor(Color.green);
					sound1.update();
					MainMenu.player.add("sound");
					MainMenu.player.refresh();
				}else {
					sound1Selected = false;
					sound1.setBackground(Color.gray);
					sound1.setForeground(Color.black);
					sound1.setActiveBorderColor(Color.green);
					sound1.update();
					MainMenu.player.remove("sound");
					MainMenu.player.refresh();
				}
			}
		});
		if (MainMenu.player.isSongSelected("sound"))
		{
			sound1.setBackground(Color.cyan);
			sound1Selected = true;
		}
		else {
			sound1.setBackground(Color.gray);
			sound1Selected = false;
		}
		sound1.setForeground(Color.black);
		sound1.setActiveBorderColor(Color.green);
		sound1.update();
		viewObjects.add(sound1);
		sound2 = new Button(200, 200, 250, 40, "Spring (It's A Big World Outside)", new Action() {
			@Override
			public void act() {
				if(sound2Selected == false) {
					sound2Selected = true;
					sound2.setBackground(Color.cyan);
					sound2.setForeground(Color.black);
					sound2.setActiveBorderColor(Color.green);
					sound2.update();
					MainMenu.player.add("sound2");
					MainMenu.player.refresh();
				}else {
					sound2Selected = false;
					sound2.setBackground(Color.gray);
					sound2.setForeground(Color.black);
					sound2.setActiveBorderColor(Color.green);
					sound2.update();
					MainMenu.player.remove("sound2");
					MainMenu.player.refresh();
				}
			}
		});
		if (MainMenu.player.isSongSelected("sound2"))
		{
			sound2.setBackground(Color.cyan);
			sound2Selected = true;
		}
		else {
			sound2.setBackground(Color.gray);
			sound2Selected = false;
		}
		sound2.setBackground(Color.cyan);
		sound2.setForeground(Color.black);
		sound2.setActiveBorderColor(Color.green);
		sound2.update();
		viewObjects.add(sound2);
		sound3 = new Button(200, 250, 250, 40, "Summer (Nature's Crescendo)", new Action() {
			@Override
			public void act() {
				if(sound3Selected == false) {
					sound3Selected = true;
					sound3.setBackground(Color.cyan);
					sound3.setForeground(Color.black);
					sound3.setActiveBorderColor(Color.green);
					sound3.update();
					MainMenu.player.add("sound3");
					MainMenu.player.refresh();
				}else {
					sound3Selected = false;
					sound3.setBackground(Color.gray);
					sound3.setForeground(Color.black);
					sound3.setActiveBorderColor(Color.green);
					sound3.update();
					MainMenu.player.remove("sound3");
					MainMenu.player.refresh();
				}
			}
		});
		if (MainMenu.player.isSongSelected("sound3"))
		{
			sound3.setBackground(Color.cyan);
			sound3Selected = true;
		}
		else {
			sound3.setBackground(Color.gray);
			sound3Selected = false;
		}
		sound3.setBackground(Color.cyan);
		sound3.setForeground(Color.black);
		sound3.setActiveBorderColor(Color.green);
		sound3.update();
		viewObjects.add(sound3);
		sound4 = new Button(200, 300, 250, 40, "Winter (Nocturne Of Ice)", new Action() {
			@Override
			public void act() {
				if(sound4Selected == false) {
					sound4Selected = true;
					sound4.setBackground(Color.cyan);
					sound4.setForeground(Color.black);
					sound4.setActiveBorderColor(Color.green);
					sound4.update();
					MainMenu.player.add("sound4");
					MainMenu.player.refresh();
				}else {
					sound4Selected = false;
					sound4.setBackground(Color.gray);
					sound4.setForeground(Color.black);
					sound4.setActiveBorderColor(Color.green);
					sound4.update();
					MainMenu.player.remove("sound4");
					MainMenu.player.refresh();
				}
			}
		});
		if (MainMenu.player.isSongSelected("sound4"))
		{
			sound4.setBackground(Color.cyan);
			sound4Selected = true;
		}
		else {
			sound4.setBackground(Color.gray);
			sound4Selected = false;
		}
		sound4.setBackground(Color.cyan);
		sound4.setForeground(Color.black);
		sound4.setActiveBorderColor(Color.green);
		sound4.update();
		viewObjects.add(sound4);
		sound5 = new Button(200, 350, 250, 40, "Fall (The Smell Of Mushroom)", new Action() {
			@Override
			public void act() {
				if(sound5Selected == false) {
					sound5Selected = true;
					sound5.setBackground(Color.cyan);
					sound5.setForeground(Color.black);
					sound5.setActiveBorderColor(Color.green);
					sound5.update();
					MainMenu.player.add("sound5");
					MainMenu.player.refresh();
				}else {
					sound5Selected = false;
					sound5.setBackground(Color.gray);
					sound5.setForeground(Color.black);
					sound5.setActiveBorderColor(Color.green);
					sound5.update();
					MainMenu.player.remove("sound5");
					MainMenu.player.refresh();
				}
			}
		});
		if (MainMenu.player.isSongSelected("sound5"))
		{
			sound5.setBackground(Color.cyan);
			sound5Selected = true;
		}
		else {
			sound5.setBackground(Color.gray);
			sound5Selected = false;
		}
		sound5.setBackground(Color.cyan);
		sound5.setForeground(Color.black);
		sound5.setActiveBorderColor(Color.green);
		sound5.update();
		viewObjects.add(sound5);
		
		
	}
}
