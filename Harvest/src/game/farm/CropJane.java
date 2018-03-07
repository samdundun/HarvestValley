package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import game.mainScreen.LubnaImageButton;

import game.market.SamInventory;
import game.market.ErikItem;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.DrawInstructions;
import harvest.MainMenu;

public class CropJane extends CustomImageButton{
	
	private int imageIndx;
	private int index;
	public static int impNum;

	private int patchIndex;
	private CropImageJane image;
	private int length;
	private int stage;
	private int time;
	private int currentTime;
	private SamInventory invent;
	private Action orginAction;
	
	public CropJane(int x, int y, int w, int h, String text, Color color, Action action, int i, CropImageJane image, int j) {
		super(x, y, w, h,image, new Action() {
			public void act() {
				updatePane();
				FarmScreenAll.pane.setX(x-250);
				FarmScreenAll.pane.setY(y-120);
				FarmScreenAll.pane.setIndex(i);
				FarmScreenAll.pane.setPatchIndex(j);
				if(i>5) {
					changeSetting(7,78,true);
				}
				else {
					changeSetting(35,120,false);
				}
				FarmScreenAll.pane.update();
				FarmScreenAll.pane.setVisible(true);
				FarmScreenAll.disableButton(false);
			}

			private void updatePane() {
				ArrayList<ErikItem> seeds = SelectionPaneJane.invent.getSeedSelection();
				int move=0;
				int startingHeight=40;
				for(int i = 0; i < seeds.size(); i++) {
					ErikItem z=seeds.get(i);
					if(SelectionPaneJane.invent.getAmountArray()[z.getImageIndex()] > 0 && z.isAdded() == false) {
						z.setAdded(true);
						for(ErikItem it:seeds) {
							if(it.getImageIndex() == z.getImageIndex()) {
								it.setAdded(true);
							}
						}
						z.setAction(new Action() {

							@Override
							public void act() {
								for(int i = 0; i < seeds.size();i++) {
									seeds.get(i).setSelected(false);
								}
								System.out.println(z.getName());
								z.setSelected(true);
								SelectionPaneJane.getLabel().setText(z.getName());
							}
						});

						z.setX(35+40*60);
						z.setY(55);
						move++;
						if(move == 3){
							move = 0;
							startingHeight = 55+60;
						}
						MainMenu.farmScreen.pane.addObject(z);
					}
				}
				
			}

			private void changeSetting(int i, int j, boolean b) {
				FarmScreenAll.pane.getSelect().setX(i);
				FarmScreenAll.pane.getCancel().setX(j);
				FarmScreenAll.pane.getSell().setVisible(b);
				FarmScreenAll.pane.getSell().setEnabled(b);
				
			}
		});
		index=i;
		this.patchIndex=j;
		this.image=image;
	}
	
	public void crop(int i) {
		changeAction();
		imageIndx=i;
		time=SelectionPaneJane.items[i].getTime();
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
		this.setAction(new Action() {
			
			@Override
			public void act() {
				PaneJenny plantPane =FarmScreenAll.plantPane;
				CropJane currentPatch=FarmScreenAll.farmPatch.get(index);
				
				String cropName = SelectionPaneJane.items[currentPatch.imageIndx+6].getName().toLowerCase();
				int dayLeft =currentPatch.getLength()-currentPatch.getCurrentTime();
				setPosition();
				plantPane.setSrc("resources/" + cropName + ".png");
				plantPane.updateImg(FarmScreenAll.getView());
				plantPane.setVisible(true);
				if(currentPatch.getLength()!=currentPatch.getCurrentTime()) {
					plantPane.getLabel().setText(dayLeft+" days until harvest");
				plantPane.getHarvest().setAction(new Action() {
					@Override
					public void act() {
						plantPane.getLabel().setText("Crop is not ready yet");
						
					}
				});
				}
				else {
					plantPane.getLabel().setText("Crop is ready to harvest");
					plantPane.getHarvest().setAction(new Action() {
						
						@Override
						public void act() {
							currentPatch.harvest(PlantJane.plants.length-1);
							plantPane.setVisible(false);
							plantPane.getImg().setVisible(false);
							FarmScreenAll.disableButton(true);
							SelectionPaneJane.invent.load();
							SelectionPaneJane.invent.addItem(SelectionPaneJane.items[currentPatch.imageIndx+6]);
							

							impNum = currentPatch.imageIndx+6;
							SleepAlex.cropIncrement();
							
							//Jane uses the items array
							
							SelectionPaneJane.invent.save();
							currentPatch.setAction(new Action() {
								
								@Override
								public void act() {
									updatePane();
									FarmScreenAll.pane.setVisible(true);
									FarmScreenAll.pane.setIndex(index);
									FarmScreenAll.pane.setPatchIndex(patchIndex);
									FarmScreenAll.pane.update();
									FarmScreenAll.disableButton(false);
									
								}

								private void updatePane() {
									ArrayList<ErikItem> seeds = SelectionPaneJane.invent.getSeedSelection();
									int move=0;
									int startingHeight=40;
									for(int i = 0; i < seeds.size(); i++) {
										ErikItem z=seeds.get(i);
										if(SelectionPaneJane.invent.getAmountArray()[z.getImageIndex()] > 0 && z.isAdded() == false) {
											z.setAdded(true);
											for(ErikItem it:seeds) {
												if(it.getImageIndex() == z.getImageIndex()) {
													it.setAdded(true);
												}
											}
											z.setAction(new Action() {

												@Override
												public void act() {
													for(int i = 0; i < seeds.size();i++) {
														seeds.get(i).setSelected(false);
													}
													System.out.println(z.getName());
													z.setSelected(true);
													SelectionPaneJane.getLabel().setText(z.getName());
												}
											});

											z.setX(35+40*60);
											z.setY(55);
											move++;
											if(move == 3){
												move = 0;
												startingHeight = 55+60;
											}
											MainMenu.farmScreen.pane.addObject(z);
										}
									}
									
								}
							});
						}
					} );
				}
				plantPane.getItem().setText(cropName);
				plantPane.update();
				FarmScreenAll.disableButton(false);
				
				
			}

			private void setPosition() {
				FarmScreenAll.plantPane.setX(FarmScreenAll.farmPatch.get(index).getX()-250);
				FarmScreenAll.plantPane.setY(FarmScreenAll.farmPatch.get(index).getY()-120);
				
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
				//grows the crop base on the day and how many stage change the crop has
				int stageTime =(time*3000)/length;
				currentTime=0;
				for(int i = 0; i< length; i++) {
					try {
						Thread.sleep(stageTime);
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

	public int getPatchIndex() {
		// TODO Auto-generated method stub
		return patchIndex;
	}

	
	
}
