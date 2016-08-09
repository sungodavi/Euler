import java.math.BigInteger;


public class Euler20 
{
	public static BigInteger specialFactorial(int num)
	{
		BigInteger ans = new BigInteger("1");
		for(int x=1; x <= num; x++)
			ans = ans.multiply(BigInteger.valueOf(x));
		
		return ans;
	}
	
	public static long solve(int num)
	{
		BigInteger x = specialFactorial(num);
		long ans =0;
		while(x.compareTo(BigInteger.ZERO) == 1)
		{
			ans += x.mod(BigInteger.TEN).longValue();
			System.out.println(x);
			x = x.divide(BigInteger.TEN);
		}
		return ans;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long x = solve(100);
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
