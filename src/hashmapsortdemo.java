/*��һ��map������valueֵ�Ĵ�С��������������hashmap���䱾���������
 * 
 * */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
public class hashmapsortdemo {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();
        map.put("a", "ddddd");
        map.put("c", "bbbbb");
        map.put("d", "aaaaa");
        map.put("b", "ccccc");
        
        //���ｫmap.entrySet()ת����list
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //Ȼ��ͨ���Ƚ�����ʵ������
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //��������
            public int compare(Entry<String, String> o1,
                    Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
            
        });
        
        for(Map.Entry<String,String> mapping:list){ 
               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
          } 
    }
}