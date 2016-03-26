import java.util.Arrays;


public class Euler5 
{
	public static int gcd(int a, int b)
	{
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
	public static int[] sieve(int num)
	{
		boolean[] ans = new boolean[num + 2];
		//set all values to true
		for(int n=2; n<num; n++)
		{
			ans[n] = true;
		}
		
		//finding prime numbers by removing multiples of primes
		for(int x=2; x<Math.sqrt(num); x++)
		{
			for(int y = x * 2; y <= num; y += x)
			{
				ans[y] = false;
			}
		}
		int[] sieve = new int[0];
		for(int x=2; x<= num; x++)
		{
			if(ans[x])
				sieve = addElement(sieve, x);
		}
		return sieve;
		
	}
	static int[] addElement(int[] a, int e) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = e;
	    return a;
	}
	public static int findMultiple(int num)
	{
		int ans = 1;
		int[] factors = sieve(num);
		for(int x=0; x<factors.length; x++)
		{
			ans *= factors[x];
		}
		for(int x=4; x<=num; x++)
		{
			if(ans % x != 0)
			{
				for(int y=0; y< factors.length; y++)
				{
					ans /= gcd(ans, x);
				}
				ans *= x;

			}
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		int x  = findMultiple(20);
		System.out.println(x);
	}
}
