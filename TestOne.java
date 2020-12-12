// William Dunn - Comparing Marathon Runner Times

package codingChallengeTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestOne {

	public static void main(String[] args) {
		
		/* file format should be: 
		 * 
		 * n number of run times 					3
		 * time 1 (HH:MM:SS)						10:03:39
		 * time 2 (HH:MM:SS)						08:14:51
		 * time 3 (HH:MM:SS)						09:57:08
		 * */
		
		File file = new File("example.txt");
		
		try
		{
			Scanner in = new Scanner(file);
			
			ArrayList<String> times = new ArrayList<String>();
	
			// grabs the first number in the file to determine how many run times are in the file
			// then loops through each one and stores each time in the times list
			int n = in.nextInt();
			for (int i = 0; i <= n; i++) 
			{
				times.add(in.nextLine());
			}
			
			String[] marathonSeconds = new String[2]; // contains HH [0], MM [1], SS[2] 
			int[] timeInSeconds = new int[n]; // contains each run time in total seconds
			int currentIteration = 0;
	
			// loops through each run time in the arraylist and converts the total of each run time 
			// into total seconds and places them into a corresponding array
			for(int x = 0; x < times.size() - 1; x++)
			{	
				marathonSeconds = times.get(x + 1).split(":");
				String hour = marathonSeconds[0];
				String minute = marathonSeconds[1];
				String second = marathonSeconds[2];
	
				int hourVal = Integer.parseInt(hour) * 60* 60;
				int minuteVal = Integer.parseInt(minute) * 60;
				int secondVal = Integer.parseInt(second);
	
				int totalTime = hourVal + minuteVal + secondVal;
				
				timeInSeconds[currentIteration] = totalTime;
				currentIteration++;
			}
			
			// compares each spot of the timeInSeconds array and finds the smallest number with the
			// index of the array which corresponds to the original times Array
			int smallestNumSpot = 0;
			int numComparison = timeInSeconds[0];
			for(int y = 0; y < timeInSeconds.length; y++)
			{
				if(timeInSeconds[y] < numComparison)
				{
					numComparison = timeInSeconds[y];
					smallestNumSpot = y;
				}
			}
	
			// prints out the quickest run time
			System.out.println(times.get(smallestNumSpot + 1));   
			in.close();
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
}