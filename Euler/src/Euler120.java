import java.util.*;
public class Euler120 
{
	public static int findMax(int a)
	{
		SortedSet<Integer> residues = new TreeSet<Integer>();
		int n = 1;
		while(residues.add((2 * n * a)%(a*a)))
				n+=2;
		return residues.last();		
	}
	public static int solve()
	{
		int sum = 0;
		for(int a = 3; a <= 1000; a++)
		{
			sum += findMax(a);
		}
		return sum;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
