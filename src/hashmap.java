/*
 *��ν���HashMap
 *�Լ�HashMap�ĳ��ò���������ʹ��Iterator��Entry���б����� 
 */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class hashmap {
 public static void main(String[] args){
  
  HashMap<String, String> hashMap = new HashMap<String, String>();
  hashMap.put("cn","�й�");
  hashMap.put("us","�׹�");
  hashMap.put("en","Ӣ��");
  
  System.out.println(hashMap);
  System.out.println("cn"+hashMap.get("cn"));
  System.out.println(hashMap.containsKey("cn"));
  System.out.println(hashMap.keySet());
  System.out.println(hashMap.isEmpty());
  
  //hashMap.remove("cn");
  //System.out.println(hashMap.containsKey("cn"));
  
  //ʹ��Iterator����HashMap
  Iterator it = hashMap.keySet().iterator();
  while(it.hasNext()){
   String key = (String) it.next();
   System.out.println("key:"+key);
   System.out.println("value:"+hashMap.get(key));
  }
  
  //ʹ��Entry����HashMap
  Set<Entry<String, String>> sets = hashMap.entrySet();
  for(Entry<String,String> entry : sets){
   System.out.println(entry.getKey()+", ");
   System.out.println(entry.getValue());
  }
 }
}