
import java.util.*;
public class Euler108 
{
	public static int countSquareDivisors(int num)
	{
		int count = 1;
		ArrayList<Integer> sieve = Methods.sieve(num);
		for(Integer i: sieve)
		{
			int exp = 0;
			while(num % i == 0)
			{
				exp++;
				num /= i;
			}
			count*= 2*exp+1;
		}
		return count;
	}
	public static int getSolutions(int n)
	{
		return (countSquareDivisors(n)+1)/2;
	}
	
	
	public static int solve()
	{
		int n = 4;
		int ans = 0;
		while(ans < 1000)
		{
			ans = getSolutions(n);
			System.out.println(n + " " + ans);
			n++;
		}
		return n - 1;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
