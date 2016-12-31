import java.util.*;
import java.math.*;
public class Euler157 
{
	public static ArrayList<Integer> sieve;
	public static int countDivisors(BigInteger num)
	{
		int ans = 1;
		int index = 0;
		while(num.compareTo(BigInteger.ONE) > 0)
		{
			int prime = sieve.get(index);
			int exp = 0;
			while(num.mod(BigInteger.valueOf(prime)).equals(BigInteger.ZERO))
			{
				exp++;
				num = num.divide(BigInteger.valueOf(prime));
			}
			ans *= exp+1;
			index++;
		}
		return ans;
	}
	
	public static int countSolutions(int n)
	{
		int count = 0;
		BigInteger ten = BigInteger.TEN.pow(n);
		for(int a = 0; a <= n; a++)
		{
			for(int b = 0; b <= n; b++)
			{
				BigInteger n1 = BigInteger.valueOf(2).pow(a);
				BigInteger n2 = BigInteger.valueOf(5).pow(b);
				count += countDivisors((n1.multiply(n2).add(BigInteger.ONE)).multiply(ten).divide(n1.multiply(n2)));
				if(a == 0 || b == 0)
					continue;
				count += countDivisors((n1.add(n2)).multiply(ten).divide((n1.multiply(n2))));
			}
		}
		return count;
	}
	
	public static int solve()
	{
		int ans = 0;
		sieve = Methods.sieve(100000000);
		
		for(int n = 1; n <= 9; n++)
			ans += countSolutions(n);
		
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
