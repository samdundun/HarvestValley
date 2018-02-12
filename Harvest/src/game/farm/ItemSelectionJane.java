package game.farm;

import game.market.Item;

public interface ItemSelectionJane {
	//returns an array of imageIndex of seeds in the inventory
	int[] getSeedSelection();
	
	//returns returns an array of imageIndex of animals in the inventory
	int[] getAnimalSelection();
			
}
