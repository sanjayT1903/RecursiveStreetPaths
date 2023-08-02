//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    City Route Planner PO6
// Course:   CS 300 Fall 2022
// 
// Author:   (Sanjay Thasma)
// Email:    (thasma@wisc.edu)
// Lecturer: (Hobbes LeGault)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: N/A   (name of your pair programming partner)
// Partner Email: N/A  (email address of your programming partner)
// Partner Lecturer's Name: N/A (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _X__ Write-up states that pair programming is allowed for this assignment.
//   _X__ We have both read and understand the course Pair Programming Policy.
//   _X__ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         (identify each by name and describe how they helped)
// Online Sources:  (N/A)
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.NoSuchElementException; 

/*
 * Class Header: Utility methods for planning a trip through the streets of an urban grid city.
 */
 
public class PathUtils {

	/*
	 * constructs PathUtils object
	 */
	public PathUtils()
	{
		
	}
	
	
	/*
	 * counts number of paths possible from one intersection to another 
	 * @param Start - the intersection that the Path begins at
	 * @param end - the intersection the Path has to reach
	 * @return count of the number of Paths avilable to Start and End
	 */
	public static int countPaths(Intersection start, Intersection end)
	{
		int count =0;
		if (start.equals(end))
		{
			//base case when Start = end
			return 1;
		}
		
		if((start.getX()>end.getX())||(start.getY()>end.getY()))
		{
			//when the start intersection was above end, 
			//error case
			return 0;
		}
	
		//recursive case
		//recursed the two valid directionsnOrth and East
		count = countPaths(start.goEast(),end) + countPaths(start.goNorth(),end);
		return count;
	}
	
	
	/*
	 * findAllPaths - finds every possible path and all the possible intersection in the paths
	 * @param Start - the intersection that the Path begins at
	 * @param end - the intersection the Path has to reach 
	 * @return listPaths ArrayList of path with specific Paths 
	 */
	public static ArrayList<Path> findAllPaths(Intersection start, Intersection end)
	{
		Path newer = new Path();
		ArrayList<Path> listPaths = new ArrayList<Path>();
	
		//base case
		if (start.equals(end))
		{	
			//base case - start equals end
			newer.addHead(start); //Path adds start (Start= end)
			listPaths.add(newer); // that Path then is added to listPaths
			return listPaths; //returned the arrayList
		
		}
		
		
		//error case
		
		//If Start is higher than end (x value)
		if((start.getX()>end.getX()))
		{
			//return empty arrayList
			return new ArrayList<Path>();
		}
		//If Start is higher than end (y value)
		 if((start.getY()>end.getY())){
			//return empty arrayList
			 return new ArrayList<Path>(); 
		 }
		
		 
		 //recursive case
		//passes the ArrayList from the base case
		 ArrayList<Path> east =findAllPaths(start.goEast(),end);
		 for(int i =0; i<east.size();i++) {
			 //for every path of the recursive call needs to add the previous intersection - working backwards.
			 //adds the start to every path from the base case for East
			 east.get(i).addHead(start);
		 }
		 //after add has been updated, then add it to the passed new List - East
		 listPaths.addAll(east);
		
		 
		 ArrayList<Path> north =findAllPaths(start.goNorth(),end);
		 for(int i =0; i<north.size();i++) {
			 
			//adds the start to every path from the base case for North
			 north.get(i).addHead(start);
		 }
		//after add has been updated, then add it to the passed new List - North
		 listPaths.addAll(north);
		 
		 //return
		 return listPaths;
	
	}
	
	
	
}
