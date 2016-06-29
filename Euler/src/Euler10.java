import java.util.*;
public class Euler10 
{
	public static long solve()
	{
		ArrayList<Integer> sieve = Methods.sieve(2000000);
		long sum = 0;
		for(Integer i: sieve)
		{
			sum += i;
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		long x = solve();
		System.out.println(x);
	}
	
}
