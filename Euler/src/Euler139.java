import java.util.*;
public class Euler139 
{
	public static boolean check(long a, long b, long c)
	{
		return (c*c) % (c*c - 2 * a *b) == 0;
	}
	public static int solve(int p)
	{
		int count = 0;
		for(int m = 2; 2*m * (m + 1) < p; m++)
		{
			for(int n = 1; n < m; n++)
			{
				if(Methods.gcd(m, n) > 1 || (m-n) % 2 == 0)
					continue;
				int a = m*m-n*n;
				int b = 2*m*n;
				int c = m*m + n*n;
				int d = 1;
				while(2*d*m*(m+n) < p)
				{
					if(check(d*a, d*b, d*c))
						count++;
					d++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(100000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
