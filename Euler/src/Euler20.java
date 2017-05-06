import java.math.BigInteger;


public class Euler20 
{
	public static BigInteger specialFactorial(int num)
	{
		BigInteger ans = BigInteger.ONE;
		for(int x = 2; x <= num; x++)
			ans = ans.multiply(BigInteger.valueOf(x));
		
		return ans;
	}
	
	public static int solve(int num)
	{
		BigInteger x = specialFactorial(num);
		int ans =0;
		while(x.compareTo(BigInteger.ZERO) == 1)
		{
			ans += x.mod(BigInteger.TEN).intValue();
			x = x.divide(BigInteger.TEN);
		}
		return ans;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int x = solve(100);
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
