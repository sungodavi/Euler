import java.util.*;
import java.math.BigInteger;
public class Euler160 
{
	public static int countFactors(int fact, int num)
	{
		int sum = 0;
		for(int i = num; i <= fact; i *= num)
		{
			sum += fact/i;
		}
		return sum;
	}
	
	public static BigInteger solve(int limit)
	{
		ArrayList<Integer> sieve = Methods.sieve(limit);
		int[] factors = new int[sieve.size()];
		BigInteger ans = BigInteger.ONE;
		
		for(int i = 0; i < factors.length; i++)
			factors[i] = countFactors(limit, sieve.get(i));
		int min = Integer.min(factors[0], factors[2]);
		factors[0] -= min;
		factors[2] -= min;
		for(int i = 0; i < factors.length; i++)
		{
			ans = ans.multiply(BigInteger.valueOf(sieve.get(i)).pow(factors[i]));
		}
		return ans.mod(BigInteger.TEN.pow(5));
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(Integer.MAX_VALUE/2));
	}
}
