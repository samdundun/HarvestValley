package playground;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Catalog {

	private static ArrayList<Song> list;
	private static boolean adding;
	private static boolean running;

	public Catalog() {
		list = new ArrayList<Song>();
		list.add(new Song("TT", "Twice", 180));
		list.add(new Song("Ooh-Ahh", "Twice", 180));
		list.add(new Song("Cheer Up", "Twice", 180));
		list.add(new Song("Heart Shaker", "Twice", 180));

		adding = true;
		running = true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Catalog c = new Catalog();

		System.out.println("Welcome to the K-Pop Catalog!\nIf you would like to see the catalog press the spacebar!\nIf you want to add more songs press a");
		while(running) {
			String s = in.nextLine();
			if(s.equalsIgnoreCase("a")) {
				adding = true;
				while(adding) {
					System.out.println("Please enter the title");
					String temp1 = in.nextLine();
					System.out.println("Please enter the artist");
					String temp2 = in.nextLine();
					System.out.println("Please enter the song length in seconds");
					String temp3 = in.nextLine();

					list.add(new Song(temp1,temp2,Integer.parseInt(temp3)));

					System.out.println("Would you like to enter another one?");
					s = in.nextLine();
					if(s.equalsIgnoreCase("yes")) {

					}
					else {
						adding = false;
					}
				}
			}
			else if(s.equals(" ")) {
				System.out.println(c.getCSVContent());
			}
			else if(s.equals("x")) {
				running = false;
			}
			else {
				System.out.println("Sorry I didn't understand");
			}
			
			System.out.println("What now?");
		}
		
		saveContent("list.csv", c.getCSVContent());
		
	}

	public String getCSVContent() {
		String data = "";
		for(Song s : list) {
			data+=s + "\n";
		}
		return data;
	}
	
	private static void saveContent(String fileName, String content) {

		try{    

			FileWriter fw=new FileWriter(fileName);    

			fw.write(content);    

			fw.close();    

			System.out.println("Success! File \""+fileName+"\" saved!");

		}catch(IOException e){

			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");

		}



	}
}
