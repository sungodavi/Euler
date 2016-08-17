import java.util.Arrays;

public class Euler117 
{
	public static long solve(int size)
	{
		long[] a = new long[size + 1];
		for(int i = 0; i < a.length; i++)
		{
			a[i] = 1;
		}
		for(int i = 2; i <= size; i++)
		{
			for(int j = 2; j <= i; j++)
				a[i] += a[i-j];
			for(int j = 3; j <= i; j++)
			{
				a[i] += a[i-j];
			}
			for(int j = 4; j <= i; j++)
			{
				a[i] += a[i-j];
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
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
