import java.util.*;

public class Euler92 
{
	public static int sumDigits(int num)
	{
		int[] a = Methods.toArray(num);
		int sum = 0;
		
		for(int i: a)
		{
			sum += i * i;
		}
		return sum;
	}
	
	public static int solve()
	{
		boolean[] a = new boolean[10000000];
		Arrays.fill(a, false);
		a[89] = true;
		for(int i = 2; i < a.length; i++)
		{
			ArrayList<Integer> sequence = new ArrayList<Integer>();
			int num = i;
			while(num != 1)
			{
				if(a[num])
				{
					for(int link: sequence)
						a[link] = true;
					break;
				}
				sequence.add(num);
				num = sumDigits(num);
				if(num < 0)
				{
					return -1;
				}
			}
		}
		return Methods.count(a, true);
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
