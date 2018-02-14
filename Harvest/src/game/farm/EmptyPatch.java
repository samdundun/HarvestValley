package game.farm;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;
import harvest.MainMenu;

public class EmptyPatch extends Button {
	private int index;
	private int patchIndex;
	
	public EmptyPatch(int x, int y, int w, int h, String text, Color color, Action action, int i, int j) {
		super(x, y, w, h, text,color, null);
		setAction(new Action() {
			
			@Override
			public void act() {
				FarmScreenAll.patchPane.getLabel().setText("Enlarge your farm!");
				FarmScreenAll.patchPane.getItem().setText("Patch for $1000");
				FarmScreenAll.patchPane.setX(x-250);
				FarmScreenAll.patchPane.setY(y-120);
				FarmScreenAll.patchPane.setSrc("resources/farmPatch.png");
				FarmScreenAll.patchPane.updateImg(FarmScreenAll.getView());
				FarmScreenAll.patchPane.setVisible(true);
				FarmScreenAll.disableEmptyPatch(false);
				FarmScreenAll.patchPane.getHarvest().setAction(new Action() {
					
					@Override
					public void act() {
						CropJane newPatch = convertToPatch();
						newPatch.update();
						FarmScreenAll.farmPatch.add(newPatch);
						MainMenu.farmScreen.addObjectToBack(newPatch);
						MainMenu.farmScreen.remove(EmptyPatch.this);
						FarmScreenAll.patchPane.setVisible(false);
						FarmScreenAll.patchPane.getImg().setVisible(false);
						FarmScreenAll.disableEmptyPatch(true);
					}

					private CropJane convertToPatch() {
						int ind=FarmScreenAll.farmPatch.size();
						CropJane newPatch = new CropJane(x, y, w, h, "", color, null, ind, new CropImageJane(),j);
						return newPatch;
					}
				});
			
		}
		});
		this.patchIndex=j;
		System.out.println(i);
	}


	public int getIndex() {
		return index;
	}


	
	
}
