package sport;

public abstract class FieldSportsPlayer extends SportsPlayer{

    public FieldSportsPlayer(){
        super();
    }

    public FieldSportsPlayer(Integer weight, Gender gender){
        super(weight, gender);
    }

    public String toString(){
        return super.toString();
    }

    public boolean equals(Object fieldObject) {

        if(this.equals(fieldObject)){
            return true;
        }
        if(fieldObject == null || fieldObject.getClass() != this.getClass()){
            return false;
        }
        return super.equals(fieldObject);

    }
    
}
