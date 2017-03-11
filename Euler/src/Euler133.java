import java.util.*;
public class Euler133 
{
	public static int orderPrime(int p)
	{
		if(p % 3 == 0)
			p *= 9;
		int totient = p -1;
		ArrayList<Integer> factors = Methods.divisors(totient);
		for(int i = 0; i < factors.size() - 1; i++)
		{
			int num = 10;
			int f = factors.get(i);
			for(int j = 2; j <= f; j++)
				num = (num * 10) % p;
			
			if(num == 1)
				return f;
		}
		return totient;
	}
	public static boolean check(int num)
	{
		if(num == 2 || num == 5)
			return false;
		int order = orderPrime(num);
		while((order & 1) == 0)
			order >>= 1;
		while(order % 5 == 0)
			order /= 5;
		return order == 1;
	}
	
	public static long solve(int limit)
	{
		ArrayList<Integer> primes = Methods.sieve(limit);
		long sum = 0;
		//int check = 0;
		for(int p: primes)
		{
			//check += p;
			if(!check(p))
			{
				//System.out.println(p);
				sum += p;
			}
		}
		//System.out.println(check);
		return sum;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(100000));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
