import java.util.*;
public class Euler231 
{
	public static long countFactors(long fact, long num)
	{
		long sum = 0;
		for(long i = num; i <= fact; i *= num)
		{
			sum += fact/i;
		}
		return sum;
	}
	public static long solve(int n, int r)
	{
		ArrayList<Integer> sieve = Methods.sieve(n);
		long[] a = new long[sieve.size()];
		long sum = 0;
		for(int i = 0; i < a.length; i++)
		{
			int prime = sieve.get(i);
			sum += prime * (countFactors(n,prime) - countFactors(r,prime) - countFactors(n-r,prime));
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(20000000,15000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
