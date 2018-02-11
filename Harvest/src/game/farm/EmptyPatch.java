package game.farm;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class EmptyPatch extends Button {
	private int index;
	
	public EmptyPatch(int x, int y, int w, int h, String text, Color color, Action action) {
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public EmptyPatch(int x, int y, int w, int h, String text, Color color, Action action, int i) {
		super(x, y, w, h, text,color, action);
		this.index=i;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
