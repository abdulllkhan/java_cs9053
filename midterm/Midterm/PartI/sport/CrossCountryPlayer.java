package sport;

public class CrossCountryPlayer extends RunningSportsPlayer {

    private double bestMileTime;

    public CrossCountryPlayer(){
        super();
    }

    public CrossCountryPlayer(double bestMileTime){
        super();
        this.bestMileTime = bestMileTime;
    }

    public CrossCountryPlayer(Integer weight, Gender gender, double bestMileTime){
        super(weight, gender);
        this.bestMileTime = bestMileTime;
    }

    public String toString(){
        String result = super.toString();
        result += " Best Mile Time: " + this.bestMileTime + " minutes";
        return result;
    }

    public boolean equals(Object crossCountryObject) {
        
        if(this.equals(crossCountryObject)){
            return true;
        }
        if(crossCountryObject == null || crossCountryObject.getClass() != this.getClass()){
            return false;
        }
        if(this.bestMileTime == ((CrossCountryPlayer) crossCountryObject).bestMileTime){
            return super.equals(crossCountryObject);
        }
        return false;

    }

    public static void main(String[] args) {
        CrossCountryPlayer crossCountryPlayer = new CrossCountryPlayer(4.5);
        System.out.println(crossCountryPlayer.getId());
    }

    public double getBestMileTime() {
        return this.bestMileTime;
    }

    public void setBestMileTime(double bestMileTime) {
        this.bestMileTime = bestMileTime;
    }  
    
}
