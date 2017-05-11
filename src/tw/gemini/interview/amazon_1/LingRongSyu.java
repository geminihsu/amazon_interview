package tw.gemini.interview.amazon_1;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * ------------------------------------------Structure--------------------------------------------------------------------
 * Before I start coding use object - oriented programming, I define my derived class LingRongSyu,
 * it has two variables. character variable represent my role in my life. Activities variable is a hashmap type, 
 * which used time as key in order to mapping each activity percentage of time I spent. Than I created two child classes.
 * One of the class, LingRongSyuPast, which is define what I done in the past six months. Another one, LingRongSyuFuture,
 * which is define what would like to learn in the next six months.
 * _______________________________________________________________________________________________________________________
 *
 * I implemented java inheritance in order to reuse my code.If I want to add some function in child class, it won't 
 * affect my Derived class. Besides inheritance, I create HashMap type as activities container. Therefore, if I want to
 * query how many time I spend on activities, the time complexity only O(1).
 * 
 * */

//Derived class define my role and behavior
public class LingRongSyu
{
    private String character;//define my role
    private HashMap<Integer,String> activities;//my activies container
    
    /**
	 * Constructor
	 * @param role
	 */
    public LingRongSyu(String role)
    {
        this.character = role;
        this.activities = new HashMap<Integer,String>();
    }
    
     /**
    * This method define what activities I do
    * @param time: the hashMap key is time/percentage
    * @param activity: the hashMap value is activity
    */
    protected void addActivities(int time,String activity)
    {
        activities.put(time,activity);
    }
    
    /**
    * This method used to remove activity
    * @param time: the activity key equal time will be remove
    */
     protected void removeActivities(int time)
    {
        activities.remove(time);
    }
    
    //print my all information about what I doing right now
    protected void printInfo()
    {
        System.out.println("My name is Ling Rong Syu");
        System.out.println("I'm a "+character+"right now.");
        System.out.println("What's activities I doing right now:");
        if(!activities.isEmpty())
        {
              java.util.Iterator<Entry<Integer, String>> it = activities.entrySet().iterator();
              while (it.hasNext()) {
               Map.Entry pair = (Map.Entry)it.next();
               System.out.println("I spent "+pair.getKey() + "% to " + pair.getValue());
               it.remove(); // avoids a ConcurrentModificationException
           }
        }
    }
    
   
}
