package main.java.Models;

/**
 * Represent one bowling frame which consists of two consecutive throws.
 * @author Marius K
 */
public class Frame 
{
	public static final int TOTAL_PINS_IN_FRAME = 10;

	private int firstThrowPinsKnockedDown;
	private int secondThrowPinsKnockedDown;

	public Frame(int _firstThrowPinsKnockedDown, int _secondThrowPinsKnockedDown)
	{
		this.firstThrowPinsKnockedDown = _firstThrowPinsKnockedDown;
		this.secondThrowPinsKnockedDown = _secondThrowPinsKnockedDown;
	}

	
	public Frame() 
	{
		this.firstThrowPinsKnockedDown = 0;
		this.secondThrowPinsKnockedDown = 0;
	}


	public int getFirstThrowPinsKnockedDown() 
	{
		return firstThrowPinsKnockedDown;
	}

	public void setFirstThrowPinsKnockedDown(int _firstThrowPinsKnockedDown) 
	{
		this.firstThrowPinsKnockedDown = _firstThrowPinsKnockedDown;
	}

	public int getSecondThrowPinsKnockedDown() 
	{
		return secondThrowPinsKnockedDown;
	}

	public void setSecondThrowPinsKnockedDown(int _secondThrowPinsKnockedDown) 
	{
		this.secondThrowPinsKnockedDown = _secondThrowPinsKnockedDown;
	}
	
	/**
	 * @return true if the frame is a strike, that is that all the pins where knocked down by the first throw, otherwise false
	 */
	public boolean isStrike()
	{
		return firstThrowPinsKnockedDown == TOTAL_PINS_IN_FRAME;
	}

	/**
	 * @return true if the frame is a spare, that is that all the remaining pins where knocked down by the second throw, otherwise false
	 */
	public boolean isSpare()
	{
		return firstThrowPinsKnockedDown + secondThrowPinsKnockedDown == TOTAL_PINS_IN_FRAME;
	}

	/**
	 * @return true if the frame is valid, that is that the sum of the knocked down pins from the two throws does not exceed the total number of pins, otherwise false
	 */
	public boolean isValid()
	{
		return firstThrowPinsKnockedDown + secondThrowPinsKnockedDown <= TOTAL_PINS_IN_FRAME;
	}
	

	/**
	 * @return the sum of the knocked down pins from the two throws
	 */
	public int getFrameScore()
	{
		return firstThrowPinsKnockedDown + secondThrowPinsKnockedDown;
	}
}