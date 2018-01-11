package playground;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CustomButton extends Button {
	
	private String s1;
	private String s2;
	private Color c;

	public CustomButton(int x, int y) {
		super(x, y, 100, 100, "", null);

	}
	
	public void drawButton(Graphics2D g, boolean hover){
		g.setColor(Color.black);
		g.drawString(s1, 0, 0);
		g.drawString(s2, 10, 10);
		g.setColor(Color.red);
		g.drawOval(0, 0, 100, 100);
		g.fillOval(0, 0, 100, 100);
	}

	public void updateString1(String string) {
		
	}

	public void updateString2(String string) {
		
	}

	public void setIconColor(Color color) {
		
	}
	
}
