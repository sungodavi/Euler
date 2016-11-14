import java.util.*;
public class Euler214 
{
	public static int[] chains;
	public static int totient(int num)
	{
		int result = num;
		ArrayList<Integer> primes = Methods.sieve(num);
		int index = 0;
		while(num > 1)
		{
			int prime = primes.get(index);
			if(num % prime == 0)
				result = result / prime * (prime - 1);
			while(num % prime == 0)
				num /= prime;
			index++;
		}
		return result;
	}
	
	public static int chain(int num)
	{
		int count = 1;
		while(num != 1)
		{
			if(chains[num] > 0)
				return count + 1 + chains[num];
			count++;
			num = totient(num);
		}
		chains[num] = count;
		return count;
	}
	public static long solve(int limit, int len)
	{
		long sum = 0;
		chains = new int[limit];
		ArrayList<Integer> primes = Methods.sieve(limit);
		for(int p: primes)
		{
			System.out.println(p);
			if(chain(p) == len)
				sum += p;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		//System.out.println(chain(46349));
		
		System.out.println(solve(40000000,25));
	}
}
