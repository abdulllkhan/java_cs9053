
public class Hero {

    private static int MAX_LEVEL = 100;
    private static String[] roles = new String[]{"Warrior", "Priest", "Wizard", "Theif", "Lazy Cat", "Coder", "Programmer"};


    private String name, role;
    private int level, experience;

    public static void main(String args[]){

        Hero hero1 = new Hero("Abdul");
        hero1.setRole("Runner");
        hero1.setRole("Coder");
        hero1.gainExperience(100);
        System.out.println(hero1.getExperience());
        System.out.println(hero1.toString()); 
        

        
    }

    public Hero(){
        this.level = 1;
        this.experience = 0;
        this.role = "Unassigned";
    }

    public Hero(String name){
        this();
        this.name = name;
    }

    public void setRole(String role){
        boolean isPresent = false;
        for(int i = 0; i < roles.length; i++){
            if(roles[i] == role){
                isPresent = true;
                break;
            }
        }
        if(!isPresent){
            System.out.println("Invalid role");
        }
        this.role = role;
    }

    public String getRole(){
        return this.role;
    }

    public String getName(){
        return this.name;
    }

    public int getLevel(){
        return this.level;
    }

    public int getExperience(){
        return this.experience;
    }

    public int expToLevelUp(){
        if(this.experience >= 100) return 100;
        int exp = (int)Math.pow(this.level, 2);
        return exp;
    }

    public void gainExperience(int experience){
        
        experience += this.experience;
        int levelUps = 0;
        // int localExp = experience;
        
        while(experience >= Math.pow(this.level, 2)){
            levelUps++;
            experience -= Math.pow(this.level, 2);
            this.level++;
        }

        if(this.level > MAX_LEVEL) this.level = MAX_LEVEL;

        if(levelUps > 0){
            System.out.println(this.name + " is now level " + this.level);
        }

        this.experience = experience;

    }

    public String toString(){
        return this.name + " the " + this.role + " level " + this.level + " with " + this.experience + " experience.";
    }







}
