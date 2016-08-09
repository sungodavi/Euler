import java.util.*;
public class Euler179 
{
	public static int solve(int max)
	{
		int count = 0;
		int[] a = new int[max + 1];
		Arrays.fill(a,1);
		for(int i = 2; i < a.length; i++)
		{
			for(int j = i; j < a.length; j +=i)
			{
				a[j]++;
			}
		}
		for(int index = 2; index < max; index++)
			if(a[index] == a[index+1])
				count++;
		return count;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(10000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
