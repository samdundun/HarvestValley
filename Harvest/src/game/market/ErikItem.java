package game.market;

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

public class ErikItem extends CustomImageButton implements Clickable{
<<<<<<< HEAD

	public static final Graphic[] ITEMS = {new Graphic(0,0,48,48,"resources/cornseeds.png"),
			new Graphic(0,0,48,48,"resources/pepperseeds.png"),new Graphic(0,0,48,48,"resources/potatoseeds.png"),
			new Graphic(0,0,48,48,"resources/strawberryseeds.png"),new Graphic(0,0,48,48,"resources/tomatoseeds.png"),
			new Graphic(0,0,48,48,"resources/wheatseeds.png"), new Graphic(0,0,48,48,"resources/corn.png"),
			new Graphic(0,0,48,48,"resources/pepper.png"),new Graphic(0,0,48,48,"resources/potato.png"),
			new Graphic(0,0,48,48,"resources/strawberry.png"),new Graphic(0,0,48,48,"resources/tomato.png"),
			new Graphic(0,0,48,48,"resources/wheat.png"),new Graphic(0,0,48,48,"resources/brownChicken.png"),
			new Graphic(0,0,48,48,"resources/whiteChicken.png"),new Graphic(0,0,48,48,"resources/blackChicken.png"),
			new Graphic(0,0,48,48,"resources/sheep.png"),new Graphic(0,0,48,48,"resources/cow.png"),
			new Graphic(0,0,48,48,"resources/pig.png"),new Graphic(0,0,48,48,"resources/brownEgg.png"),
			new Graphic(0,0,48,48,"resources/whiteEgg.png"),new Graphic(0,0,48,48,"resources/blackEgg.png"),
			new Graphic(0,0,48,48,"resources/wool.png"),new Graphic(0,0,48,48,"resources/milk.png"),

			new Graphic(0,0,48,48,"resources/meat.png")};

=======

	public static final Graphic[] ITEMS = {new Graphic(0,0,48,48,"resources/cornseeds.png"),
			new Graphic(0,0,48,48,"resources/pepperseeds.png"),new Graphic(0,0,48,48,"resources/potatoseeds.png"),
			new Graphic(0,0,48,48,"resources/strawberryseeds.png"),new Graphic(0,0,48,48,"resources/tomatoseeds.png"),
			new Graphic(0,0,48,48,"resources/wheatseeds.png"), new Graphic(0,0,48,48,"resources/corn.png"),
			new Graphic(0,0,48,48,"resources/pepper.png"),new Graphic(0,0,48,48,"resources/potato.png"),
			new Graphic(0,0,48,48,"resources/strawberry.png"),new Graphic(0,0,48,48,"resources/tomato.png"),
			new Graphic(0,0,48,48,"resources/wheat.png"),new Graphic(0,0,48,48,"resources/brownChicken.png"),
			new Graphic(0,0,48,48,"resources/whiteChicken.png"),new Graphic(0,0,48,48,"resources/blackChicken.png"),
			new Graphic(0,0,48,48,"resources/sheep.png"),new Graphic(0,0,48,48,"resources/cow.png"),
			new Graphic(0,0,48,48,"resources/pig.png"),new Graphic(0,0,48,48,"resources/brownEgg.png"),
			new Graphic(0,0,48,48,"resources/whiteEgg.png"),new Graphic(0,0,48,48,"resources/blackEgg.png"),
			new Graphic(0,0,48,48,"resources/wool.png"),new Graphic(0,0,48,48,"resources/milk.png"),

			new Graphic(0,0,48,48,"resources/meat.png")};

>>>>>>> refs/heads/develop
	
	private String name;
	private int image;
	private String description;
	private int value;
	private boolean selected;
	private Color color;
	private int amount;
	private boolean added;
	private int time;
	
	
	public static Graphic[] getGraphic() {
		return ITEMS;
	}
	
	public int getTime() {
		return time;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public static final int HEIGHT = 48;
	public static final int WIDTH = 48;
	
	public ErikItem(String name, String description, int value, int imageIndex, int time) {
		super(0,0,48,48,new DrawInstructions() {

			Graphic image = ITEMS[imageIndex];

			@Override
			public void draw(Graphics2D g, boolean highlight) {
				if(highlight){
					float scaleFactor = 0.9f;
					//RescaleOp op = new RescaleOp(scaleFactor, 0, null)
					//BufferedImage light = op.filter(image.getImage(), null);
					g.drawImage(image.getImage(), 0, 0, null);
					g.setColor(new Color(0,0,0,30));
					g.fillRect(0, 0, WIDTH, HEIGHT);
					//bufferedImage = op.filter(image.getImage(), null);

				}
				
//				else if(selected){
//					float scaleFactor = 1.5f;
//					//RescaleOp op = new RescaleOp(scaleFactor, 0, null)
//					//BufferedImage light = op.filter(image.getImage(), null);
//					g.drawImage(image.getImage(), 0, 0, null);
//					g.setColor(new Color(0,0,0,30));
//					g.fillRect(0, 0, WIDTH, HEIGHT);
//				}
				
				else {
					g.drawImage(image.getImage(), 0, 0, null);
				}
				//				g.setColor(new Color(100+(int)(100*Math.random()),100+(int)(100*Math.random()),100+(int)(100*Math.random())));
				//				g.fillRect(22, 0, WIDTH-23, HEIGHT-1);
				//				g.setColor(Color.black);
				//				g.drawString(name, 26, HEIGHT/2-6);
				//				g.drawRect(22, 0, WIDTH-23, HEIGHT-1)
			}
		},null);
		//		super(0,0, 48, 48, imageLocation);
		this.name = name;
		this.image = imageIndex;
		this.value = value;
		this.description = description;
		this.selected = false;
		this.added = false;
		this.color = new Color(100+(int)(100*Math.random()),100+(int)(100*Math.random()),100+(int)(100*Math.random()));
		this.time = time;
		update();
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString(){
		return name+","+ description + "," +value+","+image + ","+time;
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
	
	public int getImageIndex() {
		return image;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

	public int getStage() {
		// TODO Auto-generated method stub
		return 0;
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
