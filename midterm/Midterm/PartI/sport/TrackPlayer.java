package sport;

public class TrackPlayer extends RunningSportsPlayer {

    // distance in meters
    private Integer distance;

    public TrackPlayer(){
        super();
    }

    public TrackPlayer(Integer distance){
        super();
        this.distance = distance;
    }

    public TrackPlayer(Integer weight, Gender gender, Integer distance){
        super(weight, gender);
        this.distance = distance;
    }

    public String toString(){
        String result = super.toString();
        result += " Distance: " + this.distance + "meters";
        return result;
    }

    public boolean equals(Object trackPlayerObject){

        if(this.equals(trackPlayerObject)){
            return true;
        }
        if(trackPlayerObject == null || trackPlayerObject.getClass() != this.getClass()){
            return false;
        }
        if(this.distance == ((TrackPlayer) trackPlayerObject).distance){
            return super.equals(trackPlayerObject);
        }
        return false;
        
    }

    public Integer getDistance() {
        return this.distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
    
}
