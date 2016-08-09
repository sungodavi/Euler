import java.util.*;
import java.math.BigInteger;
public class Euler132 
{
	public static int solve(int limit)
	{
		ArrayList<Integer> sieve = Methods.sieve(200000);
		int index = 2;
		int count = 0;
		int sum = 0;
		BigInteger exp = BigInteger.TEN.pow(limit);
		BigInteger num = BigInteger.TEN;
		while(count < 40)
		{
			int p = sieve.get(index);
			if(num.modPow(exp, BigInteger.valueOf(p)).equals(BigInteger.ONE))
			{
				System.out.println(p);
				sum += p;
				count++;
			}
			index++;
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(9));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
