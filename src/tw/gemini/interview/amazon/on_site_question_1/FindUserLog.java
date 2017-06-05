package tw.gemini.interview.amazon.on_site_question_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FindUserLog {
	
	private ArrayList<Log> getUserLog(String path)
	{
		ArrayList<Log> result = new ArrayList<Log>();
		
		try {
			Scanner in = new Scanner(new FileReader(path));
			while(in.hasNext()) {
				String tmp = in.next();
			    if(!tmp.isEmpty()){
			    		String[] record = tmp.split(",");
			    		Log log = new Log();
			    		log.userId = Integer.valueOf(record[0]);
			    		log.userName = record[1];
			    		log.date = record[2];
			    		result.add(log);
			    }
			}
			in.close();
	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	private ArrayList<String> queryByDate(ArrayList<Log> logs,String date)
	{
		ArrayList<String> users = new ArrayList<String>();
		
		for(Log log:logs)
		{
			if(log.date.equals(date))
				users.add(log.userName);
		}
		
		return users;
	}
	
	private ArrayList<String> queryByDate(ArrayList<Log> logs,String date,ArrayList<String> day1_users)
	{
		ArrayList<String> users = new ArrayList<String>();
		
		for(Log log:logs)
		{
			if(log.date.equals(date)&&day1_users.contains(log.userName))
				users.add(log.userName);
		}
		
		return users;
	}
	
	private void printUser(ArrayList<String> users)
	{
		StringBuilder sb = new StringBuilder();
		for(String name:users)
		{
			sb.append(name);
			sb.append(",");
		}
		System.out.println(sb.substring(0,sb.length()-1).toString());
	}
	
	 public static void main(String[] args)
	{
		 FindUserLog file = new FindUserLog();
		 ArrayList<Log> logs = file.getUserLog("/Users/geminihsu/Documents/LeeCode/LingRongSyu/src/tw/gemini/interview/amazon/on_site_question_1/log.txt");
		 System.out.println("Day1 : 2017/03/04");
		 ArrayList<String> day1= file.queryByDate(logs, "2017/03/04"); //Answer 1
		 file.printUser(day1);
		 
		 System.out.println("Day2 : 2017/03/05");
		 ArrayList<String> day2= file.queryByDate(logs, "2017/03/05",day1); //Answer 2
		 file.printUser(day2);
	}
}
