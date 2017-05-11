package tw.gemini.interview.amazon_1;
//This class extends my derived class in order to describe my future goal
public class LingRongSyuFuture extends LingRongSyu
{
   /** @Override
	 * Constructor
	 * @param role
	 */
    public LingRongSyuFuture(String role)
    {
    	super(role);
    	System.out.println("-------------------------------------------------");
        System.out.println("This is Ling Rong Syu future goal! I am looking for "+role+".");
        
    }
    
    protected void printInfo(){
        System.out.println("As a senior android developer, I've developed five project and there has been relesed on Google Play Store.");
        System.out.println("One of them has over 100 thousand downloads on Play Store.");
        System.out.println("Every time I get feedback from consumer, I realized that user always have requirements and I should achieve their goals.");
        System.out.println("I am looking for android position in U.S. I wish that I can work at Company, which will grow up and I will have more opportunity to reach my goals.");
    
    }
}