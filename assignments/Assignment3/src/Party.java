


public class Party {

    private Hero[] heroes;
    

    public static void main(String args[]){

        Party psrty = new Party();
        Hero hero1 = new Hero("Abdul");
        Hero hero2 = new Hero("Edward");
        Hero hero3 = new Hero("Eren");
        Hero hero4 = new Hero("Armin");

        hero1.setRole("Coder");
        hero2.setRole("Wizard");
        hero3.setRole("Wizard");


        psrty.addHero(hero1, 0);
        psrty.addHero(hero2, 1);
        psrty.addHero(hero3, 2);

        
        psrty.gainExperience(100);

        System.out.println(psrty.toString());


    }


    public Party() {
        this.heroes = new Hero[3];
    }

    public void addHero(Hero hero, int index) {
        if (index >= 0 && index < heroes.length) {
            if (heroes[index] == null) {
                heroes[index] = hero;
                System.out.println(hero.getName() + " is added to the party.");
            } 
            else System.out.println(hero.getName() + " is already in the party.");
        }
    }

    public void removeHero(int index) {
        if (index >= 0 && index < heroes.length) {
            heroes[index] = null;
        }
    }

    public Hero getHero(int index) {
        if (index >= 0 && index < heroes.length) {
            return heroes[index];
        }
        return null;
    }

    public void gainExperience(int experience) {

        System.out.println("The party gained " + experience + " experience.");

        // int numHeroes = this.heroes.length;
        int numHeroes = 0;
        for (Hero hero : heroes) {
            if (hero != null) {
                numHeroes++;
            }
        }

        int experiencePerHero = experience / numHeroes;
        for (Hero hero : heroes) {
            if (hero != null) {
                hero.gainExperience(experiencePerHero);
            }
        }
    }


    public String toString() {

        StringBuilder result = new StringBuilder("Party:\n");
        boolean hasAssignedHeroes = false;
        for (Hero hero : heroes) {
            if (hero != null && !hero.getRole().equals("Unassigned")) {
                result.append(hero.toString()).append("\n");
                hasAssignedHeroes = true;
            }
        }
        if (!hasAssignedHeroes) {
            result.append("No assigned heroes in the party.\n");
        }
        return result.toString();

    }


}
