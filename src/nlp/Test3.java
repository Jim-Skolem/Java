/*
 *��Ȼ������� ʵ����
 *���Ĵ�Ƶͳ��
 *���Ͽ⣺1998-01-2003��-����.txt
 *Ҫ������txt�ļ���ͳ��1Ԫģ�ͺ�2Ԫģ�ͣ�������ʺʹ�Ƶ�ļ���˫�ʺ�
 *	      ��Ƶ�ļ��������Ӧ�Ľӿڣ��ܹ����������ļ������������ʺ�˫�ʡ� 
 */
package nlp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Test3 {
	public static void main(String[] args){
		try {
			seg();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	static void seg() throws IOException{
		//������Ӧ�����������
		InputStream is = new FileInputStream("1998-01-2003��-����.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));//���ļ�
		OutputStreamWriter writer0 = new OutputStreamWriter(new FileOutputStream(new File("���ʴ�Ƶ ����.txt")),"gbk");
		
		//��������ı���
		String str = null;
		String key = "";
		Map<String , Integer> hashmap0 = new HashMap<String , Integer>();
		
		
		while(true){
			str=reader.readLine();
			
			if(str!=null){	
				/*
				
				*/
				//str = str.replaceAll("\\s*", "");
				char[] ch = str.toCharArray();//���ַ���ת��Ϊ�ַ�����
				for(int i=0;i<ch.length;i++){//�����ַ�����
					if(isChinese(ch[i])){//������һ������ʱ
						int len=nextblank(ch,i);
						key=getstring(ch,i,len);																		
						if(hashmap0.containsKey(key)) hashmap0.put(key, hashmap0.get(key)+1);//���ɢ�б����Ѵ��ڸ�Ԫ�أ����1
						else hashmap0.put(key, 1);//�����������ɢ�б�valueֵΪ1
						i=i+len;
					}											
				}
				
				
			}else break;
			
		}
		
		printtotxt(hashmap0,writer0);
		
		
		reader.close();
		writer0.close();
		
	}
	
	static void printtotxt(Map<String,Integer> map,OutputStreamWriter writer) throws IOException{
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //��������
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
            
        });
        
        for(Map.Entry<String,Integer> mapping:list){ 
            //System.out.println(mapping.getKey()+":"+mapping.getValue());
        	writer.append(mapping.getKey()+" "+mapping.getValue()+"\r\n");
        	
          } 
	}
	
	public static boolean isChinese(char a) { 
	     int v = (int)a; 
	     return (v >=19968 && v <= 171941); 
	}
	
	public static int nextblank(char[] ch,int n){
		int i=n;
		for(i=n;i<ch.length;i++){
			if(ch[i]==' ') break;
			//if(ch[i]=='\n') 
		}		
		return i-n;
	}
	
	public static int nexthan(char[] ch,int n){
		int i=n;
		for(i=n;i<ch.length;i++){
			if(isChinese(ch[i])) break;
			//if(ch[i]=='\n') 
		}		
		return i-n;
	}
	
	public static int next2blank(char[] ch,int n){
		int l1=nextblank(ch,n);
		int l2=nexthan(ch,n+l1);
		return l2+nextblank(ch,n+l2);
	}
	
	public static boolean haveblank(char[] ch,int n){
		for(int i=n;i<ch.length;i++){
			if(ch[i]==' ') return true;
		}
		return false;
	}
	
	public static String getstring(char[] ch,int n,int len){
		String s="";
		for(int i=n;i<n+len;i++) s=s+ch[i];
		return s;
	}
	
	public static String getstring(char[] ch,int n){
		String s="";
		int i=n;
		while(ch[i]!='/'){
			s=s+ch[i];
			i++;
		}
		return s;
	}

}

/*
for(int i=0;i<ch.length;i++){//�����ַ�����
	if(isChinese(ch[i])){//������һ������ʱ
		int len=nextblank(ch,i);
		key=getstring(ch,i,len);																		
		if(hashmap0.containsKey(key)) hashmap0.put(key, hashmap0.get(key)+1);//���ɢ�б����Ѵ��ڸ�Ԫ�أ����1
		else hashmap0.put(key, 1);//�����������ɢ�б�valueֵΪ1							
	}											
}
*/

/*
char[] ch = str.toCharArray();//���ַ���ת��Ϊ�ַ�����
int p=0;
int q=0;												
//���ʴ�Ƶ
for(int i=0;i<ch.length;i++){//�����ַ�����											
	//key=getstring(ch,i);
	//i=i+locate(ch,i);
	if(isChinese(ch[i])){
		key=key+ch[i];						
	}
	if(ch[i]=='/'){
		if(hashmap1.containsKey(key)) hashmap1.put(key, hashmap1.get(key)+1);//���ɢ�б����Ѵ��ڸ�Ԫ�أ����1
		else hashmap1.put(key, 1);//�����������ɢ�б�valueֵΪ1
		key = "";
	}																												
}
//˫�ʴ�Ƶ
for(int i=0;i<ch.length;i++){//�����ַ�����					
	if(isChinese(ch[i])){
		key=key+ch[i];						
	}
	if(ch[i]=='/'){
		if(hashmap2.containsKey(key)) hashmap2.put(key, hashmap2.get(key)+1);//���ɢ�б����Ѵ��ڸ�Ԫ�أ����1
		else hashmap2.put(key, 1);//�����������ɢ�б�valueֵΪ1
		key = "";
	}
																								
}

*/
