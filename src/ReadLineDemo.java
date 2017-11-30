/*
 *从文件中读取一行的Demo
 *如何建立输入流BufferedReader 
 */
import java.io.BufferedReader;  
import java.io.FileInputStream;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
  
public class ReadLineDemo {  
    public static void main(String[] args) {  
        try {  
            InputStream is = new FileInputStream("Ci.txt");  
            BufferedReader reader = new BufferedReader(  
                    new InputStreamReader(is));  
            String str = null;  
            while (true) {  
                str = reader.readLine();  
                if(str!=null)  
                    System.out.println(str);  
                else  
                    break;  
            }  
              
            is.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  