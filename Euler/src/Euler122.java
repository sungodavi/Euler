import java.util.Arrays;

public class Euler122 
{
	public static long solve(int num)
	{
		long[] a = new long[num + 1];
		for(int i = 2; i <= num; i++)
		{
			long min = Long.MAX_VALUE;
			for(int j = i - 1; j >= 1.0 * i/2; j--)
			{
				if(i == 2 * j)
					min = Long.min(min, a[j] + 1);
				else
					min = Long.min(min, a[j] + a[i-j] + 1);
				System.out.println(i + " " + j + " " + min);
			}
			a[i] = min;
		}
		System.out.println(Arrays.toString(a));
		return a[num];
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(15));
	}
}
