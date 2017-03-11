import java.util.*;

public class Euler50 
{
	public static int solve(int num)
	{
		int ans = 0;
		int ansCount = 0;
		ArrayList<Integer> list = Methods.sieve(num);
		for(int i = 0; i <= 10; i++)
		{
			int sum = 0;
			int count = 0;
			int j;
			for(j = i; sum < num; j++)
			{
				count++;
				sum += list.get(j);
				if(sum < num && Methods.checkPrime(sum) && ansCount < count)
				{
					ansCount = count;
					ans = sum;
				}
			}
			
		}
		System.out.println("Count: " + ansCount);
		return ans;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int x = 1000000;
		System.out.println(solve(x));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
