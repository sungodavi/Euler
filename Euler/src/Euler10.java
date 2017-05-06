import java.util.*;
public class Euler10 
{
	public static long solve()
	{
		ArrayList<Integer> sieve = Methods.sieve(2000000);
		long sum = 0;
		for(Integer i: sieve)
		{
			sum += i;
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
