import java.util.*;
public class Euler243 
{
	public static ArrayList<Integer> sieve;
	public static long totient(long num)
	{
		if(sieve == null)
			return -1;
		int index = 0;
		long ans = num;
		while(num > 1)
		{
			int prime = sieve.get(index);
			if(num % prime == 0)
				ans = ans / prime * (prime-1);
			while(num % prime == 0)
				num /= prime;
			index++;
		}
		return ans;
	}
	
	public static int solve(int n, int d)
	{
		int num = 1;
		while(totient(num) * d >= (num - 1) * n)
			num++;
		return num;
	}
	public static void main(String[] args)
	{
		sieve = Methods.sieve(10000000);
		System.out.println("done");
		System.out.println(solve(15499,94744));
	}
}
