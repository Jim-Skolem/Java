/*
 * ��Ȼ������� ʵ��һ 
 * �δʴ�Ƶͳ��
 * ���Ͽ⣺ci.txt        
 * Ҫ��    ���������ci���Զ�����ͳ��ci.txt��ͳ���δʵĵ��ִʣ�˫�ִʵȡ�
 *       ͳ�ƺ�������ǵ��ִʺ�˫�ִʵĴʵ��ļ����ļ��а�����Ӧ�Ĵʺ�Ƶ�ȡ�
 * 
 */

package nlp;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Ex1 {
	public static void main(String[] args){
		try{
			
			Scanner s = new Scanner(System.in);
			System.out.println("����������Ci������δʴ�Ƶͳ�ƣ������룺");
			String filename = s.next();			
			if(filename.equals("Ci")) seg();
			else System.out.println("����");
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//���зִʺʹ�Ƶͳ��
	static void seg() throws IOException{	
		//������Ӧ�����������
		InputStream is = new FileInputStream("Ci.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));//���ļ�
		OutputStreamWriter writer1 = new OutputStreamWriter(new FileOutputStream(new File("���ִʴʵ�.txt")),"gbk");
		OutputStreamWriter writer2 = new OutputStreamWriter(new FileOutputStream(new File("˫�ִʴʵ�.txt")),"gbk");
		//��������ı���
		String str = null;
		String key = null;			
		Map<String , Integer> hashmap = new HashMap<String , Integer>();//����һ��ɢ�б�
		Map<String , Integer> hashmap1 = new HashMap<String , Integer>();
		
		//���ı����д��������������ɢ�б�
		while(true){
			str = reader.readLine();
			if(str!=null){					
				//����ո�ͱ�����
				str = str.replaceAll("\\pP", "");
				str = str.replaceAll("\\s*", "");//������ʽȥ���հ��ַ�
				//str = str.replaceAll("��*��*", "");//������ʽȥ�����
				
				char[] temp = str.toCharArray();//���ַ���ת��Ϊ�ַ�����
				
				for(int i=0;i<str.length();i++){
					if(isChinese(temp[i])){
						key = Character.toString(temp[i]);//�ж�ɢ�б����Ƿ���ڸ��ַ�
						if(hashmap.containsKey(key)) hashmap.put(key, hashmap.get(key)+1);//���ɢ�б����Ѵ��ڸ�Ԫ�أ����1
						else hashmap.put(key, 1);//�����������ɢ�б�valueֵΪ1
					}
					
				}
				
				for(int i=0;i<str.length()-1;i++){
					if(isChinese(temp[i])&&isChinese(temp[i+1])){
						key = Character.toString(temp[i])+Character.toString(temp[i+1]);
						if(hashmap1.containsKey(key)) hashmap1.put(key, hashmap1.get(key)+1);
						else hashmap1.put(key, 1);
					}
					
				}
				
			}else break;  

		}
		//�ı��������
		
		//��ɢ�б��еĽ����ӡ���ļ��У����մ�Ƶ�Ӵ�С���			
		printtotxt(hashmap,writer1); 
		printtotxt(hashmap1,writer2);
		//��ӡ����
		//�ر����������
		reader.close();
		writer1.close();
		writer2.close();
	}
	//��ɢ�б��еĽ����ӡ���ļ��У����մ�Ƶ�Ӵ�С���
	//����map����Ӧ��writer����map�еĽ������valueֵ�������д�ӡ���ļ���
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
	
	
}
