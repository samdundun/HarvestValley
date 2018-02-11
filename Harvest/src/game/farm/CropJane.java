package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;

import game.mainScreen.ImageButton;
import game.market.Inventory;
import game.market.Item;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;

public class CropJane extends CustomImageButton {
	
	private int imageIndx;
	private int index;
	private CropImage image;
	private int length;
	private int stage;
	private int time;
	private int currentTime;
	private Inventory invent;
	
	public CropJane(int x, int y, int w, int h, String text, Color color, Action action, int i, CropImage image) {
		super(x, y, w, h,image, new Action() {
			public void act() {
				FarmScreenAll.pane.setX(x-250);
				FarmScreenAll.pane.setY(y-120);
				FarmScreenAll.pane.setVisible(true);
				FarmScreenAll.pane.update();
				FarmScreenAll.pane.setIndex(i);
				FarmScreenAll.disableButton(false);
			}
		});
		index=i;
		this.image=image;
	}
	
	public void crop(int i) {
		changeAction();
		imageIndx=i;
		if(i==5) {
			length=5;
		}
		else
			length=6;
		stage = i*6;
		image.setIndex(stage);
		update();
		startGrowing();
	}
	private void changeAction() {
		invent = new Inventory();
		invent.load();
		this.setAction(new Action() {
			
			@Override
			public void act() {
				CropJane currentPatch=FarmScreenAll.farmPatch.get(index);
				int dayLeft =currentPatch.getLength()-currentPatch.getCurrentTime();
				FarmScreenAll.plantPane.setX(currentPatch.getX()-250);
				FarmScreenAll.plantPane.setY(currentPatch.getY()-120);
				FarmScreenAll.plantPane.setSrc("corn");
				FarmScreenAll.plantPane.updateImg(FarmScreenAll.getView());
				FarmScreenAll.plantPane.setVisible(true);
				//FarmScreenAll.plantPane.updateImg("resources/corn.png");
				if(currentPatch.getLength()!=currentPatch.getCurrentTime()) {
					FarmScreenAll.plantPane.getLabel().setText(dayLeft+" days until harvest");
				FarmScreenAll.plantPane.getHarvest().setAction(new Action() {
					@Override
					public void act() {
						FarmScreenAll.plantPane.getLabel().setText("Crop is not ready yet");
						
					}
				});
				}
				else {
					FarmScreenAll.plantPane.getLabel().setText("Crop is ready to harvest");
					FarmScreenAll.plantPane.getHarvest().setAction(new Action() {
						
						@Override
						public void act() {
							currentPatch.harvest(PlantJane.plants.length-1);
							FarmScreenAll.plantPane.setVisible(false);
							FarmScreenAll.plantPane.getImg().setVisible(false);
							FarmScreenAll.disableButton(true);
							invent.addItem(SelectionPaneJane.items[FarmScreenAll.farmPatch.get(index).imageIndx+6]);
							invent.save();
						}
					} );
				}
				FarmScreenAll.plantPane.getItem().setText(SelectionPaneJane.items[FarmScreenAll.farmPatch.get(index).imageIndx].getName());
				FarmScreenAll.plantPane.update();
				FarmScreenAll.disableButton(false);
				
			}
		});
		
	}

	public void harvest(int i) {
		image.setIndex(i);
		update();
	}
	public void startGrowing() {
		Thread grower = new Thread(new Runnable() {

			public void run() {
				currentTime=0;
				for(int i = 0; i< length; i++) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						image.setIndex(stage++);
						currentTime++;
						update();
					
				}
			}
		});
		grower.start();

	}

	@Override
	public void drawButton(Graphics2D g, boolean hovered){
		if(image != null) {
			clear();
			image.draw(g, hovered);
		}
	}
	
	public void printSelected(int x) {
		System.out.println(x);
	}
	
	public int getIndex() {
		return index;
	}
	public void setColor(Color red) {
		this.setForeground(red);
		
	}

	public void setTime(int time2) {
		time=time2;
		
	}
	
	public int getLength() {
		return length;
	}

	public int getStage() {
		// TODO Auto-generated method stub
		return stage;
	}

	public int getCurrentTime() {
		// TODO Auto-generated method stub
		return currentTime;
	}


}
