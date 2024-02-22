package fruit;

import fruit.Fruit;

public class Apple extends Fruit{

    public String taste, texture;

    public static void main(String[] args) {

        Apple tesApple2 = new Apple();
        Apple testApple1 = new Apple("sweet", "brazen", "red", false);
        Apple testApple3 = new Apple("sweet", "brazen", "green", false);
        System.out.println(testApple1.toString());

        System.out.println(testApple1.equals(testApple3));
        
    }
    
    public Apple(){
        super();
    }

    public Apple(String taste, String texture, String color, Boolean rotten){
        this();
        super.setColor(color);
        super.setRotten(rotten);
        this.taste = taste;
        this.texture = texture;
    }

    public String getTaste(){
        return this.taste;
    }

    public void setTaste(String taste){
        this.taste = taste;
    }

    public String getTexture(){
        return this.texture;
    }

    public void setTexture(String texture){
        this.texture = texture;
    }

    public String toString(){
        String mainString = super.toString();
        mainString += " The apple tastes " + taste + ". And the texture of the apple is " + texture + ".";
        return mainString;
    }

    @Override
    public boolean equals(Object appleObject){
        // if(this.getClass() != appleObject.getClass()){
        //     return false;
        // }

        if(this.texture != ((Apple) appleObject).getTexture()
                || this.taste != ((Apple) appleObject).getTaste()){
            return false;
        }
        return super.equals(appleObject);
    }


}
