package sport;

public class VolleyballPlayer extends BallSportsPlayer {

    private Integer maxPoints;

    public VolleyballPlayer(Integer maxPoints) {
        super();
        this.maxPoints = maxPoints;
    }

    public VolleyballPlayer(Integer weight, Gender gender, Integer maxPoints){
        super(weight, gender);
        this.maxPoints = maxPoints;
    }

    public String toString(){
        String result = super.toString();
        result += " Max Points: " + this.maxPoints;
        return result;
    }

    public boolean equals(Object volleyBallObject) {
        
        if(this.equals(volleyBallObject)){
            return true;
        }
        if(volleyBallObject == null || volleyBallObject.getClass() != this.getClass()){
            return false;
        }
        if(this.maxPoints == ((VolleyballPlayer) volleyBallObject).maxPoints){
            return super.equals(volleyBallObject);
        }
        return false;

    }

    public Integer getMaxPoints() {
        return this.maxPoints;
    }

    public void setMaxPoints(Integer maxPoints) {
        this.maxPoints = maxPoints;
    }
        
}
