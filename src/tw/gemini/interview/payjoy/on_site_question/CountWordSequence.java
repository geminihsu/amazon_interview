package tw.gemini.interview.payjoy.on_site_question;

import java.util.HashMap;

public class CountWordSequence {

	private HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	
	private String countWord(String word)
	{
		char[] tmp = word.toCharArray();
		StringBuilder s = new StringBuilder();
		int count = 0;
		map.put(tmp[0], 1);
		
		for(int i = 1 ;i < tmp.length ; i++)
		{
			if(map.get(tmp[i]) == null)
			{
				map.put(tmp[i], 1);
				if(tmp[i]!=tmp[i-1]){
				    s.append(map.get(tmp[i-1]));
				    s.append(tmp[i-1]);
					
				}
				count = i;
			}else
			{
				count++;
				if(count == i){
					if(tmp[i-1]!=tmp[i]){
						s.append(map.get(tmp[i-1]));
						s.append(tmp[i-1]);
						map.put(tmp[i], 1);
					}
					else
						map.put(tmp[i], map.get(tmp[i])+1);
				}
			}
		}
		
		s.append(map.get(tmp[tmp.length-1]));
	    s.append(tmp[tmp.length-1]);
	    return s.toString();
	}
	
	private String recoveryWord(String word)
	{
		StringBuilder allWord = new StringBuilder();
		char[] data = word.toCharArray();
		for(int i = 0; i < data.length ; i+=2)
		{
			allWord.append(getRepeatWord(""+data[i],data[i+1]));
		}
		
		return allWord.toString();
	}
	
	private String getRepeatWord(String count, char c)
	{
		StringBuilder result = new StringBuilder();
		for(int i = 0 ; i < Integer.valueOf(count); i++)
		{
			result.append(c);
		}
		
		return result.toString();
	}
	
	 public static void main(String[] args)
	{
		 CountWordSequence word = new CountWordSequence();
		 String result = word.countWord("aaabbcabbacda");
		 System.out.println(result);
		 
		 String origial = word.recoveryWord("3a2b1c1a2b1a1c1d1a");
		 System.out.println(origial);
	}
}
