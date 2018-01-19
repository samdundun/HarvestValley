package game;

import guiTeacher.components.Action;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.*;

public class SaveButtonJessi extends Button {

	private Color color;

	public SaveButtonJessi(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		update();
	}
	
	@Override
	public void setColor(Color color) {
		this.setBackground(color);
		this.color = color;
		update();
	}

	@Override
	public void highlight() {
		this.setBackground(Color.black);
		update();
	}

	@Override
	public void dim() {
		this.setBackground(this.color);
		update();
	}
	
	public void drawButton(Graphics2D g, boolean hover) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawShape(g, hover);
		g.setBackground(color);
	}

}
