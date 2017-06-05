package tw.gemini.interview.amazon_on_site_question_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleQuery {
	private HashMap<String,Integer> count = new HashMap<String,Integer>();
	
	private void countByCity(ArrayList<Sale> data)
	{
		for(int i = 0 ; i < data.size() ; i++)
		{
			Sale sale = data.get(i);
			if(count.get(sale.city) == null)
			{
				count.put(sale.city, 1);
			}else
			{
				count.put(sale.city, count.get(sale.city)+1);
			}
		}
	}
	
	private void sortCity(int top,List<Map.Entry<String, Integer>> map)
	{
		
        int num = 0;
        for (Map.Entry<String, Integer> entry:map) {
        		if(num < top)
        			System.out.println(entry.getKey() + "\t" + count.get(entry.getKey()));
        		num++;
        }
       
	}
	
	private List<Map.Entry<String, Integer>> searchCity(String city)
	{
		List<Map.Entry<String, Integer>> list_Data =
                new ArrayList<Map.Entry<String, Integer>>(count.entrySet());
        Collections.sort(list_Data, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> entry1,
                               Map.Entry<String, Integer> entry2){
                return (entry2.getValue() - entry1.getValue());
            }
        });
        
        for (Map.Entry<String, Integer> entry:list_Data) {
        		if(entry.getKey().equals(city))
        			System.out.println("The sale total in "+entry.getKey() + " city :\t" + count.get(entry.getKey()));
        		
        }
        return list_Data;
	}
	public static void main(String[] args)
	{
		Sale sale_1 = new Sale();
		sale_1.id =1 ;
		sale_1.city = "Sunnyvale";
		sale_1.date = "2017/05/11";
		Sale sale_2 = new Sale();
		sale_2.id =2 ;
		sale_2.city = "Sunnyvale";
		sale_2.date = "2017/06/11";
		
		Sale sale_3 = new Sale();
		sale_3.id =3 ;
		sale_3.city = "Menlo Park";
		sale_3.date = "2017/05/11";
		
		Sale sale_4 = new Sale();
		sale_4.id =4 ;
		sale_4.city = "Palo Alto";
		sale_4.date = "2017/06/11";
		
		Sale sale_5 = new Sale();
		sale_5.id =5 ;
		sale_5.city = "Palo Alto";
		sale_5.date = "2017/02/11";
		
		Sale sale_6 = new Sale();
		sale_6.id =6 ;
		sale_6.city = "Palo Alto";
		sale_6.date = "2017/03/11";
		
		Sale sale_7 = new Sale();
		sale_7.id =7 ;
		sale_7.city = "Sunnyvale";
		sale_7.date = "2017/03/11";
		
		Sale sale_8 = new Sale();
		sale_8.id =8 ;
		sale_8.city = "Redwood City";
		sale_8.date = "2017/03/11";
		
		Sale sale_9 = new Sale();
		sale_9.id =9 ;
		sale_9.city = "Santa Cara";
		sale_9.date = "2017/03/11";
		
		Sale sale_10 = new Sale();
		sale_10.id =10 ;
		sale_10.city = "Redwood City";
		sale_10.date = "2017/03/11";
		
		Sale sale_11 = new Sale();
		sale_11.id =11 ;
		sale_11.city = "Palo Alto";
		sale_11.date = "2017/03/11";
		
		ArrayList<Sale> list = new ArrayList<Sale>();
		list.add(sale_1);
		list.add(sale_2);
		list.add(sale_3);
		list.add(sale_4);
		list.add(sale_5);
		list.add(sale_6);
		list.add(sale_7);
		list.add(sale_8);
		list.add(sale_9);
		list.add(sale_10);
		list.add(sale_11);
		
		
		SaleQuery sales = new SaleQuery();
		//System.out.println("----------The sale total city--------");
		sales.countByCity(list);
		List<Map.Entry<String, Integer>> list_Data = sales.searchCity("Sunnyvale");
		System.out.println("----------The sale total city list the top three city--------");
		sales.sortCity(3,list_Data);
		
	}
}
