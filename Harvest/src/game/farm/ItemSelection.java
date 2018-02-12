package game.farm;

import game.market.Item;

public interface ItemSelection {
	//returns an array of imageIndex of seeds in the inventory
	int[] getSeedSelection();
	
	//returns returns an array of imageIndex of animals in the inventory
	int[] getAnimalSelection();
			
}
