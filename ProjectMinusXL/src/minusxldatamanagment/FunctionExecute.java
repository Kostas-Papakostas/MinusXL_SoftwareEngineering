package minusxldatamanagment;

public class FunctionExecute{
	Workbook workbook=Workbook.getInstance();
	private MathFunction mathFunc=new MathFunction();
	private LogicalFunction logicFunc=new LogicalFunction();
	private StringFunction strFunc=new StringFunction();
	private int outX,outY;
	private int table;
	
	
	//-------------
	private String functionsUsed[][] = new String[10][100];
	private int  functionIterator = 0;
	//-------------
	
	
	public int getTable(){
		return table;
	}
		
	public String execution(String from,String to,String output,String function,int table){
		String result=null;
		Spreadsheet spr=workbook.getRequestedSpreadsheet(table);
		/*remove the parenthesis*/
		String fromV=from.replaceAll("\\(","");
		fromV=fromV.replaceAll("\\)","");

		String outputV=output.replaceAll("\\(","");
		outputV=outputV.replaceAll("\\)","");
		
		String toV=to.replaceAll("\\(","");
		toV=toV.replaceAll("\\)","");
		
		/*removes the coma and keeps the x and y*/
		String coordinates[] = fromV.split(",", 2);
		int inx=Integer.parseInt(coordinates[0])-1;
		int iny=Integer.parseInt(coordinates[1])-1;
		
		String coordinates2[] = outputV.split(",",2);
		int outx=Integer.parseInt(coordinates2[0])-1;
		int outy=Integer.parseInt(coordinates2[1])-1;
		
		String coordinates3[] = toV.split(",",2);
		int tox=Integer.parseInt(coordinates3[0])-1;
		int toy=Integer.parseInt(coordinates3[1])-1;
		
		
		
		
		
		if(mathFunc.checkValidity(function)>0){
			/*chech which function to execute*/
			if(mathFunc.checkValidity(function)==1){
				double input1=Double.parseDouble((String)spr.getSheettable().getValueAt(inx, iny));
				double input2=Double.parseDouble((String)spr.getSheettable().getValueAt(tox, toy));
				result=mathFunc.CalculateValue(input1, input2, function);
				spr.getSheettable().setValueAt(result, outx, outy);
				
				functionsUsed[functionIterator][0] = function;
				functionsUsed[functionIterator][1] = String.valueOf(outX);   //outputCells
				functionsUsed[functionIterator][2] = String.valueOf(outy);	//outputCells
				functionsUsed[functionIterator][3] = String.valueOf(inx);
				functionsUsed[functionIterator][4] = String.valueOf(iny);
				functionsUsed[functionIterator][5] = String.valueOf(tox);  
				functionsUsed[functionIterator][6] = String.valueOf(toy);
				functionIterator++;
				System.out.println(functionsUsed[0][0]+" "+functionsUsed[0][1]+" "+functionsUsed[0][2]+" "+functionsUsed[0][3]+" "+functionsUsed[0][4]+" "+functionsUsed[0][5]+" "+functionsUsed[0][6]);
				
				return result;
			}else if(mathFunc.checkValidity(function)==2){
				double[] valves=new double[100];
				int k=0;
				for(int i=inx;i<tox+1;i++){
					for(int j=iny;j<toy+1;j++){
						valves[k]=Double.parseDouble((String)spr.getSheettable().getValueAt(i, j));
						k++;
					}
				}
				result=mathFunc.CalculateValue(valves, function,k);
				spr.getSheettable().setValueAt(result, outx, outy);
			}else if(mathFunc.checkValidity(function)==3){
				double input1=Double.parseDouble((String)spr.getSheettable().getValueAt(inx, iny));
				result=mathFunc.CalculateValue(input1, function);
				spr.getSheettable().setValueAt(result, outx, outy);
				return result;
			}else if(logicFunc.checkValidity(function)==4){
				double input1=Double.parseDouble((String)spr.getSheettable().getValueAt(inx, iny));
				result=logicFunc.CalculateValue(input1, function);
				spr.getSheettable().setValueAt(result, outx, outy);
				return result;
			}else if(logicFunc.checkValidity(function)==5){
				double input1=Double.parseDouble((String)spr.getSheettable().getValueAt(inx, iny));
				double input2=Double.parseDouble((String)spr.getSheettable().getValueAt(tox, toy));
				result=logicFunc.CalculateValue(input1,input2, function);
				spr.getSheettable().setValueAt(result, outx, outy);
				return result;
			}else if(strFunc.checkValidity(function)==6){
				String input1=(String)spr.getSheettable().getValueAt(inx, iny);
				String input2=(String)spr.getSheettable().getValueAt(tox, toy);
				result=strFunc.CalculateValue(input1,input2, function);
				spr.getSheettable().setValueAt(result, outx, outy);
			}else if(strFunc.checkValidity(function)==7){
				String input1=(String)spr.getSheettable().getValueAt(inx, iny);
				result=strFunc.CalculateValue(input1, function);
				spr.getSheettable().setValueAt(result, outx, outy);
			}
		}
		
		return result;
	}


	public int getOutX() {
		return outX;
	}


	public void setOutX(int outX) {
		this.outX = outX;
	}


	public int getOutY() {
		return outY;
	}


	public void setOutY(int outY) {
		this.outY = outY;
	}
}
