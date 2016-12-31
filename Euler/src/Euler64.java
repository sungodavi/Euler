import java.util.*;
import java.math.*;
public class Euler64 
{
	public static int continuedFraction(int num)
	{
		int denominator = 1;
		int a = 0;
		int target = (int)(Math.sqrt(num));
		int count = 0;
		do
		{
			a -= (int)((Math.sqrt(num) + a)/denominator) * denominator;
			denominator = (num - a * a)/denominator;
			a *= -1;
			count++;	
		}while(a != target || denominator != 1);
		
		return count;
		
	}
	public static int solve(int limit)
	{
		int count = 0;
		for(int i = 2; i <= limit; i++)
		{
			if(!Methods.isPerfectSquare(i))
			{
				int period = continuedFraction(i);
				if(period % 2 != 0)
					count++;
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(10000));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
