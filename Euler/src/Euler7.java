import java.util.Arrays;

public class Euler7 
{
	public static boolean checkPrimes(long num)
	{
		if(num%2 == 0)
			return false;
		for(int x=3; x<=Math.ceil(Math.sqrt(num)); x += 2)
		{
			if(num % x == 0)
				return false;
		}
		return true;
	}
	
	public static long findPrime(int count)
	{
		int counter = 1; 
		long prime = 3;
		while(counter < count)
		{
			if(checkPrimes(prime))
			{
				counter++;
				System.out.println(counter);
			}
			prime += 2;
		}
		return prime -2;
	}
	public static void main(String[] args)
	{
		long x = findPrime(4000000);
		System.out.println(x);
	}

}
