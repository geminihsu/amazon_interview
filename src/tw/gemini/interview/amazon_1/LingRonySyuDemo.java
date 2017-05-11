package tw.gemini.interview.amazon_1;
//This class create the tree class used to display my activities ,past experience and my future goal     
public class LingRonySyuDemo
{
         /**
	 * Main method
	 * This method use to create my object and print information
	 * @param args
	 */
	public static void main(String args[])	{
	    
	    //What I do every day, there are my activities routine
	    LingRongSyu now = new LingRongSyu("student");
	    now.addActivities(30,"study algorithm");
	    now.addActivities(40,"prepare interview");
	    now.addActivities(20,"add new feture to my android project");
	    now.addActivities(10,"add test function to my android project");
	    now.printInfo();
	    
	    //What I've learned in the past six month
	    LingRongSyuPast past = new LingRongSyuPast("student");
	    past.printInfo();
	    
	    //What I would like to learn in my next six months
	    LingRongSyuFuture future = new LingRongSyuFuture("android developer");
	    future.printInfo();
	}
}