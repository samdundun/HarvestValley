package game.farm;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.interfaces.Visible;

public class EmptyPatch extends Button {
	private int index;

	public EmptyPatch(int x, int y, int w, int h, String text, Color color, Action action, int i) {
		super(x, y, w, h, text,color, new Action() {
			
			@Override
			public void act() {
				FarmScreenAll.patchPane.getLabel().setText("Enlarge your farm!");
				FarmScreenAll.patchPane.getItem().setText("Patch for $1000");
				FarmScreenAll.patchPane.setX(x-250);
				FarmScreenAll.patchPane.setY(y-120);
				FarmScreenAll.patchPane.setSrc("farmPatch");
				FarmScreenAll.patchPane.updateImg(FarmScreenAll.getView());
				FarmScreenAll.patchPane.setVisible(true);
				FarmScreenAll.patchPane.getHarvest().setAction(new Action() {
					
					@Override
					public void act() {
						CropJane newPatch = convertToPatch();
						newPatch.update();
						FarmScreenAll.farmPatch.add(convertToPatch());
						FarmScreenAll.getView().add(newPatch);
						
					}

					private CropJane convertToPatch() {
						CropJane newPatch = new CropJane(x, y, w, h, "", color, action, i, new CropImageJane());
						return newPatch;
					}
				});
			
		}});
		this.index=i;
	}


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
