/*
 * 自然语言理解 实验一 
 * 宋词词频统计
 * 语料库：ci.txt        
 * 要求：    编程序，输入ci，自动分析统计ci.txt，统计宋词的单字词，双字词等。
 *       统计后，输出的是单字词和双字词的词典文件。文件中包括相应的词和频度。
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
			System.out.println("程序将在输入Ci后进行宋词词频统计，请输入：");
			String filename = s.next();			
			if(filename.equals("Ci")) seg();
			else System.out.println("错误");
			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//进行分词和词频统计
	static void seg() throws IOException{	
		//建立相应的输入输出流
		InputStream is = new FileInputStream("Ci.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));//读文件
		OutputStreamWriter writer1 = new OutputStreamWriter(new FileOutputStream(new File("单字词词典.txt")),"gbk");
		OutputStreamWriter writer2 = new OutputStreamWriter(new FileOutputStream(new File("双字词词典.txt")),"gbk");
		//声明所需的变量
		String str = null;
		String key = null;			
		Map<String , Integer> hashmap = new HashMap<String , Integer>();//建立一个散列表
		Map<String , Integer> hashmap1 = new HashMap<String , Integer>();
		
		//对文本进行处理，并将结果存入散列表
		while(true){
			str = reader.readLine();
			if(str!=null){					
				//处理空格和标点符号
				str = str.replaceAll("\\pP", "");
				str = str.replaceAll("\\s*", "");//正则表达式去除空白字符
				//str = str.replaceAll("，*。*", "");//正则表达式去除标点
				
				char[] temp = str.toCharArray();//将字符串转化为字符数组
				
				for(int i=0;i<str.length();i++){
					if(isChinese(temp[i])){
						key = Character.toString(temp[i]);//判断散列表中是否存在该字符
						if(hashmap.containsKey(key)) hashmap.put(key, hashmap.get(key)+1);//如果散列表中已存在该元素，则加1
						else hashmap.put(key, 1);//否则则将其存入散列表，value值为1
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
		//文本处理结束
		
		//将散列表中的结果打印到文件中，按照词频从大到小输出			
		printtotxt(hashmap,writer1); 
		printtotxt(hashmap1,writer2);
		//打印结束
		//关闭输入输出流
		reader.close();
		writer1.close();
		writer2.close();
	}
	//将散列表中的结果打印到文件中，按照词频从大到小输出
	//输入map和相应的writer，将map中的结果按照value值降序排列打印到文件中
	static void printtotxt(Map<String,Integer> map,OutputStreamWriter writer) throws IOException{
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //降序排序
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
