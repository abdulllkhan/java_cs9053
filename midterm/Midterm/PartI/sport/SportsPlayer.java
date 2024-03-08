package sport;

public abstract class SportsPlayer implements Comparable<SportsPlayer>{

    private static Integer nextId = 0;
    private Integer id;
    private Integer weight;
    private Gender gender;

    public SportsPlayer(){
        SportsPlayer.nextId++;
        this.id = SportsPlayer.nextId;
    }

    public SportsPlayer(Integer weight, Gender gender){
        this();
        this.weight = weight;
        this.gender = gender;
    }

    @Override
    public String toString(){
        
        String result = "";
        String gender;
        if(this.gender.equals(Gender.MALE)){
            gender = "male";
        } else {
            gender = "female";
        }
        result = "ID: " + this.id + " Weight: " + this.weight + " Gender: " + gender + " ";
        return result;

    }

    public boolean equals(Object sportsObject) {
        if(this.equals(sportsObject)){
            return true;
        }
        if(sportsObject == null || sportsObject.getClass() != this.getClass()){
            return false;
        }
        if(this.weight == ((SportsPlayer) sportsObject).id
                && this.gender == ((SportsPlayer) sportsObject).gender){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(SportsPlayer other) {
        return Integer.compare(this.weight, other.weight);
    }

    public static void main(String[] args) {
        
        // SportsPlayer sportsPlayer = new SportsPlayer(); // cannot create instances of abstract class

    }

    public Integer getId() {
        return this.id;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setAge(Integer weight) {
        this.weight = weight;
    }   

    public Gender getGender(){
        return this.gender;

    }

    public void setGender(Gender gender){
        this.gender = gender;
    }
}
