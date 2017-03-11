import java.util.*;

public class Euler35 
{
	public static boolean checkRotations(int num)
	{
		int[] a = Methods.toArray(num);
		for(int i = 1; i < a.length; i++)
		{
			String s = "";
			for(int j = 0; j < a.length; j++)
			{
				s += a[(j + i) % a.length];
			}
			if(!Methods.checkPrime(Integer.parseInt(s)))
				return false;
		}
		return true;
	}
	
	public static int solve(int limit)
	{
		int count = 0;
		ArrayList<Integer> sieve = Methods.sieve(limit);
		
		for(int primes: sieve)
		{
			if(checkRotations(primes))
				count++;
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
