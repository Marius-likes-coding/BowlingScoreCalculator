package test.java.Controllers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.Controllers.FrameParsingController;
import main.java.Models.Frame;

public class FrameParsingControllerTest 
{
	private FrameParsingController frameParsingController;
	
	@Before
    public void setUp() 
	{
		frameParsingController = new FrameParsingController();
    }

	 
    @After
    public void tearDown() 
    {
    }
    
	@Test(expected = IllegalArgumentException.class) 
	public void testParseFrames_throws_error_if_sum_of_knocked_down_pins_of_a_frame_is_higher_than_10() throws Exception 
	{
		String[] throwList = {"7", "6"};
		
		frameParsingController.parseFrames(throwList);
	}
    
	@Test(expected = IllegalArgumentException.class) 
	public void testParseFrames_throws_error_if_number_of_knocked_down_pins_of_a_single_throw_is_higher_than_10() throws Exception 
	{
		String[] throwList = {"11", "0"};
		
		frameParsingController.parseFrames(throwList);
	}
    
	@Test(expected = NumberFormatException.class) 
	public void testParseFrames_throws_error_if_number_is_of_incorrect_format_character() throws Exception 
	{
		String[] throwList = {"a", "0"};
		
		frameParsingController.parseFrames(throwList);
	}
    
	@Test(expected = NumberFormatException.class) 
	public void testParseFrames_throws_error_if_number_is_of_incorrect_format_double() throws Exception 
	{
		String[] throwList = {"1.0", "0"};
		
		frameParsingController.parseFrames(throwList);
	}
    
	@Test(expected = IllegalArgumentException.class) 
	public void testParseFrames_throws_error_if_number_is_smaller_than_0() throws Exception 
	{
		String[] throwList = {"-1", "-10"};
		
		frameParsingController.parseFrames(throwList);
	}
    
	@Test(expected = IllegalArgumentException.class) 
	public void testParseFrames_throws_error_if_number_is_bigger_than_10() throws Exception 
	{
		String[] throwList = {"11"};
		
		frameParsingController.parseFrames(throwList);
	}
    
	@Test
	public void testParseFrames_strikes_are_parsed_correctly_with_one_throw_per_frame()
	{
		String[] throwList = {"10", "10"};
		
		List<Frame> parsedFrames = frameParsingController.parseFrames(throwList);

		assertEquals(parsedFrames.size(), 2);
		assertEquals(parsedFrames.get(0).getFirstThrowPinsKnockedDown(), 10);
		assertEquals(parsedFrames.get(1).getFirstThrowPinsKnockedDown(), 10);
	}
    
	@Test
	public void testParseFrames_normal_frames_and_spares_are_parsed_correctly()
	{
		String[] throwList = {"0", "10", "4", "3"};
		
		List<Frame> parsedFrames = frameParsingController.parseFrames(throwList);

		assertEquals(parsedFrames.size(), 2);
		assertEquals(parsedFrames.get(0).getFirstThrowPinsKnockedDown(), 0);
		assertEquals(parsedFrames.get(0).getSecondThrowPinsKnockedDown(), 10);
		assertEquals(parsedFrames.get(1).getFirstThrowPinsKnockedDown(), 4);
		assertEquals(parsedFrames.get(1).getSecondThrowPinsKnockedDown(), 3);
	}

	@Test(expected = IllegalArgumentException.class) 
	public void testParseFrames_throws_error_if_last_frame_is_incomplete() throws Exception 
	{
		String[] throwList = {"0", "10", "4"};
		
		frameParsingController.parseFrames(throwList);
	}

}
