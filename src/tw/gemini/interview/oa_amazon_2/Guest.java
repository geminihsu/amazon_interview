package tw.gemini.interview.oa_amazon_2;

public class Guest {

	private String name;//guest name
	private int candyBrought;// the amount of candy they brought
	private int candyConsumed;//the amount of candy they consumed
	private int leftOver;// the amount leftover of the candy 
	private String inviter;// who invited the guest
	private Guest nextGuest;// who is the next guest invited by them 
	private boolean isInvited;//the result store whether the guest invited or not
	
	/**Constructor
	 * @param guest: guest name
	 * @param _candyBrought: the amount of candy they brought
	 * @param _candyConsumed: the amount of candy they consumed
	 */
	public Guest(String guest,int _candyBrought,int _candyConsumed)
	{
		this.name = guest;
		this.candyBrought = _candyBrought;
		this.candyConsumed = _candyConsumed;
		this.nextGuest = null;
	}

	
	/**
	 * getter/setter methods
	 *
	 */
	
	/**
	 * @return leftOver variable
	 */
	public int getLeftOver() {
		return leftOver;
	}

	/**
	 * @param leftOver
	 */
	public void setLeftOver(int leftOver) {
		this.leftOver = leftOver;
	}

	/**
	 * @return isInvited
	 */
	public boolean isInvited() {
		return isInvited;
	}

	
	/**
	 * @param isInvited
	 */
	public void setInvited(boolean isInvited) {
		this.isInvited = isInvited;
	}

	/**
	 * @return nextGuest object
	 */
	public Guest getNextGuest() {
		return nextGuest;
	}

	/**
	 * @param nextInviter
	 */
	public void setNextGuest(Guest nextInviter) {
		this.nextGuest = nextInviter;
	}

	/**
	 * @return guest name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return inviter name
	 */
	public String getInviter() {
		return inviter;
	}

	/**
	 * @param inviter
	 */
	public void setInviter(String inviter) {
		this.inviter = inviter;
	}
	
	
	
}
