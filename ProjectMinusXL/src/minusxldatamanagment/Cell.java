package minusxldatamanagment;

public class Cell {
    
    private String Value; 
    private int CoordinateX;
    private int CoordinateY;
     
    public int getCoordinateX(){
        return CoordinateX;
    }
     
    public void setCoordinateX(int CoordinateX){
        this.CoordinateX=CoordinateX;
    }
     
    public int getCoordinateY(){
        return CoordinateY;
    }
     
    public void setCoordinateY(int CoordinateY){
        this.CoordinateY=CoordinateY;
    }
     
    public String getValue(){
        return Value;
    }
}