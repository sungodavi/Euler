import java.math.BigInteger;

public class Euler148 
{
	public static BigInteger choose(int n, int r)
	{
		BigInteger ans = BigInteger.ONE;
		for(int i = n; i > Integer.max(r, n-r); i--)
		{
			ans = ans.multiply(BigInteger.valueOf(i));
		}
		for(int i = 2; i <= Integer.min(r, n-r); i++)
		{
			ans = ans.divide(BigInteger.valueOf(i));
		}
		return ans;
	}
	public static void main(String[] args)
	{
		for(int n = 0; n <= 1000000000; n++)
		{
			for(int r = 0; r <= n; r++)
			{
				choose(n,r).mod(BigInteger.valueOf(7));
			}
			System.out.println();
		}
	}
}
