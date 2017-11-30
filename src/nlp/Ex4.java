/*
 *��Ȼ������� ʵ����
 *���Ĵʷ�����ϵͳ
 *���Ͽ⣺1998-01-2003��-����.txt
 *Ҫ�󣺸��ݹ����ĵ��ʴʵ��˫�ʴʵ䣬��n-gramģ�ͣ�����ǰ���ƥ�䣬
 *	      ���ߺ����ƥ����㷨�������ø�����һЩ�ķ��������У����������
 *	      �Ʒ�ģ�ͺ����������ģ�͡� 
 */
package nlp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Ex4 {
	
	public static Map<String , Integer> hashmap = new HashMap<String , Integer>();
	
	
	public static void main(String[] args){
		try {
			
			createmap();
			System.out.println("�����룺");
			Scanner sc = new Scanner(System.in);			
			String s=sc.next();
			
			maxmatch(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
				
	public static void maxmatch(String s) throws IOException{		
		String in=s;		
		int len=4;
		int i=0;
		int n=len;
		char[] temp = in.toCharArray();
		for(i=0;i<temp.length;i++){
			for(n=len;n>0;n--){
				if(i+n>temp.length) n=temp.length-i;
				//if(n==1) print(temp,i,n);
				if(match(n,temp,i)){
					print(temp,i,n);
					i=i+n-1;
					break;
				}
			}
		}
		
		
		
	}
	
	public static void print(char[] temp,int i,int n){
		String s="";
		for(int j=i;j<i+n;j++) s=s+temp[j];
		System.out.print(s+' ');
	}
	
	public static boolean match(int n,char[] temp,int p){
		if(n==4) return tag4(temp,p);
		if(n==3) return tag3(temp,p);
		if(n==2) return tag2(temp,p);
		if(n==1) return tag1(temp,p);
		return false;
	}
	
	public static boolean tag4(char[] temp,int p){
		String key=""+temp[p]+temp[p+1]+temp[p+2]+temp[p+3];
		if(match(key)) return true;
		return false;
	}
	public static boolean tag3(char[] temp,int p){
		String key=""+temp[p]+temp[p+1]+temp[p+2];
		if(match(key)) return true;
		return false;
	}
	public static boolean tag2(char[] temp,int p){
		String key=""+temp[p]+temp[p+1];
		if(match(key)) return true;
		return false;
	}
	public static boolean tag1(char[] temp,int p){
		String key=""+temp[p];
		if(match(key)) return true;
		return false;
	}
	
	public static void createmap() throws IOException{
		InputStream is = new FileInputStream("���ʴ�Ƶ�ļ�.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String str = null;
		
		while(true){
			str = reader.readLine();
			if(str!=null){		
				String[] s=str.split("/");
				hashmap.put(s[0], 1);				
			}else break;
		}
		reader.close();
		//print();
	}
		
	public static boolean match(String s){
		if(hashmap.containsKey(s)) return true;
		return false;
	}
		
}
