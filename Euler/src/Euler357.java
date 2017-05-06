import java.math.BigInteger;
import java.util.*;
public class Euler357 
{
	public static boolean check(long num)
	{
		int sqrt = (int)Math.sqrt(num);
		for(int i = 2; i <= sqrt; i++)
		{
			if(num % i == 0)
				if(num % (i*i) == 0 || !Methods.checkPrime(i + num/i))
					return false;
		}
		return true;
	}
	
	public static long solve(int limit)
	{
		long sum = 0;
		ArrayList<Integer> sieve = Methods.sieve(limit);
		for(Integer i: sieve)
		{
			//System.out.println(i-1);
			if(check(i-1))
				sum += i-1;
		}
		return sum;
	}
	
	public static long integratedSieve(int limit)
	{
		long sum = 0;
		boolean[] a = new boolean[limit + 1];
		a[0] = true;
		a[1] = true;
		int sqrt = (int)Math.sqrt(limit);
		
		for(int i = 2; i <= sqrt; i++)
			for(int j = 2 * i; j < a.length; j += i)
				a[j] = true;
		
		for(int i = 2; i < a.length; i++)
			if(!a[i])
				if(check(i-1))
					sum += i-1;

		return sum;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(integratedSieve(100000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
