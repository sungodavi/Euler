import java.util.*;

public class Euler33 
{
	public static int solve()
	{
		int maxN=1, maxD=1;
		for(int i = 1; i < 10; i++)
		{
			for(int d = 1; d < i; d++)
			{
				for(int n = 1; n < d; n++)
				{
					if((n * 10 + i) * d == n * (i * 10 + d))
					{
						maxD *= d;
						maxN *= n;
					}
				}
			}
		}
		return maxD / Methods.gcd(maxN, maxD);
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
