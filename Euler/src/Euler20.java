import java.math.BigInteger;


public class Euler20 
{
	public static BigInteger specialFactorial(int num)
	{
		BigInteger ans = new BigInteger("1");
		for(int x=1; x <= num; x++)
		{
			ans = ans.multiply(BigInteger.valueOf(x));
			//System.out.println(ans);
		}
		return ans;
	}
	
	public static long Euler20(int num)
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
		long x = Euler20(100);
		System.out.println(x);
	}

}
