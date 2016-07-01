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
		System.out.println(solve());
	}
}
