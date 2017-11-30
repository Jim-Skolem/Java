import java.util.ArrayList;
import java.util.List;

public class PositiveLongestMatch {
	private List<String> ls=new ArrayList<String>(); 
	
	public PositiveLongestMatch(){
		init();
	}
	
	private void init(){
		ls.add(new String("����"));
		ls.add(new String("��վ"));
		ls.add(new String("����"));
		ls.add(new String("��վ����"));
		ls.add(new String("����"));
		ls.add(new String("����"));
	}
	
	public String getSeperateString(String sentence){
		String remainString=sentence;
		String result="";
		while(remainString.length()>0){
			int end=getFinal(remainString);
			if(end>0){
				if(end==remainString.length())
					return result+remainString;
				result+=remainString.substring(0, end)+"|";
				remainString=remainString.substring(end);
			}
			else{
				if(remainString.length()==1)
					return result+remainString;
				result+=remainString.charAt(0)+"|";
				remainString=remainString.substring(1);
			}
		}
		return result;
	}
	
	public int getFinal(String matchString){
		
		ArrayList<String> als=new ArrayList<String>();
		for(int i=1;i<=matchString.length();i++){
			als.add(matchString.substring(0, i));
		}
		
		for(int j=als.size();j>0;j--){
			if(ls.contains(als.get(j-1))){
				return j;
			}
		}
		return 0;
	}
}