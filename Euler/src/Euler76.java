import java.util.Arrays;

public class Euler76 
{
	public static int solve(int num)
	{
		int[] a = new int[num+1];
		a[0] = 1;
		for(int i = 1; i < a.length; i++)
		{
			for(int j = i; j < a.length; j++)
			{
				a[j] += a[j-i];
			}
		}
		return a[num];
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(100) - 1);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
