import java.util.*;
public class Euler69 
{
	public static ArrayList<Integer> sieve = Methods.sieve(1000000);
	public static int totient(int num)
	{
		double ans = num;
		for(int i = 0; sieve.get(i) <= num/2; i++)
		{
			int temp = sieve.get(i);
			if(num % temp == 0)
			{
				ans *= temp-1;
				ans /= temp;
			}
		}
		
		return (int)ans;
	}
	
	public static void main(String[] args)
	{
		double phi = 0;
		int ans = 0;
		for(int i = 1; i <= 1000000; i++)
		{
			int totient = totient(i);
			if(1.0 * i / totient > phi)
			{
				ans = i;
				phi = 1.0 * i / totient;
			}
		}
		
		System.out.println("n = " + ans + " produced the maximum n/phi(n): " + phi);
	}
}
