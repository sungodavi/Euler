import java.util.*;
public class Euler211 
{
	static ArrayList<Integer> sieve;
	public static int sumDivisors(int n)
	{
		int index = 0;
		int sum = 1;
		
		while(n > 1)
		{
			int prime = sieve.get(index);
			int e = 0;
			while(n % prime == 0)
			{
				e++;
				n /= prime;
			}
			sum *= (Math.pow(prime, 2*e+2) - 1)/(prime*prime - 1);
			index++;
		}
		return sum;
	}
	
	public static int check(int n)
	{
		int sum =0;
		for(int i = 1; i <= n; i++)
		{
			if(n % i == 0)
				sum += i*i;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		int limit = 64000000;
		sieve = Methods.sieve(limit);
		for(int i = 1; i <= 64000000; i++)
		{
			System.out.println(i);
			sumDivisors(i);
		}
	}
}
