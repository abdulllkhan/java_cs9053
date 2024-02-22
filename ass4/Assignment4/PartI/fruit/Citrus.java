package fruit;

// import fruit.Fruit;

public class Citrus extends Fruit{

    public String taste;

    public static void main(String[] args) {

        Citrus nullCitrus = new Citrus();
        Citrus testCitrus1 = new Citrus("tasty", "red", false);
        Citrus testCitrus2 = new Citrus("tasty", "red", false);
        System.out.println("The id of testCitrus is: " + testCitrus1.getId());
        System.out.println(testCitrus1.toString());
        System.out.println("The id of nullCitruss is: " + nullCitrus.getId());
        System.out.println(testCitrus1.equals(testCitrus2));
        
    }

    public Citrus(){
        super();
    }

    public Citrus(String taste, String color, Boolean rotten){
        this();
        this.taste = taste;
        super.setColor(color);
        super.setRotten(rotten);
    }

    public String getTaste(){
        return this.taste;
    }

    public void setTaste(String taste){
        this.taste = taste;
    }

    public String toString(){
        String mainString = super.toString();
        mainString += " The fruit tastes " + this.taste + ".";
        return mainString;
    }

    @Override
    public boolean equals(Object citrusObject){
        if(this.taste != ((Citrus) citrusObject).getTaste()) return false;
        return super.equals(citrusObject);
    }
    
    
}
