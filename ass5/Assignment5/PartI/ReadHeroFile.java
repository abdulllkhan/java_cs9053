import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import heros.*;

/* your tasks:
 * create a class called HeroException
 * createHero should throw a HeroException
 * in main(), you should catch the HeroException
 * 
 */
public class ReadHeroFile {

	private static ArrayList<Hero> heros = new ArrayList<Hero>();

	public static Hero createHero(String[] heroInfo) throws HeroException{

		Hero hero = new Hero(heroInfo[0]);
		try{
			hero.setRole(heroInfo[1]);
		} catch(Exception e) {
			throw new HeroException("Invalid role for " + heroInfo[0]);
		}
		hero.gainExperience(Integer.valueOf(heroInfo[3]));
	 	if(hero.getLevel() < Integer.valueOf(heroInfo[2])){
			throw new HeroException("Experience is insufficient to match the level for " + heroInfo[0]);
		} else if (hero.getLevel() > Integer.valueOf(heroInfo[2])){
			throw new HeroException("Experience exceeds the level passed in the file " + heroInfo[0]);
		}
		return hero;

	}
	
	public static void main(String[] args) throws IOException, HeroException, FileNotFoundException {

		try{
			File file = new File("heroes.txt");
			Scanner fileReader = new Scanner(file);
      		while (fileReader.hasNextLine()) {
        		String line = fileReader.nextLine();
				String[] heroInfo = line.split(",");
				Hero createdHero = new Hero("Unassigned");
				try{
					createdHero = createHero(heroInfo);
				} catch(HeroException h){
					System.out.println(h.getMessage());
					continue;
				}
				heros.add(createdHero);
      		}
			fileReader.close();
		} catch(FileNotFoundException fe){
			System.out.println("File not found");
		}
		
	}
}
