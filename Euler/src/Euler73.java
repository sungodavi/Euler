import java.util.*;
public class Euler73 
{
	public static long solve(int limit)
	{
		double low = 1.0/3;
		double high = .5;
		long count = 0;
		for(int d = 2; d <= limit; d++)
		{
			for(int n = 1; n < d; n++)
			{
				if(Methods.gcd(n, d) == 1)
				{
					double fraction = 1.0 * n/d;
					if(fraction > low && fraction < high)
						count++;
					else if(fraction > high)
						break;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(12000));
	}
}
