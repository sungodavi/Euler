import java.util.Arrays;

public class Euler114 
{
	public static long solve(int size)
	{
		if(size < 3)
			return 1;
		long[] a = new long[size + 1];
		for(int i = 0; i <= size; i++)
			a[i] = 1;
		for(int i = 3; i <= size; i++)
		{
			for(int j = 3; j <= i; j++)
			{
				for(int k = j; k <= i; k++)
				{
					if(k == i)
						a[i]++;
					else
						a[i] += a[i-k-1];
				}
			}
		}
		return a[size];
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(50));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
	
}
