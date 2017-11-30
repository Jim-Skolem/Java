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

public class Ex3 {
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
		//OutputStreamWriter writer0 = new OutputStreamWriter(new FileOutputStream(new File("���ʴ�Ƶ ����.txt")),"gbk");
		OutputStreamWriter writer1 = new OutputStreamWriter(new FileOutputStream(new File("���ʴ�Ƶ�ļ�.txt")),"gbk");
		OutputStreamWriter writer2 = new OutputStreamWriter(new FileOutputStream(new File("˫�ʴ�Ƶ�ļ�.txt")),"gbk");
		//��������ı���
		String str = null;
		String key = "";
		//Map<String , Integer> hashmap0 = new HashMap<String , Integer>();
		Map<String , Integer> hashmap1 = new HashMap<String , Integer>();//����һ��ɢ�б�
		Map<String , Integer> hashmap2 = new HashMap<String , Integer>();
		
		while(true){
			str=reader.readLine();
			
			if(str!=null){					
				String[] s=str.split("\\s+");
				
				for(int i=0;i<s.length;i++){
					if(!havenum(s[i])){
						key=s[i];
						if(hashmap1.containsKey(key)) hashmap1.put(key, hashmap1.get(key)+1);//���ɢ�б����Ѵ��ڸ�Ԫ�أ����1
						else hashmap1.put(key, 1);//�����������ɢ�б�valueֵΪ1
					}
					
				}
				
				for(int i=0;i<s.length-1;i++){
					if(!havenum(s[i])){
						key=s[i]+" "+s[i+1];
						if(hashmap2.containsKey(key)) hashmap2.put(key, hashmap2.get(key)+1);//���ɢ�б����Ѵ��ڸ�Ԫ�أ����1
						else hashmap2.put(key, 1);//�����������ɢ�б�valueֵΪ1
					}
					
				}
				
				
					
			}else break;
			
		}
		
		//printtotxt(hashmap0,writer0);
		printtotxt(hashmap1,writer1);
		printtotxt(hashmap2,writer2);
		
		reader.close();
		//writer0.close();
		writer1.close();
		writer2.close();
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
		
	public static boolean havenum(String a){
		char[] ch=a.toCharArray();
		for(int i=0;i<ch.length;i++){
			if(Character.isDigit(ch[i])) return true;
		}
		return false;
	}	

}
