package samErikMarket;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Action;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.interfaces.Clickable;

public class Item extends ClickableGraphic implements Clickable{

	private String name;
	private String image;
	private int value;
	private boolean selected;
	private Color color;
	
	public Item(String name, int value, String imageLocation, int x, int y) {
		super(x, y, 30, 30, imageLocation);
		this.name = name;
		this.image = imageLocation;
		this.value = value;
		this.selected = false;
		this.color = new Color(100+(int)(100*Math.random()),100+(int)(100*Math.random()),100+(int)(100*Math.random()));
		update();
	}
	
	public String toString(){
		return name+","+image+","+value;
	}

	public void update(Graphics2D g) {
		g.setColor(new Color(100,200,255));
		if(selected){
			g.fillOval(1, getHeight()/2-10, 20, 20);
		}
		else {
			g.setColor(Color.white);
			g.fillOval(1, getHeight()/2-10, 20, 20);
			g.setColor(new Color(100,200,255));
			g.drawOval(1, getHeight()/2-10, 20, 20);
		}
		g.setColor(this.color);
		g.fillRect(22, 0, getWidth()-23, getHeight()-1);
		g.setColor(Color.black);
		g.drawString(name, 26, getHeight()/2-6);
		g.drawRect(22, 0, getWidth()-23, getHeight()-1);
	}


	public boolean isHovered(int x, int y) {
		return x>getX() && x < getX()+getWidth() && y > getY() && y < getY() + getHeight();
	}

	public void act() {
		selected = !selected;
		update();
	}

	public boolean isSelected() {
		return selected;
	}

	
//	public Item(int x, int y, double scale, String imageLocation) {
//		super(x, y, scale, imageLocation);
//		// TODO Auto-generated constructor stub
//	}
//
//	public Item(int x, int y, String imageLocation) {
//		super(x, y, imageLocation);
//		// TODO Auto-generated constructor stub
//	}

}
