
public class Euler146 
{
	public static boolean check(long n)
	{
		return Methods.checkPrime(n + 1) && 
				Methods.checkPrime(n + 3) && 
				Methods.checkPrime(n + 7) && 
				Methods.checkPrime(n + 9) && 
				Methods.checkPrime(n + 13) &&
				Methods.checkPrime(n + 27) &&
				!Methods.checkPrime(n + 21) &&
				!Methods.checkPrime(n + 19); 
	}
	public static boolean checkMods(long n)
	{
		return n*n % 3 == 1 && (n*n % 7 == 2 || n*n % 7 == 3) && !(n % 9 == 0 || n % 13 == 0 || n % 27 == 0);
	}
	public static long solve(int limit)
	{
		long sum = 10;
		for(long n = 20; n < limit; n += 10)
		{
			if(checkMods(n))
				if(check(n*n))
					sum += n;
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(150000000));
	}

}
