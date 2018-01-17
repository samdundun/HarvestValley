package game;

public class AnimalJenny {

	private String name;
	private String src;
	private AnimalProduceJenny produce;
	private String[] names;
	private String[] items;
	private int index;

	public AnimalJenny(String name, String src) {
		this.name = name;
		this.src = src;
		
		String[] temp = {"chicken", "sheep", "cow", "pig"};
		names = temp;

		String[] temp2 = {"egg", "wool", "milk", "meat"};
		names = temp2;
		
		for(int i = 0; i < names.length; i++) {
			if(name.equals(names[i]))
				index = i;
		}
		this.produce = new AnimalProduceJenny(items[index], "resources/");
	}

	public String getName() {
		return name;
	}

	public String getSrc() {
		return src;
	}
	
	public AnimalProduceJenny getProduce() {
		return produce;
	}
}
