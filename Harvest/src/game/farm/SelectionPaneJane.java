package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;
import game.market.BuyingScreen;
import game.market.Inventory;
import game.market.Item;
import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;

public class SelectionPaneJane extends Pane {

	private Button cancel;
	private Button select;
	private Graphic grid;
	private Inventory seedList;
	private int seedSelectedInd;
	private static final int _WIDTH = 225;
	private static final int _HEIGHT = 210;

	public SelectionPaneJane(FocusController focusController, int x, int y) {
		super(focusController, x, y, _WIDTH, _HEIGHT);

	}

	//	static ArrayList<Visible> listFromChoice(int choice){
	//		ArrayList<Visible> listV = new ArrayList<Visible>();
	//		if (choice == 1) {
	//			 Item[] items = {new Item("Corn Seeds", "Great crop to grow all year round", 300, 0, 4),new Item("Pepper Seeds", "Spicy", 50, 1,1),
	//						new Item("Potato Seeds", "Just like me", 150, 2, 3),new Item("Strawberry Seeds", "Sweeter than you", 100, 3,2),
	//						new Item("Tomato Seeds", "Make some good ketchup", 200, 4,3),new Item("Wheat Seeds", "Not weed", 400, 5,5)};
	//			int move = 0;
	//			int width = 48;
	//			int startingHeight =0 ;
	//			int height = 48;
	//			for(Item g: items) {
	//				listV.add(g);
	//				g.setX(move*width);
	//				g.setY(startingHeight);
	//				move++;
	//				if(move == 3){
	//					move = 0;
	//					startingHeight = startingHeight+height;
	//				}
	//			}
	//		}
	//		return listV;
	//	}	
	//	
	//	static ArrayList<Visible> listFromItems(Item[] list){
	//		ArrayList<Visible> listV = new ArrayList<Visible>();
	//		for(int i=0; i<list.length; i++) {
	//			listV.add(list[i]);
	//		}
	//		return listV;
	//	}




	public void update(Graphics2D g){
		//customize the background
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(252,226,148));
		g.fillRoundRect(0, 0, _WIDTH, _HEIGHT,15,15);
		g.setColor(Color.black);
		g.drawRoundRect(0,0, _WIDTH-1,  _HEIGHT-1,15,15);
		//draw the objects
		super.drawObjects(g);
	}

	public void initAllObjects(List<Visible> viewObjects){
		Item[] items = {new Item("Corn Seeds", "Great crop to grow all year round", 300, 0, 4),new Item("Pepper Seeds", "Spicy", 50, 1,1),
				new Item("Potato Seeds", "Just like me", 150, 2, 3),new Item("Strawberry Seeds", "Sweeter than you", 100, 3,2),
				new Item("Tomato Seeds", "Make some good ketchup", 200, 4,3),new Item("Wheat Seeds", "Not weed", 400, 5,5)};
		grid = new Graphic(11,22,280,150, "resources/seedPane.png");
		viewObjects.add(0,grid);

		cancel= new Button(120,_HEIGHT - 30, 60, 25, "Cancel",Color.lightGray, new Action() {

			public void act() {
				SelectionPaneJane.this.setVisible(false);

			}
		});
		viewObjects.add(cancel);
		
		TextLabel label = new TextLabel(15, 0, 150, 50, "");
		viewObjects.add(label);
		int move = 0;
		int width = 55;
		int startingHeight =40 ;
		int height = 60;
		for(int i = 0; i <items.length; i++) {
			Item z=items[i];
			z.setAction(new Action() {

				@Override
				public void act() {
					for(int i = 0; i < items.length;i++) {
						items[i].setSelected(false);
					}
					z.setSelected(true);
					label.setText(z.getName());

				}
			});

			z.setX(35+move*width);
			z.setY(startingHeight);
			move++;
			if(move == 3){
				move = 0;
				startingHeight = startingHeight+height;
			}
			viewObjects.add(z);
		}

		select= new Button(35,_HEIGHT - 30, 60, 25, "Select",Color.lightGray, new Action() {

			public void act() {
				for(int i = 0; i <BuyingScreen.items.length; i++) {
					if(items[i].isSelected()) {
						SelectionPaneJane.this.setSeedSelected(i);
						SelectionPaneJane.this.setVisible(false);

					}
				}
				label.setText("Please select an item");

			}});
		viewObjects.add(select);
	}

	public int setSeedSelected(int i) {
		return seedSelectedInd = i;
	}
	public int getSeedSelected() {
		return seedSelectedInd;
	}
}
