import java.util.ArrayList;
import java.util.Arrays;


public class Euler46 
{
	public static ArrayList<Integer> sieve(int num)
	{
		boolean[] ans = new boolean[num + 1];
		Arrays.fill(ans, true);
		ans[0] = false;
		ans[1] = false;
		for(int i = 2; i <= Math.sqrt(num); i++)
		{
			for(int j = 2 * i; j <= num; j+= i)
			{
				ans[j] = false;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int x = 0; x < ans.length; x++)
		{
			if(ans[x])
				list.add(x);
		}
		
		return list;
	}
	
	public static boolean checkPrime(int num)
	{
		if(num % 2 == 0)
			return false;
		for(int x = 3; x <= Math.sqrt(num); x += 2)
		{
			if(num % x == 0)
				return false;
		}
		return true;
	}
	public static int Euler46()
	{
		boolean check = false;
		int x = 3;
		ArrayList<Integer> primes = sieve(100000);
		while(!check)
		{
			if(x % 2 == 1 && !checkPrime(x))
			{
				outerloop:
				for(int a = 0; primes.get(a) < x; a++)
				{
					for(int b = 1; primes.get(a) + 2 * b * b <= x; b++)
						if(primes.get(a) + 2 * b * b == x)
						{
							System.out.println(x);
							x += 2;
							break outerloop;
						}
				}
			return x;
			}
			x += 2;
		}
		return 2;
	}
	
	public static void main(String[] args)
	{
		//System.out.println(checkPrime(11));
		System.out.println(Euler46());
	}
}
