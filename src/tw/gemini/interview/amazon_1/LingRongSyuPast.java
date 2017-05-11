package tw.gemini.interview.amazon_1;
//This class extends my derived class in order to describe my past experience
public class LingRongSyuPast extends LingRongSyu
{
   
    /**@Override
	 * Constructor
	 * @param role
	 */
    public LingRongSyuPast(String role)
    {
    	 super(role);
    	 System.out.println("-------------------------------------------------");
         System.out.println("This is Ling Rong Syu past!");
        
    }
    
    protected void printInfo(){
        System.out.println("I have been here for over one year.");
        System.out.println("Last year April, I start my cerification programing at UCSC school.");
        System.out.println("I took a lot of courses such as Hadoop and Developing Applications for iPhone and iPad.");
        System.out.println("Each quarter I take four courses. Therefore, I spent most of times do assignments.");
        System.out.println("After the past six months, I learned new programming language in order to improve my coding knowledge,");
        System.out.println("and how to do collaboration with my classmates.");
        System.out.println("In conclusion, Not only did improve my technical skill but I also enhance my communication ability.");

    }
    
   
}
