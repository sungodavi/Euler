import java.util.*;
public class Euler23 
{
	public static boolean isAbundant(int num)
	{
		long ans = 1;
		for(int x=2; x <= Math.sqrt(num); x++)
		{
			if(num % x == 0)
			{
				if(num/x != x)
					ans += num/x;
				ans += x;
			}
		}
		return ans > num;
	}
	
	public static int solve()
	{
		int ans = 0;
		boolean[] a = new boolean[28124];
		Arrays.fill(a, false);
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		for(int i = 12; i <= 28123; i++)
		{
			if(isAbundant(i))
			{
				abundant.add(i);
				for(Integer j: abundant)
				{
					if(i + j <= 28123)
						a[i+j] = true;
				}
			}
		}
		
		for(int i = 0; i < a.length; i++)
		{
			if(!a[i])
				ans += i;
		}
		return ans;
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
