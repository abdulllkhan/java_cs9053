package heros;

import java.util.ArrayList;

public class Party {

	private ArrayList<Hero> heroes; // will automatically be null
	
	public Party() {
		heroes = new ArrayList<Hero>();
	}

	// public void addHero(Hero hero, int index) {
	// 	for (Hero h: heroes) {
	// 		if (h == hero) {
	// 			System.out.println(hero.getName() + " is already in the party");
	// 			return;
	// 		}
	// 	}
	// 	heroes[index] = hero;
	// }

	public void addHero(Hero hero) {
		for (Hero h: this.heroes) {
			if (h == hero) {
				System.out.println(hero.getName() + " is already in the party");
				return;
			}
		}
		this.heroes.add(hero);
		return;
	}
	
	// public void removeHero(int index) {
	// 	if ( (heroes[index] != null)) {
	// 		heroes[index] = null;
	// 		index++;
	// 		while ((index < heroes.length) && 
	// 				(heroes[index] != null)) {
	// 			heroes[index-1] = heroes[index];
	// 			heroes[index] = null;
	// 			index++;
	// 		}
	// 	}
	// }

	public void removeHero(Hero hero) {
		this.heroes.remove(hero);
	}
	
	// public Hero getHero(int index) {
	// 	return heroes[index];
	// }

	public Hero getHero(Hero hero) {
		for (Hero h: this.heroes) {
			if (h == hero) {
				return h;
			}
		}
		return null;
	}
	
	// public void gainExperience(int experience) {
	// 	System.out.println("the party has gained " + experience + " experience");
	// 	int numHeroes = 0;
	// 	int index = 0;

	// 	while (heroes[index] != null) {
	// 		numHeroes++;
	// 		index++;
	// 	}
	// 	// we will be generous and round up.
	// 	int individualExperience = (int)Math.ceil((1.0*experience)/numHeroes);

	// 	index = 0;
	// 	while (heroes[index] != null) {
	// 		heroes[index].gainExperience(individualExperience);
	// 		index++;
	// 	}
	// }

	public void gainExperience(int experience) {
		System.out.println("the party has gained " + experience + " experience");
		int numHeroes = this.heroes.size();
		// int index = 0;
		int individualExperience = (int)Math.ceil((1.0*experience)/numHeroes);

		for (Hero h: this.heroes) {
			h.gainExperience(individualExperience);
		}
		return;

	}
	
	// public String toString() {
	// 	// you don't have to use StringBuilder, but it's 
	// 	// the most efficient
	// 	StringBuilder sb = new StringBuilder("Party:\n");
	// 	int index = 0;
	// 	while ((index < heroes.length) && (heroes[index] != null)){
	// 		sb.append(heroes[index].toString() + "\n");
	// 		index++;
	// 	}
	// 	return sb.toString();
	// }

	public String toString() {
		// you don't have to use StringBuilder, but it's 
		// the most efficient
		// int index = 0;
		if(this.heroes.size() == 0) {
			return "Party is empty";
		}
		// while ((index < heroes.length) && (heroes[index] != null)){
			// 	sb.append(heroes.toString() + "\n");
			// }
		StringBuilder sb = new StringBuilder("Party:\n");
		for (Hero h: this.heroes) {
			sb.append(h.toString() + "\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Hero h1 = new Hero("Bob");
		h1.setRole("Warrior");
		Hero  h2  = new Hero("John");
		h2.setRole("Wizard");
		Hero h3 = new Hero("Jane");
		h3.setRole("Priest");
		Hero h4 = new Hero("Dimitri");
		h4.setRole("Thief");
		
		// Party p = new Party();
		// p.addHero(h1, 0);
		// p.addHero(h2, 1);
		// p.addHero(h3, 2);

		// System.out.println(p);
		// p.removeHero(2);

		// System.out.println(p);
		// p.addHero(h4, 2);

		// System.out.println(p);
		// p.removeHero(0);
		// System.out.println(p);
		// p.addHero(h3, 2);
		// System.out.println(p);
		// p.addHero(h3, 0);
		// System.out.println(p);
		// p.addHero(h1, 2);
		// System.out.println(p);

		// p.removeHero(1);
		// System.out.println(p);
		
		// p.gainExperience(25);
		// System.out.println(p);

		Party p = new Party();
		p.addHero(h1);
		p.addHero(h2);
		p.addHero(h3);

		System.out.println(p);
		p.removeHero(h2);

		System.out.println(p);
		p.addHero(h4);

		System.out.println(p);
		p.removeHero(h1);
		System.out.println(p);
		p.addHero(h3);
		System.out.println(p);
		p.addHero(h3);
		System.out.println(p);
		p.addHero(h1);
		System.out.println(p);

		p.removeHero(h2);
		System.out.println(p);
		
		p.gainExperience(25);
		System.out.println(p);
		
	}
}
