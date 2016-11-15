import java.math.BigInteger;

public class Euler94 
{
	public static boolean checkPlus(long a)
	{
		long h = (3 * a + 1)*(a - 1);
		return Methods.isPerfectSquare(h) && Math.sqrt(h)*(a+1) % 4 == 0;
	}
	public static boolean checkMinus(long a)
	{
		long h = (3 * a - 1) * (a + 1);
		return Methods.isPerfectSquare(h) && Math.sqrt(h)*(a-1) % 4 == 0;
	}
	public static long solve(int limit)
	{
		long sum = 0;
		for(int x = 3; x <= limit / 3 + 1; x += 2)
		{
			if(checkPlus(x))
				sum += (3*x + 1);
			if((3*x - 1 < limit) && checkMinus(x))
				sum += (3*x - 1);
		}
		return sum;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1000000000));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
