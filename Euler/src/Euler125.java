import java.util.*;
public class Euler125 
{
	public static boolean isPal(int num)
	{
		int[] a = Methods.toArray(num);
		for(int i = 0; i <= a.length / 2; i++)
		{
			if(a[i] != a[a.length - 1- i])
				return false;
		}
		return true;
	}
	public static long solve(int limit)
	{
		long sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		//loop through the starting values of consecutive squares
		for(int i = 1; i < limit; i++)
		{
			int num = i*i + (i+1)*(i+1);
			if(num >= limit)
				break;
			//adds possible consecutive squares
			for(int j = i + 2; num < limit; j++)
			{
				if(isPal(num) && !set.contains(num))
				{
					set.add(num);
					sum += num;
				}
				num += j*j;
			}
		}
		return sum;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(100000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
