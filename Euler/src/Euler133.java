import java.util.*;
public class Euler133 
{
	public static boolean checkLog(int num)
	{
		return Math.round(Math.log10(num)) == Math.log10(num);
	}
	
	public static boolean check(int num)
	{
		int[] a = {2,5};
		for(int p: a)
		{
			while(num % p == 0)
				num/=p;
		}
		return num == 1;
	}
	public static int solve(int limit)
	{
		ArrayList<Integer> sieve = Methods.sieve(limit);
		int sum = 0;
		for(Integer x: sieve)
		{
			if(!checkLog(x-1))
			{
				sum+=x;
			}
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		for(Integer x: Methods.sieve(100))
		{
			if(check(x - 1))
				System.out.println(x);
		}
	}
}
