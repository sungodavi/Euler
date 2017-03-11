import java.util.*;
public class Euler129 
{
	/**
	 * Uses Euler's Theorem to find the order of 10 (mod n)
	 */
	public static long findLength(int n)
	{
		if(n % 3 == 0)
			n *= 9;
		int totient = Methods.totient(n);
		ArrayList<Integer> factors = Methods.divisors(totient);
		for(int i = 0; i < factors.size() - 1; i++)
		{
			int num = 10;
			int f = factors.get(i);
			for(int j = 2; j <= f; j++)
				num = (num * 10) % n;
			
			if(num == 1)
				return f;
		}
		return totient;
	}
	
	public static long solve(int limit)
	{
		int n = limit + 1;
		while(true)
		{
			if(n % 2 == 0 || n % 5 == 0)
			{
				n++;
				continue;
			}
			if(findLength(n) > limit)
				return n;
			n++;
		}
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1000000));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
