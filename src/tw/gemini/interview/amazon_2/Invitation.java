package tw.gemini.interview.amazon_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author geminihsu
 * The class define the two methods. 
 * The processData function used to read each string than build our single linked list.
 * In line 186, we check the leftover different in order to filter the amount of candy they brought won't be
 * negative value.
 * The printResult function used to print all guest should be invited.
 * 
 */
public class Invitation {

	//define the position index in guest array
	private final int guestIndex = 0;
	private final int inviterIndex = 1;
	private final int candyBroughtIndex = 2;
	private final int candyConsumedIndex = 3;
	
	
	//define the input String array
	private String[] guestList;
	
	/**The hashmap used to mapping guest name as key in order to
	 * get the Each Guest information
	 */
	private HashMap<String,Guest> guestMapList = new HashMap<String,Guest>();
	
	
	/**Constructor
	 * @param data String array
	 */
	public Invitation(String[] data)
	{
		if(data == null)
			return;
		this.guestList = data;
	}
	
	
	/**
	 * According to input string array data, we iterative each string and get guest information
	 * Each element would be store into our Guest Structure.
	 * We check the leftover is positive or negative, the value assigned the boolean result.
	 * Besides, we create leftover variable in Guest class in order to store the leftover.
	 * HaspMap used to mapping each guest as key and Guest object. 
	 * 
	 * case 1: If the guest is invited by Adam, it has been directly put the guest into hashmap.
	 * case 2: If the guest already exit in our hashmap, we get the the data from hashmap and then
	 * calculator the value of candyBrought addition leftover. The purpose it would skip some guest
	 * who bring the candy less than inviter leftover. Also, we check the guest whether has been 
	 * invited by Adam or not.If the guest has been invited by Adam, we updated Adam object, whose
	 * leftover and isInvited variable.
	 */
	private void processData()
	{
		for(String people :guestList)
		{
			
			String[] guestInfo = people.split(",");
			if(guestInfo[inviterIndex].equals("Adam"))
			{
				//Adam invited friends list
				Guest guest = new Guest(guestInfo[guestIndex],Integer.valueOf(guestInfo[candyBroughtIndex]),Integer.valueOf(guestInfo[candyConsumedIndex]));
				int result =Integer.valueOf(guestInfo[candyBroughtIndex]) - Integer.valueOf(guestInfo[candyConsumedIndex]);
				guest.setInviter("Adam");
				guest.setLeftOver(result);
				boolean isInvited = (result >= 0)? true : false;
				guest.setInvited(isInvited);
				guestMapList.put(guestInfo[guestIndex], guest);
			}else if(!guestMapList.isEmpty())
			{
				if(guestMapList.containsKey(guestInfo[inviterIndex]))
				{
					Guest inviter = guestMapList.get(guestInfo[inviterIndex]);
					if(Integer.valueOf(guestInfo[candyBroughtIndex])+inviter.getLeftOver()>0)
					{
						Guest guest = new Guest(guestInfo[guestIndex],Integer.valueOf(guestInfo[candyBroughtIndex]),Integer.valueOf(guestInfo[candyConsumedIndex]));
						int result =inviter.getLeftOver() + Integer.valueOf(guestInfo[candyBroughtIndex]) - Integer.valueOf(guestInfo[candyConsumedIndex]);
						guest.setLeftOver(result);
						guest.setInviter(inviter.getName());
						
						boolean isInvited = (result >= 0)? true : false;
						guest.setInvited(isInvited);
						
						if(inviter.getInviter().equals("Adam")){
						//update inviter information
							inviter.setLeftOver(result);
							inviter.setInvited(isInvited);
						}
						
						inviter.setNextGuest(guest);
						guestMapList.put(inviter.getName(), inviter);
						
						//add new guest to hashmap
						guestMapList.put(guestInfo[guestIndex], guest);
						
					}
				}
			}
			
		}
	}
	
	
	/**
	 *  The function used to iterative the guest object.
	 *  If the the isInvited variable in Guest class is true, it will be print the result.
	 */
	private void printResult()
	{
		 java.util.Iterator<Entry<String, Guest>> it = guestMapList.entrySet().iterator();
         while (it.hasNext()) {
          Map.Entry pair = (Map.Entry)it.next();
          Guest guest = (Guest) pair.getValue();
          if(guest.isInvited())
        	  	System.out.println("guest "+guest.getName()+" should invited!!");
          it.remove(); // avoids a ConcurrentModificationException
         }
	}
	
	
	/**
	 * The function used to create our object and put intput data
	 * Finally, it print the all guests who should be invited.
	 * @param args
	 */
	public static void main(String[] args){
		String data[] = {"Guest,Inviter,CandyBrought,CandyConsumed",
				"Beth,Adam,4,2",
				"Cass,Adam,3,4",
				"Dole,Adam,2,3",
				"Evan,Beth,3,1",
				"Fury,Evan,2,2",
				"Greg,Dole,6,2",
				"Hugh,Cass,4,4",
				"Ivan,Cass,6,4",
				"Juan,Cass,3,1",
				"Kale,Ivan,1,6",
				"Leon,Ivan,2,5",
				"Mark,Ivan,1,6"};
		
		Invitation invitation = new Invitation(data);
		invitation.processData();
		invitation.printResult();
	}
}
