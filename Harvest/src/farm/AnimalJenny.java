package farm;

public class AnimalJenny {

	private String name;
	private String src;
	private AnimalProduceJenny produce;
	private String[] names;
	private String[] items;
	private int[] rates;
	private int index;
	private int productionRate;

	public AnimalJenny(String name) {
		this.name = name;
		src = "resources/" + name;
		
		String[] temp = {"chicken", "sheep", "cow", "pig"};
		names = temp;

		String[] temp2 = {"egg", "wool", "milk", "meat"};
		items = temp2;
		
		int[] temp3 = {3, 2, 1, 4};
		rates = temp3;
		
		for(int i = 0; i < names.length; i++) {
			if(name.equals(names[i]))
				index = i;
		}
		this.produce = new AnimalProduceJenny(items[index], rates[index], "resources/" + items[index]);
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
