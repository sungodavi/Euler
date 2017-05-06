import java.math.*;
public class Euler45 
{
	public static long tri(long n)
	{
		return n*(n+1)/2;
	}
	
	public static long pent(long n)
	{
		return n*(3*n-1)/2;
	}
	public static long hex(long n)
	{
		return n*(2*n-1);
	}
	public static long bruteForce()
	{
		boolean check = false;
		boolean temp1 = false;
		boolean temp2 = false;
		long x = 286;
		outer:
		while(!check)
		{
			temp1 = false;
			temp2 = false;
			
			int p = 166;
			while(pent(p) <= tri(x))
			{
				if(pent(p) == tri(x))
				{
					temp1 = true;
					break;
				}
				else p++;
			}
			
			int h = 144;
	 		while(hex(h) <= tri(x))
			{
				if(hex(h) == tri(x))
				{
					temp2 = true;
					break;
				}
				else h++;
			}
			
			if(temp1 &&  temp2)
				break outer;
			
			
			x++;
		}
		return tri(x);
	}
	
	public static long solve()
	{
		long x = 286;
		while(true)
		{
			long hex = 1 + 4 * x * (x+1);
			long pent = 1 + 12 * x * (x+1);
			if(Methods.isPerfectSquare(pent) && ((int)Math.sqrt(pent) + 1) % 6 == 0)
				if(Methods.isPerfectSquare(hex) && ((int)Math.sqrt(hex) + 1) % 4 == 0)
					return tri(x);
			x++;
		}
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long x = solve();
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
