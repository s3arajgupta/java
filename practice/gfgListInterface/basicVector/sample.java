package practice.gfgListInterface.basicVector;

// Java program to demonstrate the
// creation of list object using the
// Vector class

// import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args)
	{
		// Size of the vector
		int n = 5;

		// Declaring the List with initial size n
		List<Integer> v = new Vector<Integer>(n);

		// Appending the new elements
		// at the end of the list
		for (int i = 1; i <= n; i++)
			v.add(i);

		// Printing elements
		System.out.println(v);

		// Remove element at index 3
		v.remove(3);

		// Displaying the list after deletion
		System.out.println(v);

		// Printing elements one by one
		for (int i = 0; i < v.size(); i++)
			System.out.print(v.get(i) + " ");
	}
}
