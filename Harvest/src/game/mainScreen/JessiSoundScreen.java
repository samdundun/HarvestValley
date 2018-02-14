package game.mainScreen;

import harvest.MainMenu;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ClickableScreen;

public class JessiSoundScreen extends ClickableScreen  {
	
	private Button exit;

	public JessiSoundScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		TextArea x = new TextArea(getWidth()/2-250, 50, 800, 800, "HARVEST VALLEY SOUNDTRACKS");
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
		
	}
}
