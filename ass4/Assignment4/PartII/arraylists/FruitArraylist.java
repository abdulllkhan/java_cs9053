package arraylists;
import java.util.ArrayList;

import fruit.*;
// import fruit;

public class FruitArraylist {	

	public static void main(String[] args) {
		
		// this ArrayList MUST be parameterized
		ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();
		// ArrayList<Fruit> fruitArrayList;
		
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		Apple nonRottenRedApple = new Apple("sweet", "crisp", "red", false);
		Apple rottenGreenApple = new Apple("tart", "soft", "green", true);

		// lemon array
		Lemon[] lemonArray = new Lemon[3];
		// for(int i = 0; i < 3; i++){}
		for(int i = 0; i < lemonArray.length; i++){
			lemonArray[i] = new Lemon((int)(101 * Math.random()), "sour", false);; // what is this?
			// lemonArray[i].setTaste("sour");
			// lemonArray[i].setRotten(false);
			// lemonArray[i].setSourness((int)(101 * Math.random()));
		}

		// rotten oranges array
		Orange[] orangeArray = new Orange[2];
		for(int i = 0; i < orangeArray.length; i++){
			// orange = new Orange();
			orangeArray[i] = new Orange("mandarin", "sweet", true);
			// orange.setType("mandarin");
			// orange.setRotten(true);
			// orange.setTaste("sweet");
		}

		// adding fruits to arrayList
		fruitArrayList.add(nonRottenRedApple);
		// fruitArrayList.add(new Object());
		fruitArrayList.add(rottenGreenApple);

		for(Lemon lemon: lemonArray){
			fruitArrayList.add(lemon);
		}
		for(Orange orange: orangeArray){
			fruitArrayList.add(orange);
		}

		double averageSourness = 0;
		for(Fruit fruit: fruitArrayList){
			if(fruit.getClass() == Lemon.class){
				averageSourness += ((Lemon)fruit).getSourness();
			}
		}
		averageSourness /= 3;
		System.out.println("\nAverage sourness of the lemons is: " + averageSourness + " \n");

		System.out.println("The details of the Apple equal to the Retained Rotten Green Apple object is: ");
		Apple retainedRottenGreenApple = rottenGreenApple;
		for(Fruit fruit: fruitArrayList){
			if(fruit.getClass() == Apple.class && fruit.equals(retainedRottenGreenApple)){
				System.out.println("\n" + fruit.toString() 
						+ "\nThe loop breaks after deleting the printed object, because only 1 of such fruit objects are present in the array.");
				fruitArrayList.remove(fruit);
				break;
			}
		}

		System.out.println("The fruit objects are: ");
		for(Fruit fruit: fruitArrayList){
			System.out.println("\n" + fruit.toString() + "\n");
		}

	}

}
