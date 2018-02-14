package game.farm;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import game.market.SamInventory;
import game.market.ErikInventoryScreen;
import game.market.ErikItem;
import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.DrawInstructions;
import guiTeacher.interfaces.Visible;
import harvest.MainMenu;

public class BoxJenny extends CustomImageButton implements Clickable{

	private int imageIndx;
	private int index;
	private int length;
	private int stage;
	private int time;
	private int currentTime;
	private int x;
	private int y;

	public BoxJenny(int x, int y, String imageAddress, Action action, List<Visible> viewObjects, int i) {
		super(x, y, new Graphic(0,0,imageAddress).getWidth(), new Graphic(0,0,imageAddress).getHeight(), new DrawInstructions() {
			Graphic image = new Graphic(0,0,imageAddress);

			public void draw(Graphics2D g, boolean highlight) {
				g.drawImage(image.getImage(), 0, 0, null);
				if(highlight) {
					g.setColor(new Color(0,0,0,20));
					g.fillRect(0, 0, image.getWidth(), image.getHeight());
				}
			}
		}, new Action() {
			public void act() {
				Graphic image = new Graphic(0,0,imageAddress);
				FarmScreenAll.first.setX(x + image.getWidth() + 10);
				FarmScreenAll.first.setY(y - 50);
				FarmScreenAll.first.setVisible(true);
				FarmScreenAll.first.update();
				FarmScreenAll.first.setIndex(i);
				FarmScreenAll.disableButton(false);
			}
		});
		index = i;
		this.x = x;
		this.y = y;
		length = 5;
	}

	public void changeAction(int i) {
		BoxJenny animal = FarmScreenAll.animalBox.get(index);
		imageIndx = i;
		updateImg(index);
		this.setEnabled(true);
		this.setAction(new Action() {
			public void act() {
				String label = SamInventory.ITEMS[imageIndx + 6].getName().toLowerCase();
				String name = ErikItem.getGraphic()[imageIndx + 6].getImageLocation();
				System.out.println(name);	System.out.println(animal.index);
				int dayLeft = animal.getLength() - animal.getCurrentTime();
				FarmScreenAll.animalPane.setX(animal.getX() + animal.getWidth() + 10);
				FarmScreenAll.animalPane.setY(animal.getY() - 50);
				FarmScreenAll.animalPane.setSrc(name);
				FarmScreenAll.animalPane.updateImg(FarmScreenAll.getView());
				FarmScreenAll.animalPane.setVisible(true);
				if(animal.getLength() != animal.getCurrentTime()) {
					FarmScreenAll.animalPane.getLabel().setText(dayLeft + " days until harvest");
					FarmScreenAll.animalPane.getHarvest().setAction(new Action() {
						public void act() {
							FarmScreenAll.animalPane.getLabel().setText("Can not harvest yet");
						}
					});
				}
				else {
					FarmScreenAll.animalPane.getLabel().setText("Ready to harvest");
					FarmScreenAll.animalPane.getHarvest().setAction(new Action() {
						public void act() {
							FarmScreenAll.disableButton(true);
							FarmScreenAll.animalPane.getImg().setVisible(false);
							FarmScreenAll.animalPane.setVisible(false);
						}
					} );
					animal.setAction(new Action() {
						public void act() {
							Graphic image = new Graphic(0,0,"resources/nothing.png");
							FarmScreenAll.first.setX(x + image.getWidth() + 10);
							FarmScreenAll.first.setY(y - 50);
							FarmScreenAll.first.setVisible(true);
							FarmScreenAll.first.update();
							FarmScreenAll.first.setIndex(imageIndx);
							FarmScreenAll.disableButton(false);
						}
					});
				}
				FarmScreenAll.animalPane.getItem().setText(label);
				FarmScreenAll.animalPane.update();
				FarmScreenAll.disableButton(false);
			}
		});
		grow();
	}

	private void grow() {
		Thread grower = new Thread(new Runnable() {
			public void run() {
				int stageTime = (time*3000)/length;
				currentTime=0;
				for(int i = 0; i< length; i++) {
					try {
						Thread.sleep(stageTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					currentTime++;
					update();

				}
			}
		});
		grower.start();

	}

	private void updateImg(int idx) {
		SelectionPaneJane.setSrc(game.market.ErikItem.getGraphic()[imageIndx].getImageLocation());
		String src = SelectionPaneJane.getSrc();
		FarmScreenAll.animalBox.remove(idx);
		BoxJenny animal = new BoxJenny(x + 25, y + 30, src, null, FarmScreenAll.getView(), idx);
		FarmScreenAll.animalBox.add(idx, animal);
		MainMenu.farmScreen.addObjectToBack(animal);
	}

	public void moveToBack(Visible v){
		if(FarmScreenAll.getView().contains(v)){
			FarmScreenAll.getView().remove(v);//all other objects slide up in order
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
		time = time2;

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
