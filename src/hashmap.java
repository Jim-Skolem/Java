/*
 *如何建立HashMap
 *以及HashMap的常用操作（包括使用Iterator和Entry进行遍历） 
 */


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

public class hashmap {
 public static void main(String[] args){
  
  HashMap<String, String> hashMap = new HashMap<String, String>();
  hashMap.put("cn","中国");
  hashMap.put("us","米国");
  hashMap.put("en","英国");
  
  System.out.println(hashMap);
  System.out.println("cn"+hashMap.get("cn"));
  System.out.println(hashMap.containsKey("cn"));
  System.out.println(hashMap.keySet());
  System.out.println(hashMap.isEmpty());
  
  //hashMap.remove("cn");
  //System.out.println(hashMap.containsKey("cn"));
  
  //使用Iterator遍历HashMap
  Iterator it = hashMap.keySet().iterator();
  while(it.hasNext()){
   String key = (String) it.next();
   System.out.println("key:"+key);
   System.out.println("value:"+hashMap.get(key));
  }
  
  //使用Entry遍历HashMap
  Set<Entry<String, String>> sets = hashMap.entrySet();
  for(Entry<String,String> entry : sets){
   System.out.println(entry.getKey()+", ");
   System.out.println(entry.getValue());
  }
 }
}