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


/*Class Header: This class represents a single intersection point where two streets 
/laid out on a grid plan cross at specified x and y coordinate positions.
*/
public class Intersection {

	
	private final int x; //X coordinate
	
	private final int y; //y coordinate
	
	/*
	 * Constructs Intersection Object
	 * @param x is horizinal value location
	 * @param y is vertical value location
	 */
	public Intersection(int x, int y)
	{
		this.x = x;
		this.y= y;
	}
	
	
	/*
	 *gets the X value of object
	 *@return x - int of horizinatal location of intersection
	 */
	public int getX()
	{
		return x;
	}
	
	/*
	 *gets the y value of object
	 *@return y - int of vertical location of intersection
	 */
	public int getY()
	{
		return y;
	}
	
	
	//toString Method 
	/** Returns a String representation of this intersection.
	* @return the string form of this intersection
	 * it’s instance data field values (x,y)
	*/		
	@Override
	public String toString()
	{
		String fin = "(" + x + "," +y+ ")"; //format
		return fin;
	}
	
	/** Determines if the given object is equal to this intersection.
	* They are equal if other is a intersection and their x and Y are the same.
	* @param o, another object to check if it is equal to this
	* @return true if the two intersection are equal, false otherwise
	*/
	@Override
	public boolean equals(Object o) {
		if(o instanceof Intersection)
		{
			Intersection done;
			done = (Intersection) o;
			if((this.getY() == done.getY())&&(this.getX() == done.getX()))
			{
				//if the x and y values were same
				return true;
			}
		}
		return false;
	}
	
	/*
	 * makes the intersection to go North
	 * @return new intersection that is y+1 from original Intersection
	 */
	public Intersection goNorth()
	{
		int nextX = x;
		int nextY = y+1; //North as it does up
		return new Intersection(nextX,nextY);
	}
	
	/*
	 * makes the intersection to go South
	 * @return new intersection that is y-1 from original Intersection
	 */
	public Intersection goSouth()
	{
		int nextX = x;
		int nextY = y-1; //goes down
		return new Intersection(nextX,nextY);
	}
	
	/*
	 * makes the intersection to go west
	 * @return new intersection that is x-1 from original Intersection
	 */
	public Intersection goWest()
	{
		int nextX = x-1; //goes left of intersection
		int nextY = y;
		return new Intersection(nextX,nextY);
	}
	
	/*
	 * makes the intersection to go east
	 * @return new intersection that is x+1 from original Intersection
	 */
	public Intersection goEast()
	{
		int nextX = x+1; //goes right of intersection
		int nextY = y;
		return new Intersection(nextX,nextY);
	}
	
	//end of class
}
