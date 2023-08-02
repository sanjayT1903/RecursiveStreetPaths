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
import java.util.Scanner;

/*Class Header: Tester class for PathUtils
 */

public class PathUtilsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*
	//this is from my first tests ebfore I created the tester methods
		Intersection what = new Intersection(0,0);
		Intersection who = new Intersection(0,1);
		
		Intersection where = new Intersection(1,1);
		Path a = new Path();
		a.addTail(what);
		a.addTail(who);
		//System.out.println(a.toString());
		
		
		//PathUtils stop = new PathUtils();
		//System.out.println(PathUtils.countPaths(what, where));
		//System.out.println(stop.toString());
		
		//System.out.println(PathUtils.findAllPaths(what, where));
		*/
		System.out.println("testCountPathsNoPath(): " + testCountPathsNoPath());
		
		System.out.println("testCountPathsOnePath(): " +testCountPathsOnePath());
		
		System.out.println("testCountPathsRecursive(): " +testCountPathsRecursive());
		
		System.out.println("testFindAllPathsNoPath(): " +testFindAllPathsNoPath());
		
		System.out.println("testFindAllPathsOnePath(): " +testFindAllPathsOnePath());
		
		System.out.println("testFindAllPathsRecursive(): " +testFindAllPathsRecursive());
		
		
		
	}
	
	/*
	 * tests CountPaths method when there should be no path
	 * @return true if tests all work as expected, false if else
	 */
	public static boolean testCountPathsNoPath() {
		try {
			//case 1 start is not less than end
		Intersection start = new Intersection(2,1);
		
		Intersection end = new Intersection(0,0);
		
		//Path a = new Path();
		
		//i stores the count
		int i = PathUtils.countPaths(start, end);
		
		//System.out.println(i);
		//0 is expected
		if(i!=0)
		{
			//should not run becasue start is more east and north than end which should never run
			System.out.println("First case testCountPathsNoPath");
			return false;
		}
		
		
		
		
		//ADDITIONAL case - start2 and end2 are the same so there should only be one path
		//this is an additonal case that seemed to fit in this method 
		/////SIDE NOTE - it can also fit in the onePath method as well but this test is where I originally 
		//expected it to return np path.
		Intersection start2 = new Intersection(2,1);
		
		Intersection end2 = new Intersection(2,1);
		
		//k stores the countpaths
		int k = PathUtils.countPaths(start2, end2);
		
		//should be 1
		if(k!=1)
		{
			System.out.println("aditional case testCountPathsNoPath");
			return false;
		}
		}
		catch( Exception e) {
		
			System.out.println("something in testCountPathsNoPath has gone wrong" );
		}
		//System.out.println(i);
		
		return true;
	}
	
	/*
	 * tests the CountPaths method when there should be one path result
	 * @return true if tests all work as expected, false if else
	 */
	public static boolean testCountPathsOnePath() {
		try {
			// case 1 - start is one position away from end
		Intersection start1 = new Intersection(0,0);
		
		Intersection end1 = new Intersection(0,1);
		
		//Path a = new Path();
		
		//int i should store 1
		int i = PathUtils.countPaths(start1, end1);
		
		if(i!=1)
		{
			System.out.println("First case testCountPathsOnePath");
			return false;
		}
		
		
		
		// case 2 - same as case one but no 0,0
		Intersection start2 = new Intersection(1,1);
		Intersection end2 = new Intersection(2,1);
		
		//Path b = new Path();
		//still expect 1
		int j = PathUtils.countPaths(start2, end2);
		if(j!=1)
		{
			System.out.println("second case testCountPathsOnePath");
			return false;
		}
		
		
		
		
		//case 3 - tests counter example as 0,0 is not only one possible path away form 2,1
		Intersection start3 = new Intersection(0,0);
		Intersection end3 = new Intersection(2,1);
		
		//Path b = new Path();
		//k should NOT be 1
		int k = PathUtils.countPaths(start3, end3);
		if(k==1)
		{
			System.out.println("third case testCountPathsOnePath");
			return false;
		}
		}
		catch( Exception e) {
			
			System.out.println("something in testCountPathsOnePath has gone wrong" );
		}
		
		return true;
	}
	
	
	/*
	 * tests cases of CountPath when the value should be over 1, math possible paths
	 * @return true if tests all work as expected, false if else
	 */
	public static boolean testCountPathsRecursive() {
		try {
			
		//case 1-intersection start1 has multiple paths to end1
		Intersection start1 = new Intersection(0,0);
		Intersection end1 = new Intersection(2,1);
		
		int i = PathUtils.countPaths(start1, end1);
		//System.out.println(i);
		
		//i should be 3
		if(i!=3)
		{
			System.out.println("First case testCountPathsRecursive");
			return false;
		}
		
		
		
		//case 2-intersection start2 has multiple paths to end2
		Intersection start2 = new Intersection(0,0);
		Intersection end2 = new Intersection(5,2);
		
		//Path b = new Path();
		
		int j = PathUtils.countPaths(start2, end2);
		//j should be a large number 21
		if(j!=21)
		{
			System.out.println("second case testCountPathsRecursive");
			return false;
		}
	  }	
      catch( Exception e) {
			
			System.out.println("something in testCountPathsRecursive has gone wrong" );
		}
	 return true;
	}
	
	
	/*
	 * uses findAllPaths when the result should be an empty arrayList
	 * @return true if tests all work as expected, false if else
	 */
	public static boolean testFindAllPathsNoPath() {
		try {
		//case 1 start is invalid as it is in a greater place
		Intersection start1 = new Intersection(0,1);
		Intersection end1 = new Intersection(0,0);
		
		if(!(PathUtils.findAllPaths(start1, end1).isEmpty()))
			{
			System.out.println("First case testFindAllPathsNoPath");
			return false;
			}
	
		
		
		//this is an ADDITIONAL case, placed this test here to the location of this tests when testing the countPathonePath method
		//similar to the testCountPathsOnePath methods additional test, with Start and end equaling same. 
		//There is only one path which is a path with one intersection
		//this is a test to see if the contents are the same where there is only one path and one intersection [(0,0)]
		Intersection start2 = new Intersection(0,0);
		Intersection end2 = new Intersection(0,0);
		
		Path b = new Path();
		b.addHead(start2);
		//this is the expected result of [(0,0)]
		ArrayList<Path> result = new ArrayList<Path>();
		result.add(b);
		
		//System.out.println(PathUtils.findAllPaths(start2, end2));
		//System.out.println(result);
		
		//they should be the same as both should have [(0,0)]
		if(!(PathUtils.findAllPaths(start2, end2).get(0).getHead()==(result).get(0).getHead()))
		{
		System.out.println("additional case testFindAllPathsNoPath");
		return false;
		}
		}
		catch( Exception e) {
				
		System.out.println("something in testFindAllPathsNoPath has gone wrong" );
		}
		
	 return true;
	}
	
	
	
	/*
	 * uses findAllPaths when the result should be an arrayList with one path
	 * @return true if tests all work as expected, false if else
	 */
	public static boolean testFindAllPathsOnePath() {
		try {
		//case 1 - one possible path
		Intersection start1 = new Intersection(0,0);	
		Intersection end1 = new Intersection(0,1);
		
		//one is expected as number of paths
		if(!(PathUtils.findAllPaths(start1, end1).size()==1))
		{
		System.out.println("First case testFindAllPathsOnePath");
		return false;
		}
		
		
		
		//  case 2- comparing string values of the resulting Path array and the proper result
		String supposedEnd = PathUtils.findAllPaths(start1, end1).toString(); //string of result
		String endCycle = "[(0,0)->(0,1)]"; //expected string
		
		//they should be equal to each other
		if(!(supposedEnd.equals(endCycle)))
		{
			System.out.println("second case testFindAllPathsOnePath");
			return false;
		}
		
		}
		catch( Exception e) {
			
		System.out.println("something in testFindAllPathsOnePath has gone wrong" );
			}
		return true;
	}
	
	
	
	/*
	 * uses findAllPaths when the result should be an arrayList with multiple paths
	 * @return true if tests all work as expected, false if else
	 */
	public static boolean testFindAllPathsRecursive()
	{
		try {
			//case 1- should have 3 results
		Intersection start1 = new Intersection(0,0);
		Intersection end1 = new Intersection(2,1);
		
		//should be equal to three paths
		if(!(PathUtils.findAllPaths(start1, end1).size()==3))
		{
		System.out.println("First case testFindAllPathsRecursive");
		return false;
		}
		
		
		
		
		//case 2 - String version of the Path ArrayList from findAllPaths
		String supposedEnd = PathUtils.findAllPaths(start1, end1).toString();
		//System.out.println(supposedEnd);
		String endCycle = "(0,0)->(1,0)->(2,0)->(2,1)"; //path 1
		String endCycle2 = "(0,0)->(1,0)->(1,1)->(2,1)";//path 2
		String endCycle3 = "(0,0)->(0,1)->(1,1)->(2,1)";//path 3
		
		//used the contains method and saw if if all 3 proper results (the endCylces) where contained, 
		//if all three are contained in the String version of the ArrayList then it was true, if not then the test fails
		if(!((supposedEnd.contains(endCycle)&&(supposedEnd.contains(endCycle2)&&(supposedEnd.contains(endCycle3))))))
		{
			System.out.println("second case testFindAllPathsRecursive");
			return false;
		}
			
		
		
		
		//case 3 - same idea as case 2 but more possible paths
		Intersection start2 = new Intersection(0,0);
		Intersection end2 = new Intersection(2,2);
		
		//the ArrayList Paths size() and countAll Paths should be equal
		if(!(PathUtils.findAllPaths(start1, end1).size()==(PathUtils.countPaths(start1, end1))))
		{
		System.out.println("third case testFindAllPathsRecursive");
		return false;
		}
		
		
		
		
		String supposedEnd2 = PathUtils.findAllPaths(start2, end2).toString();
		//System.out.println(supposedEnd2);
		String sample1 = "(0,0)->(1,0)->(2,0)->(2,1)->(2,2)";//path 1
		String sample2 = "(0,0)->(1,0)->(1,1)->(2,1)->(2,2)";//path 2
		String sample3 = "(0,0)->(1,0)->(1,1)->(1,2)->(2,2)";//path 3
		String sample4 = "(0,0)->(0,1)->(1,1)->(2,1)->(2,2)";//path 4
		String sample5 = "(0,0)->(0,1)->(1,1)->(1,2)->(2,2)";//path 5
		String sample6 = "(0,0)->(0,1)->(0,2)->(1,2)->(2,2)";//path 6 
		
		// case 4 - broke up the .contains check into halves. One half is sample1-3, should contain all three- return false, if it does not
		if(!((supposedEnd2.contains(sample1)&&(supposedEnd2.contains(sample2)&&(supposedEnd2.contains(sample3))))))
		{
			System.out.println("fourth case testFindAllPathsRecursive");
			return false;
		}
		//case 5 - broke up the .contains check into halves. One half is sample4-6, should contain all three
		if(!((supposedEnd2.contains(sample4)&&(supposedEnd2.contains(sample5)&&(supposedEnd2.contains(sample6))))))
		{
			System.out.println("fifth case testFindAllPathsRecursive");
			return false;
		}
		}
		catch( Exception e) {
			
			System.out.println("something in testFindAllPathsRecursive has gone wrong" );
				}
		
		return true;
	}

}
