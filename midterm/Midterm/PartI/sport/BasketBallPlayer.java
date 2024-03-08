package sport;

public class BasketBallPlayer extends BallSportsPlayer {

    private Integer height;

    public BasketBallPlayer(){
        super();
    }

    public BasketBallPlayer(Integer height){
        super();
        this.height = height;
    }

    public BasketBallPlayer(Integer weight, Gender gender, Integer height){
        super(weight, gender);
        this.height = height;
    }  

    public String toString(){
        String result = super.toString();
        result += " Height: " + this.height + "centimeters";
        return result;
    }

    public boolean equals(Object basketBallObject) {
        
        if(this.equals(basketBallObject)){
            return true;
        }
        if(basketBallObject == null || basketBallObject.getClass() != this.getClass()){
            return false;
        }
        if(this.height == ((BasketBallPlayer) basketBallObject).height){
            return super.equals(basketBallObject);
        }
        return false;

    }

    public Integer getHeight() {
        return this.height;
    }   

    public void setHeight(Integer height) {
        this.height = height;
    }


}
