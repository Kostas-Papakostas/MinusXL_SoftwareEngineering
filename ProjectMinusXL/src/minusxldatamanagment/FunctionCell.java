package minusxldatamanagment;

public class FunctionCell extends Cell{
    private String Function;
    private int coordX,coordY;
    public Cell CellFunction;
     
    public String getFunction() {
        return Function;
    }
    public void setFunction(String Function) {
        this.Function = Function;
    }
 
    public int getCoordX() {
        return coordX;
    }
    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }
    public int getCoordY() {
        return coordY;
    }
    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }
     
    public void identifyFunction(Cell cell){
        coordX=cell.getCoordinateX();
        coordY=cell.getCoordinateY();
    }
 
}