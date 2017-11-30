import java.io.*;

public class Segment {

	public static void main(String[] args){
		try {
			
			
			seg();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void seg() throws IOException{
		
		File ci_file = new File("Ci.txt");
		File out_file = new File("out.txt");
		
		FileInputStream fin = new FileInputStream(ci_file);	
		FileOutputStream fout = new FileOutputStream(out_file);
		
	    InputStreamReader reader = new InputStreamReader(fin, "gbk");
	    OutputStreamWriter writer = new OutputStreamWriter(fout, "gbk");
	 
	    writer.append((char)reader.read());	    
	    //writer.append("\r\n");	    
	    //writer.append("English");
	    
	    
	    
	    
	    //StringBuffer sb = new StringBuffer();
	    
	    //while (reader.ready()) {
	     // sb.append((char) reader.read());
	
	    //}
	    //System.out.println(sb.toString());
	 	    
	    writer.close();	    
	    fout.close();	    
	    reader.close();
	    fin.close();
	
		
		
	}
	
}
