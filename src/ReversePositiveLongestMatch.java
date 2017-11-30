import java.util.ArrayList;
import java.util.List;

public class ReversePositiveLongestMatch {
	private List<String> ls=new ArrayList<String>(); 
	
	public ReversePositiveLongestMatch(){
		init();
	}
	
	private void init(){
		ls.add(new String("上网"));
		ls.add(new String("网站"));
		ls.add(new String("联盟"));
		ls.add(new String("网站联盟"));
		ls.add(new String("加入"));
		ls.add(new String("我们"));
	}
	
	public static void main( String[] args )
    {
        ReversePositiveLongestMatch rlm=new ReversePositiveLongestMatch();
        System.out.println(rlm.getSeperateString("上网站联盟加入我们"));
    }
	
	public String getSeperateString(String sentence){
		String remainString=sentence;
		String result="";
		while(remainString.length()>0){
			int end=getFinal(remainString);
			if(end>=0){
				if(end==0)
					return result+remainString;
				result=remainString.substring(end, remainString.length())+"/"+result;
				remainString=remainString.substring(0,end);
			}
			else{
				if(remainString.length()==1){
					result=remainString+"/"+result;
					return result.substring(0,result.length()-1);
				}
				result=remainString.charAt(remainString.length()-1)+"/"+result;
				remainString=remainString.substring(0,remainString.length()-1);
			}
		}
		return result;
	}
	
	public int getFinal(String matchString){
		
		ArrayList<String> als=new ArrayList<String>();
		for(int i=matchString.length()-1;i>=0;i--){
			als.add(0,matchString.substring(i, matchString.length()));
		}
		
		for(int j=0;j<als.size();j++){
			if(ls.contains(als.get(j))){
				return j;
			}
		}
		return -1;
	}
}