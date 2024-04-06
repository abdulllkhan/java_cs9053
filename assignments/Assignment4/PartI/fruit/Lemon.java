package fruit;


public class Lemon extends Citrus{

    public int sourness;

    public static void main(String[] args) {

        Lemon testLemon1 = new Lemon(10, "sweet", false);
        Lemon testLemon2 = new Lemon(10, "sweeter", false);
        System.out.println(testLemon1.toString());
        System.out.println(testLemon1.equals(testLemon2));  // should be false, because sweet != sweeter
        
    }

    public Lemon(){
        super();
        super.setColor("yellow");
    }

    public Lemon(int sourness, String taste, Boolean rotten){
        this();
        super.setColor("yellow");
        this.sourness = sourness;
        super.setRotten(rotten);
        super.setTaste(taste);
    }

    public int getSourness(){
        return this.sourness;
    }

    public void setSourness(int sourness){
        this.sourness = sourness;
    }

    public String toString(){
        String mainString = super.toString();
        mainString += " The sourness rating of the lemon is: " + this.sourness;
        return mainString;
    }

    // public boolean equals(Lemon lemonObject){
    //     if(this.sourness != lemonObject.getSourness()) return false;
    //     return true;
    // }

    @Override
    public boolean equals(Object lemonObject){
        if(this.sourness != ((Lemon) lemonObject).getSourness()) return false;
        return super.equals(lemonObject);
    }
    
}
