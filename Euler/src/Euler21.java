import java.util.*;
public class Euler21 
{
	public static int counter = 0;
	public static int sumOfDivisors(int num)
	{
		int sum = 1;
		for(int x = 2; x <= Math.sqrt(num); x++)
		{
			if(num % x == 0)
			{
				if(num / x != x)
					sum += num/x;
				sum += x;
			}
		}
		return sum;
	}
	
	public static int sum2(int num)
	{
		int temp = num;
		ArrayList<Integer> primes = Methods.sieve(num);
		int sum = 1;
		int index = 0;
		while(num > 1)
		{
			int p = primes.get(index);
			int exp = 0;
			while(num % p == 0)
			{
				num /= p;
				exp++;
			}
			sum *= ((int)Math.pow(p, exp + 1) - 1) / (p - 1);
			index++;
		}
		return sum - temp;
	}
	
	public static boolean amicableNumbers(int x)
	{
		int y = sumOfDivisors(x);
		return x != y && sumOfDivisors(x) == y && sumOfDivisors(y) == x;
	}
	
	public static void solve(int num)
	{
		for(int a = 1; a < num; a++)
			if(amicableNumbers(a))
				counter += a;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		solve(10000);
		System.out.println(counter);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
