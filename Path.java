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

/* Class Header: This class represents a valid path through a grid of city blocks surrounded by streets.
* A path consists of the list of intersection objects from one crossing point (intersection) to another
 */
public class Path {

	
	private ArrayList<Intersection> intersections; //intersections holds the intersections of an instance of path
	
	/*
	 * Constructs the Path() object
	 * Path instance instantiates the intersection instance filed
	 */
	public Path()
	{
		intersections= new ArrayList<Intersection>();
	}
	
	/*
	 * the length() of intersections, 
	 * @returns number of intersections in a path
	 */
	public int length() {
		//System.out.println(intersections.size());
		return intersections.size();
	}
	
	/*
	 * gets the first intersection of the Path
	 * @throws NoSuchElementException if the length() is zero
	 * @return first index - an intersection- of the Path
	 */
	public Intersection getHead()  throws NoSuchElementException{
		if(length()!= 0)
		{
			return intersections.get(0);
		}
		else
		{
			//if length() is zero
			throw new NoSuchElementException("ArrayList empty");
		}
	}
	
	/*
	 * gets the last intersection of the Path
	 * @throws NoSuchElementException if the length() is zero
	 * @return last index - an intersection- of the Path
	 */
	public Intersection getTail()  throws NoSuchElementException{
		if(length()!= 0)
		{
			
			return intersections.get(length()-1);
		}
		else
		{
			//if length() is zero
			throw new NoSuchElementException("ArrayList empty");
		}
	}
	
	/*
	 * add a Intersection to the path at the end 
	 * @param toAdd, an intersection to possibly add to Path
	 * @throws IllegalArgumentException if toAdd is not east or north of original point
	 */
	public void addTail(Intersection toAdd) throws IllegalArgumentException {
		//int i =0;
		if((length()==0))
		{
			
			intersections.add(toAdd);
			//System.out.println(getTail());
			return;
		}
		
		else if(getTail().goEast().equals(toAdd))
		{
			//only east and north because intersection can only go those directions
			//System.out.println(getTail());
			intersections.add(toAdd);
			return;
		}
		
		else if(getTail().goNorth().equals(toAdd))
		{
			//System.out.println(getTail());
			intersections.add(toAdd);
			
			return;
		}
		else {
			//if toAdd was not being added to an empty Path, or East of tail of Path
			//or North of Tail of path
		throw new IllegalArgumentException("the given Intersection is not aA valid addition");
		}
		
	}
	
	/*
	 * add a Intersection to the path at the beginning 
	 * @param toAdd, an intersection to possibly add to Path
	 * @throws IllegalArgumentException if toAdd is not south or west of original point
	 */
	public void addHead(Intersection toAdd) throws IllegalArgumentException {
		if((length()==0))
		{
			//similar to addTail
			intersections.add(toAdd);
			return;
		}
		
		else if(getHead().goWest().equals(toAdd))
		{
			if(intersections.size()>0)
			{
				//add at beginning of path, so neeed at index 0
			intersections.add(0,toAdd);
			}
			return;
		}
		
		else if(getHead().goSouth().equals(toAdd))
		{
			if(intersections.size()>0)
			{
				//add at beginning of path, so neeed at index 0
			intersections.add(0,toAdd);
			}
			return;
		}
		
		else{
			//if toAdd was not being added to an empty Path, or south of tail of Path
			//or west of Tail of path
			throw new IllegalArgumentException("Not valid, tried to add Intersection " + toAdd +" to head of Path \" ");
		}
		
		
	}
	
	//toString Method 
	/** Returns a String representation of this Path.
	* @return the string form of this Path
	* it’s instance data field values intersections(ArrayList)
		*/		
	@Override
	public String toString()
	{
		String end=""; //the String to be returned.
		
		if(length()==0)
		{
			return "empty";
		}
		else {
			if(length()==1)
			{
				//does not need an arrow as the iPath has one intersection
				return ""+intersections.get(0);
			}
			else {
			
				for(int i = 0; i<length()-1;i++)
				{
					// a form of concat for each intersection in a Path
				end += "" + intersections.get(i)+"->";
				}
			//the last index does not need arows
			end+=	intersections.get(length()-1);
			}
		}
		
		
		return end; //returned string
	}
}
