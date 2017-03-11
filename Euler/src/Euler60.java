import java.util.*;
public class Euler60 
{
	public static ArrayList<Integer> sieve;
	public static int current = Integer.MAX_VALUE;
	public static boolean checkConcat(int p1, int p2)
	{
		return Methods.checkPrime(Long.parseLong("" + p1 + p2)) && 
				Methods.checkPrime(Long.parseLong("" + p2 + p1));
	}
	
	public static boolean check(int[] primes)
	{
		for(int i = 0; i < primes.length - 1; i++)
		{
			for(int j = i+1; j < primes.length; j++)
			{
				if(!checkConcat(primes[i],primes[j]))
					return false;
			}
		}
		return true;
	}
	public static int sum(int[] a)
	{
		int sum =0;
		for(int n:a)
			sum += n;
		return sum;
	}
	public static int recurse(int[] primes,int start, int limit)
	{
		//System.out.println(Arrays.toString(primes) + " " + current);
		if(!check(primes))
			return Integer.MAX_VALUE;
		if(limit == primes.length)
		{
			int sum = sum(primes);
			current = Integer.min(current, sum);
			return sum;
		}
		int[] a = new int[primes.length + 1];
		for(int k =0; k < primes.length; k++)
		{
			a[k] = primes[k];
		}
		int min =Integer.MAX_VALUE;
		for(int i = start; i < sieve.size(); i++)
		{
			a[a.length - 1] = sieve.get(i);
			if(sum(a) + (limit - primes.length)*sieve.get(i) > current)
				break;
			int ans = recurse(a,i+1,limit);
			min = Integer.min(min, ans);
		}
		current = Integer.min(current, min);
		return min;
		
	}
	public static int solve(int limit)
	{
		int[] a = {};
		sieve = Methods.sieve(20000);
		return recurse(a,1,limit);
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(5));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}