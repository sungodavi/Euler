import java.util.Arrays;
public class Euler148 
{
	public static long[] factors;
	public static long countFactor(int num, int factor)
	{
		long sum = 0;
		for(int i = factor; i <= num; i *= factor)
		{
			sum += num / i;
		}
		return sum;
	}
	public static boolean checkNum(int n, int r, int factor)
	{
		if(factors[n] == -1)
			factors[n] = countFactor(n, factor);
		if(factors[r] == -1)
			factors[r] = countFactor(r, factor);
		if(factors[n-r] == -1)
			factors[n-r] = countFactor(n-r, factor);
		return factors[n] > factors[r] + factors[n-r];
	}
	public static int count(int row)
	{
		int count = 0;
		factors = new long[row];
		Arrays.fill(factors,-1);
		for(int n = 0; n <= row - 1; n++)
		{
			System.out.println(n);
			for(int r = 0; r <= n; r++)
			{
				if(!checkNum(n,r,7))
					count++;
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		System.out.println(count(1000000000));
	}
}
