package minusxldatamanagment;

public class NumberCell extends Cell{
    private double numberVal;
 
    public double getNumberVal() {
        return numberVal;
    }
 
    public void setNumberVal(double numberVal) {
        this.numberVal = numberVal;
    }
     
    public double ConvertToNumber(String Value){
        numberVal=Double.parseDouble(Value);
        return numberVal;
    }
}