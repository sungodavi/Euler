import java.math.BigInteger;
public class Euler205 
{
	public static BigInteger combo(int n, int r)
	{
		BigInteger ans = BigInteger.ONE;
		int max = Integer.max(r, n-r);
		int min = Integer.min(n-r, r);
		for(int i = n; i > max; i--)
			ans = ans.multiply(BigInteger.valueOf(i));
		for(int i = min; i > 1; i--)
			ans = ans.divide(BigInteger.valueOf(i));
		return ans;
	}
	public static void main(String[] args)
	{
		BigInteger[] p = new BigInteger[37];
		BigInteger[] c = new BigInteger[37];
		System.out.println(combo(36,18));
		long total = (int)(Math.pow(4, 9) * Math.pow(6,6));
		for(int i = 9; i < p.length; i++)
			p[i] = combo(i-1,8);
		
		for(int i = 6; i < c.length; i++)
			c[i] = combo(i-1,5);
		
		BigInteger check = BigInteger.ZERO;
		for(int i = 9; i < p.length; i++)
		{
			check = check.add(p[i]);
		}
		System.out.println(check.equals(BigInteger.valueOf(4).pow(9)));
	}

}
