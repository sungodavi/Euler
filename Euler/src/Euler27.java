import java.util.ArrayList;
import java.util.Arrays;


public class Euler27 
{
	public static boolean checkPrime(long num)
	{
		if(num == 1 || num == 2)
			return true;
		if(num % 2 == 0)
			return false;
		for(int x=3; x <= Math.sqrt(num); x += 2)
		{
			if(num % x == 0)
				return false;
		}
		return true;
	}
	
	public static boolean check(int num, int a, int b)
	{
		if(checkPrime(num * num + num * a + b) && (num * num + num * a + b) > 1)
		{
			return true;
		}
		return false;
	}
	
	public static int[] sieve(int num)
	{
		boolean ans[] = new boolean[num + 1];
		Arrays.fill(ans, true);
		ans[0] = false;
		ans[1] = false;
		for(int i = 2; i<= Math.ceil(Math.sqrt(num)); i++)
		{
			for(int j = i*2; j <= num; j += i)
			{
				ans[j] = false;
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int x=0; x < ans.length; x++)
		{
			if(ans[x])
				primes.add(x);
		}
		
		int[] array = new int[primes.size()];
		for(int x=0; x < array.length; x++)
		{
			array[x] = primes.get(x);
		}
		return array;
	}
	
	public static int Euler27()
	{
		int[] array = sieve(1000);
		int[] count = new int[3];
		for(int a = -999; a < 1000; a++)
		{
			for(int b : array)
			{
				//System.out.println(b);
				int n = 0;
				
				while(check(n,a,b))
				{
					n ++;
					//System.out.println(n + " " + a + " " + b);
				}
				
				if(n > count[2])
				{
					count[0] = a;
					count[1] = b;
					count[2] = n;
				}
					
			}
		}
		System.out.println(count[0] + " " + count[1] + " " + count[2]);
		return count[0] * count[1];
	}
	
	public static void main(String[] args)
	{
		int x = Euler27();
		System.out.println(x);
	}

}
