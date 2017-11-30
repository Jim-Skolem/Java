import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;  
  
public class Test {  
  
    public static void main(String[] args) {  
    	List<Term> termList = StandardTokenizer.segment("商品和服务");
    	System.out.println(termList);
    }  
  
}  
