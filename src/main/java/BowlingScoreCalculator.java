package main.java;

import java.util.List;

import main.java.Controllers.FrameParsingController;
import main.java.Controllers.ScoreCalculatingController;
import main.java.Models.Frame;
import main.java.Views.FramePrinter;
import main.java.Views.ScorePrinter;

public class BowlingScoreCalculator 
{
	
	public static void main(String[] args) 
	{
		// parsing
		FrameParsingController frameParsingController = new FrameParsingController();
		List<Frame> allFrames = frameParsingController.parseFrames(args);
		
		// calculating score
		ScoreCalculatingController scoreCalculatingController = new ScoreCalculatingController();
		int finalScore = scoreCalculatingController.calculateTotalScoreWithFrames(allFrames);
		
		// printing data
		FramePrinter framePrinter = new FramePrinter();
		framePrinter.printFrames(allFrames);
		
		// printing results
		ScorePrinter scorePrinter = new ScorePrinter();
		scorePrinter.printScore(finalScore);
	}
	
}
