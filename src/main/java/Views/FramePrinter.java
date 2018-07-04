package main.java.Views;

import java.util.List;

import main.java.Models.Frame;

/**
 * Prints the list of frames to standard output.
 * @author Marius K
 */
public class FramePrinter 
{

	/**
	 * Prints the list of frames to standard output, considering special cases like strikes and spares.
	 * @param allFrames
	 */
	public void printFrames(List<Frame> allFrames) 
	{
		for (Frame frame : allFrames)
		{
			if (frame.isStrike())
			{
				System.out.println("Frame : X");
			}
			else if (frame.isSpare())
			{
				System.out.println("Frame : " + frame.getFirstThrowPinsKnockedDown() + ", /");
			}
			else
			{
				System.out.println("Frame : " + frame.getFirstThrowPinsKnockedDown() + ", " + frame.getSecondThrowPinsKnockedDown());
			}
		}
	}

}
