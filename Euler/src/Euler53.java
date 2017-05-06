import java.math.BigInteger;


public class Euler53 
{
	public static BigInteger combo(int n, int r)
	{
		BigInteger ans = BigInteger.ONE;
		int max = Integer.max(r, n-r);
		int min = Integer.min(r, n-r);
		for(int x = n; x > max; x--)
		{
			ans = ans.multiply(BigInteger.valueOf(x));
		}
		
		for(int x = 2; x <= min; x++)
		{
			ans = ans.divide(BigInteger.valueOf(x));
		}
		return ans;
	}
	
	public static int solve()
	{
		int count = 0;
		for(int x = 5; x <= 100; x++)
		{
			for(int i = 0; i <= x; i++)
			{
				if(combo(x,i).compareTo(new BigInteger(1000000 + "")) > 0)
				{
					System.out.println(x + " choose " + i + " = " + combo(x,i));
					count ++;
				}
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		System.out.println(solve());
	}
}
