import java.io.File;  
import java.io.FileReader;  
import java.io.IOException;  
import java.io.LineNumberReader;  
public class ReadSelectedLine{  
    /** 
     * ��ȡ�ļ�ָ���С� 
     */  
    public static void main(String[] args) throws IOException {  
        // ָ����ȡ���к�   
        int lineNumber = 12;  
        // ��ȡ�ļ�   
        File sourceFile = new File("���ִʴʵ�.txt");  
        // ��ȡָ������   
        readAppointedLineNumber(sourceFile, lineNumber);  
        // ��ȡ�ļ������ݵ�������   
        System.out.println(getTotalLines(sourceFile));  
    }  
    // ��ȡ�ļ�ָ���С�   
    static void readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {  
        FileReader in = new FileReader(sourceFile);  
        LineNumberReader reader = new LineNumberReader(in);  
        String s = reader.readLine();  
        if (lineNumber < 0 || lineNumber > getTotalLines(sourceFile)) {  
            System.out.println("�����ļ���������Χ֮�ڡ�");  
        }  
        {  
            while (s != null) {  
            	System.out.println("��ǰ�к�Ϊ:" + reader.getLineNumber());                               
                reader.setLineNumber(20);  
                System.out.println("���ĺ��к�Ϊ:"+ reader.getLineNumber());                                
                System.out.println(s);  
                System.exit(0);       
                s = reader.readLine();  
            }  
        }  
        reader.close();  
        in.close();  
    }  
    // �ļ����ݵ���������   
    static int getTotalLines(File file) throws IOException {  
        FileReader in = new FileReader(file);  
        LineNumberReader reader = new LineNumberReader(in);  
        String s = reader.readLine();  
        int lines = 0;  
        while (s != null) {  
            lines++;  
            s = reader.readLine();  
        }  
        reader.close();  
        in.close();  
        return lines;  
    }  
}  
 