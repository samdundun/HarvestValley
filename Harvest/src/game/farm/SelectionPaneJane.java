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
	private static final int _HEIGHT = 195;
	
	public SelectionPaneJane(FocusController focusController, int x, int y, Item[] selection, Action action) {
		super(focusController, x, y, _WIDTH, _HEIGHT, listFromItems(selection));
		select.setAction(action);
		int move = 0;
		int width = 48;
		int startingHeight =0 ;
		int height = 48;
		
		for(Item i:selection) {
			i.setX(move*width);
			i.setY(0);
			move++;
			if(move == 3){
				move = 0;
				startingHeight = startingHeight+height;
			}
////			addObject(i);
		}
	}

	static ArrayList<Visible> listFromChoice(int choice){
		ArrayList<Visible> listV = new ArrayList<Visible>();
		if (choice == 1) {
			Graphic[] items = {new Graphic(0,0,48,48,"resources/cornseeds.png"),
					new Graphic(0,0,48,48,"resources/pepperseeds.png"),new Graphic(0,0,48,48,"resources/potatoseeds.png"),
					new Graphic(0,0,48,48,"resources/strawberryseeds.png"),new Graphic(0,0,48,48,"resources/tomatoseeds.png"),
					new Graphic(0,0,48,48,"resources/wheatseeds.png"), new Graphic(0,0,48,48,"resources/corn.png"),
					new Graphic(0,0,48,48,"resources/pepper.png"),new Graphic(0,0,48,48,"resources/potato.png"),
					new Graphic(0,0,48,48,"resources/strawberry.png"),new Graphic(0,0,48,48,"resources/tomato.png"),
					new Graphic(0,0,48,48,"resources/wheat.png")};
			int move = 0;
			int width = 48;
			int startingHeight =0 ;
			int height = 48;
			for(Graphic g: items) {
				listV.add(g);
				g.setX(move*width);
				g.setY(startingHeight);
				move++;
				if(move == 3){
					move = 0;
					startingHeight = startingHeight+height;
				}
			}
		}
		return listV;
	}	
	
	static ArrayList<Visible> listFromItems(Item[] list){
		ArrayList<Visible> listV = new ArrayList<Visible>();
		for(int i=0; i<list.length; i++) {
			listV.add(list[i]);
		}
		return listV;
	}
	
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
		grid = new Graphic(11,10,280,150, "resources/seedPane.png");
		viewObjects.add(0,grid);
		
		
		select= new Button(30,_HEIGHT - 30, 60, 25, "Select",Color.lightGray, null); 
		viewObjects.add(select);
		
		cancel= new Button(115,_HEIGHT - 30, 60, 25, "Cancel",Color.lightGray, new Action() {

			public void act() {
				SelectionPaneJane.this.setVisible(false);

			}
		});
		viewObjects.add(cancel);
	}
	
	 public int setSeedSelected(int i) {
		 return seedSelectedInd = i;
	 }
	public int getSeedSelected() {
		return seedSelectedInd;
	}
}
