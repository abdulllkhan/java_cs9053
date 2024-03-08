package sport;

public class BaseballPlayer extends BallSportsPlayer {

    private Integer rbi;

    public BaseballPlayer(){
        super();
    }

    public BaseballPlayer(Integer rbi){
        super();
        this.rbi = rbi;
    }

    public BaseballPlayer(Integer weight, Gender gender, Integer rbi){
        super(weight, gender);
        this.rbi = rbi;
    }

    public String toString(){

        String result = super.toString();
        result += " RBI: " + this.rbi;
        return result;

    }

    public boolean equals (Object baseballObject) {

        if(this.equals(baseballObject)){
            return true;
        }
        if(baseballObject == null || baseballObject.getClass() != this.getClass()){
            return false;
        }
        if(this.rbi == ((BaseballPlayer) baseballObject).rbi){
            return super.equals(baseballObject);
        }
        return false;
        
    }

    public Integer getRbi() {
        return this.rbi;
    }

    public void setRbi(Integer rbi) {
        this.rbi = rbi;
    }
    
}
