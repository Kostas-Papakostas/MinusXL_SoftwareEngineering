package minusxldatamanagment;

public class BooleanCell extends Cell{
	 
    private boolean boolVal;
 
    public boolean getBoolVal() {
        return boolVal;
    }
 
    public void setBoolVal(boolean boolVal) {
        this.boolVal = boolVal;
    }
     
    public boolean ConvertToNumber(String Value){
        boolVal=Boolean.parseBoolean(Value);
        return boolVal;
    }
     
}