import java.util.ArrayList;

public class Euler130 
{
	/**
	 * Uses Euler's Theorem to find the order of 10 (mod n)
	 */
	public static long findLength(int n)
	{
		if(n % 3 == 0)
			n *= 9;
		int totient = Methods.totient(n);
		ArrayList<Integer> factors = Methods.divisors(totient);
		for(int i = 0; i < factors.size() - 1; i++)
		{
			int num = 10;
			int f = factors.get(i);
			for(int j = 2; j <= f; j++)
				num = (num * 10) % n;
			
			if(num == 1)
				return f;
		}
		return totient;
	}
	public static void main(String[] args)
	{
		//Examples: 91, 259, 451, 481, and 703
		int[] examples = {91,259,451,481,703};
		for(int n: examples)
			System.out.println(Methods.totient(n) + " " + findLength(n));
		
	}
}
