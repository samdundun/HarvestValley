package game.farm;

import java.util.ArrayList;

import game.market.ErikItem;

public interface ItemSelectionJane {
	//returns an array of imageIndex of seeds in the inventory
	ArrayList<ErikItem> getSeedSelection();
	
	//returns returns an array of imageIndex of animals in the inventory
	ArrayList<ErikItem> getAnimalSelection();
			
}
