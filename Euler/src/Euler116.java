import java.math.BigInteger;
public class Euler116 
{
	public static BigInteger choose(int n, int r)
	{
		int max;
		int min;
		BigInteger ans = BigInteger.ONE;
		
		if(r > n - r)
		{
			max = r;
			min = n-r;
		}
		else
		{
			max = n-r;
			min = r;
		}
		for(int i = n; i > max; i--)
			ans = ans.multiply(BigInteger.valueOf(i));
		for(int i = 2; i <= min; i++)
			ans = ans.divide(BigInteger.valueOf(i));
		
		return ans;
	}
	
	public static BigInteger solve(int size)
	{
		BigInteger sum = BigInteger.ZERO;
		for(int i = 2; i <= 4; i++)
			for(int j = 1; j <= size/i; j++)
				sum = sum.add(choose(size - j * (i-1),j));
		
		return sum;
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
