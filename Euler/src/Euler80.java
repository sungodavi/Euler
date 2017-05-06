import java.math.BigInteger;
public class Euler80 
{
	public static int sum(BigInteger num)
	{
		int ans = 0;
		while(num.compareTo(BigInteger.ZERO) > 0)
		{
			ans += num.mod(BigInteger.TEN).intValue();
			num = num.divide(BigInteger.TEN);
		}
		return ans;
	}
	
	public static int sqrtSum(int num)
	{
		if(Methods.isPerfectSquare(num))
			return 0;
		BigInteger root = BigInteger.ZERO;
		BigInteger dividend = BigInteger.valueOf(num);
		for(int i = 1; i <= 100; i++)
		{
			BigInteger x = (Methods.sqrt(root.multiply(root).multiply(BigInteger.valueOf(100)).add(dividend))).subtract(BigInteger.TEN.multiply(root));
			BigInteger y = x.multiply(root.multiply(BigInteger.valueOf(20)).add(x));
			dividend = dividend.subtract(y);
			root = BigInteger.TEN.multiply(root).add(x);
			dividend = BigInteger.valueOf(100).multiply(dividend);
		}
		return sum(root);
	}
	
	public static long solve()
	{
		long ans = 0;
		for(int i = 2; i < 100; i++)
		{
			ans += sqrtSum(i);
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
