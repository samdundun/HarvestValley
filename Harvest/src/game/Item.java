package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import guiTeacher.components.Action;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.DrawInstructions;

public class Item extends CustomImageButton implements Clickable{
	
	public static final Graphic[] veggies = {new Graphic(0,0,48,48,"resources/Corn.png"),new Graphic(0,0,48,48,"resources/Tomato.png")};
	
	private String name;
	private int image;
	private String description;
	private int value;
	private boolean selected;
	private Color color;

	public static final int HEIGHT = 48;
	public static final int WIDTH = 48;
	//CO
	public Item(String name, String description, int value, int imageIndex) {
		super(0,0,48,48,new DrawInstructions() {

			Graphic image = veggies[imageIndex];

			@Override
			public void draw(Graphics2D g, boolean highlight) {
				if(highlight){
					float scaleFactor = 0.9f;
					//					RescaleOp op = new RescaleOp(scaleFactor, 0, null);
					//					BufferedImage light = op.filter(image.getImage(), null);
					g.drawImage(image.getImage(), 0, 0, null);
					g.setColor(new Color(0,0,0,30));
					g.fillRect(0, 0, WIDTH, HEIGHT);
					//					bufferedImage = op.filter(image.getImage(), null);
				}
				else {
					g.drawImage(image.getImage(), 0, 0, null);
				}
				//				g.setColor(new Color(100+(int)(100*Math.random()),100+(int)(100*Math.random()),100+(int)(100*Math.random())));
				//				g.fillRect(22, 0, WIDTH-23, HEIGHT-1);
				//				g.setColor(Color.black);
				//				g.drawString(name, 26, HEIGHT/2-6);
				//				g.drawRect(22, 0, WIDTH-23, HEIGHT-1);
			}
		},null);
		//		super(0,0, 48, 48, imageLocation);
		this.name = name;
		this.image = imageIndex;
		this.value = value;
		this.description = description;
		this.selected = false;
		this.color = new Color(100+(int)(100*Math.random()),100+(int)(100*Math.random()),100+(int)(100*Math.random()));
		update();
	}

	public String toString(){
		return name+","+image+","+value;
	}
	//
	//
	//	public boolean isHovered(int x, int y) {
	//		return x>getX() && x < getX()+getWidth() && y > getY() && y < getY() + getHeight();
	//	}
	//
	//	public void act() {
	//		selected = !selected;
	//		update();
	//	}
	public boolean isSelected() {
		return selected;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
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
