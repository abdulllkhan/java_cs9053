package sport;

public abstract class BallSportsPlayer extends SportsPlayer {

    public BallSportsPlayer(){
        super();
    }

    public BallSportsPlayer(Integer weight, Gender gender){
        super(weight, gender);
    }

    public String toString(){
        return super.toString();
    }

    public boolean equals(Object ballObject) {
        if(this.equals(ballObject)){
            return true;
        }
        if(ballObject == null || ballObject.getClass() != this.getClass()){
            return false;
        }
        return super.equals(ballObject);
    }
    
}
