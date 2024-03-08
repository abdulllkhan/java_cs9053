package sport;

public class ShotPutPlayer extends FieldSportsPlayer {

    private Integer maxDistance;  // maxDistance in centimeters

    public ShotPutPlayer(){
        super();
    }

    public ShotPutPlayer(Integer maxDistance){
        super();
        this.maxDistance = maxDistance;
    }

    public ShotPutPlayer(Integer weight, Gender gender, Integer maxDistance){
        super(weight, gender);
        this.maxDistance = maxDistance;
    }

    public String toString(){
        String result = super.toString();
        result += " Max Distance: " + this.maxDistance + "centimeters";
        return result;
    }

    public boolean equals(Object shotPutObject) {
        
        if(this.equals(shotPutObject)){
            return true;
        }
        if(shotPutObject == null || shotPutObject.getClass() != this.getClass()){
            return false;
        }
        if(this.maxDistance == ((ShotPutPlayer) shotPutObject).maxDistance){
            return super.equals(shotPutObject);
        }
        return false;

    }

    public Integer getMaxDistance() {
        return this.maxDistance;
    }

    public void setMaxDistance(Integer maxDistance) {
        this.maxDistance = maxDistance;
    }
    
}
