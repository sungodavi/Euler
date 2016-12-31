import java.util.*;
public class Euler69 
{
	public static ArrayList<Integer> sieve;
	public static int totient(int num)
	{
		double ans = num;
		for(int i = 0; sieve.get(i) <= num/2; i++)
		{
			int temp = sieve.get(i);
			if(num % temp == 0)
			{
				ans *= temp-1;
				ans /= temp;
			}
		}
		
		return (int)ans;
	}
	
	public static int bruteForce()
	{
		double phi = 0;
		int ans = 0;
		sieve = Methods.sieve(1000000);
		for(int i = 1; i <= 1000000; i++)
		{
			int totient = totient(i);
			if(1.0 * i / totient > phi)
			{
				ans = i;
				phi = 1.0 * i / totient;
			}
		}
		System.out.println("n = " + ans + " produced the maximum n/phi(n): " + phi);
		return ans;
	}
	
	public static int solve(int limit)
	{
		sieve = Methods.sieve((int)Math.sqrt(limit));
		int ans = 1;
		int index = 0;
		while(ans < limit)
		{
			ans *= sieve.get(index);
			index++;
		}
		ans /= sieve.get(index - 1);
		while(ans < limit)
		{
			ans *= 2;
		}
		return ans/2;
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
