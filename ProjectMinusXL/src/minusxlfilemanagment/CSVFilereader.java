package minusxlfilemanagment;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
 
public class CSVFilereader {
    private String Filename;
    private int offset;
    private boolean stop=true;
    //it starts reading from the offset char by char until it finds ';' and returns the column value
    public String readCSV(String filename,int offset){
        String value = "";
        Path file=Paths.get(filename);
        this.offset=offset;
        Charset charset = Charset.forName("US-ASCII");
        try(BufferedReader Reader=Files.newBufferedReader(file,charset)){
            String r;
            for(int i=0;i<offset;i++){
            	if((r=Reader.readLine())!=null){
            		value=r;
            	}else{
            		stop=false;
            	}
            }
            r = Reader.readLine();
            value=r;
        }catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return value;
    }
     
    public String getFilename(){
        return Filename;
    }
     
    public void setFilename(String Filename){
        this.Filename=Filename;
    }

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
}