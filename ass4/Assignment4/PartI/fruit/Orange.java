package fruit;

public class Orange extends Citrus{

    public String type;

    public static void main(String[] args) {

        Orange testOrange1 = new Orange("mandarin", "sweet", false);
        System.out.println(testOrange1.toString());
        Orange testOrange2 = new Orange("mandarin", "sweet", false);
        Orange testOrange3 = new Orange();
        System.out.println(testOrange2.equals(testOrange1));
        System.out.println(testOrange2.equals(testOrange3));
        
    }

    public Orange(){
        super();
        super.setColor("orange");
    }

    public Orange(String type, String taste, Boolean rotten){
        this();
        this.type = type;
        super.setColor("orange");
        super.setTaste(taste);
        super.setRotten(rotten);
    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String toString(){
        String mainString = super.toString();
        mainString += " The type of this orange is " + this.type;
        return mainString;
    }

    @Override
    public boolean equals(Object orangeObject){
        if(this.type != ((Orange) orangeObject).getType()) return false;
        return super.equals(orangeObject);
    }
    
}
