package sport;

public abstract class RunningSportsPlayer extends SportsPlayer{

    public RunningSportsPlayer(){
        super();
    }

    public RunningSportsPlayer(Integer weight, Gender gender){
        super(weight, gender);
    }

    public String toString(){
        return super.toString();
    }

    public boolean equals(Object runningObject) {

        if(this.equals(runningObject)){
            return true;
        }
        if(runningObject == null || runningObject.getClass() != this.getClass()){
            return false;
        }
        return super.equals(runningObject);
        
    }
    
}
