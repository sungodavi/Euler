import java.util.*;
public class Euler204 
{
	public static int solve(int limit, int h)
	{
		ArrayList<Integer> sieve = Methods.sieve(h);
		int count = 0;
		for(int i = 1; i <= limit; i++)
		{
			int temp = i;
			for(int prime: sieve)
			{
				if(temp < prime)
					break;
				while(temp % prime == 0)
					temp /= prime;
			}
			if(temp == 1)
				count++;
		}
		return count;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1000000000,100));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime / 1000) + " seconds");
	}
}
