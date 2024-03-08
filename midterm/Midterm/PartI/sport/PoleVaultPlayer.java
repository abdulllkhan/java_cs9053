package sport;

public class PoleVaultPlayer extends FieldSportsPlayer {

    private Integer maxHeight;  // maxHeight in centimeters

    public PoleVaultPlayer(){
        super();
    }

    public PoleVaultPlayer(Integer maxHeight){
        super();
        this.maxHeight = maxHeight;
    }

    public PoleVaultPlayer(Integer weight, Gender gender, Integer maxHeight){
        super(weight, gender);
        this.maxHeight = maxHeight;
    }

    public String toString(){
        String result = super.toString();
        result += " Max Height: " + this.maxHeight + "centimeters";
        return result;
    }

    public boolean equals(Object poleVaultObject) {
        
        if(this.equals(poleVaultObject)){
            return true;
        }
        if(poleVaultObject == null || poleVaultObject.getClass() != this.getClass()){
            return false;
        }
        if(this.maxHeight == ((PoleVaultPlayer) poleVaultObject).maxHeight){
            return super.equals(poleVaultObject);
        }
        return false;

    }

    public Integer getMaxHeight() {
        return this.maxHeight;
    }

    public void setMaxHeight(Integer maxHeight) {
        this.maxHeight = maxHeight;
    }
    
}
