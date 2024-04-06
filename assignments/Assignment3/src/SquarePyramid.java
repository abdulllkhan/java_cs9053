


public class SquarePyramid {

    private static int nextId;
    private int id;
    // @SuppressWarnings("unused")
    private double side, height;
    private double volume = 0, slant = 0, surfaceArea = 0;


    public static void main(String args[]){

        System.out.println("Initial number of pyramids are: " + nextId);

        SquarePyramid sp1 = new SquarePyramid();
        sp1.setSide(5);
        sp1.setHeight(10);
        System.out.println("The calculations of pyramid with pyramid id: " + sp1.getId() + " are ");
        System.out.println("Volume: " + sp1.getVolume());
        System.out.println("Slant: " + sp1.getSlant());
        System.out.println("Surface Area: " + sp1.getSurfaceArea());


        SquarePyramid sp2 = new SquarePyramid(12, 16);
        System.out.println("\nThe calculations of pyramid with pyramid id: " + sp2.getId() + " are ");
        System.out.println("Volume: " + sp2.getVolume());
        System.out.println("Slant: " + sp2.getSlant());
        System.out.println("Surface Area: " + sp2.getSurfaceArea());

        SquarePyramid sp3, sp4, sp5;
        SquarePyramid[] sppp = new SquarePyramid[10];
        System.out.println("\nTotal number of square pyramids created are: " + nextId);


    }

    public SquarePyramid(){
        SquarePyramid.nextId++;
        this.id = SquarePyramid.nextId;
    }

    public SquarePyramid(double side, double height){
        this();
        this.side = side;
        this.height = height;
    }

    public void setSide(double side){
        this.side = side;
    }

    public double getSide(){
        return this.side;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight(){
        return this.height;
    }

    public int getId(){
        return this.id;
    }

    public double getVolume(){

        if(this.volume != 0){
            return this.volume;
        }

        double volume;
        volume = this.side * this.side * this.height / 3;

        this.volume = volume;
        return volume;
    }

    public double getSlant(){

        if(this.slant != 0) return this.slant;
        
        double slant = Math.sqrt((Math.pow(this.height, 2) + Math.pow(this.side / 2, 2)));

        this.slant = slant;
        return slant;
    }

    public double getSurfaceArea(){

        if(this.surfaceArea != 0) return this.surfaceArea;

        double surfaceArea = this.side * this.side + 2 * this.side * Math.sqrt((Math.pow(this.side, 2) / 2) + Math.pow(this.height, 2));

        this.surfaceArea = surfaceArea;
        return surfaceArea;

    }




}
