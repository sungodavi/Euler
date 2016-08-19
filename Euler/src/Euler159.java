import java.util.*;
class Exponent
{
	public int base;
	public int exp;
	public Exponent(int b, int e)
	{
		base = b;
		exp = e;
	}
	public String toString()
	{
		return base + " ^ " + exp;
	}
}
public class Euler159 
{
	public static ArrayList<Exponent> factorize(int num)
	{
		ArrayList<Integer> sieve = Methods.sieve(num);
		ArrayList<Exponent> factors = new ArrayList<Exponent>();
		for(int i = 0; num > 1; i++)
		{
			int prime = sieve.get(i);
			if(num % prime == 0)
			{
				int pow = 0;
				while(num % prime == 0)
				{
					pow++;
					num /= prime;
				}
				factors.add(new Exponent(prime,pow));
			}
		}
		return factors;
	}
	
	public static int DR(int num)
	{
		while(num < 10)
		{
			int[] a = Methods.toArray(num);
			int temp = 0;
			for(int i: a)
			{
				temp += i;
			}
			num = temp;
		}
		return num;
	}
	
	public static int DRS(int num)
	{
		ArrayList<Exponent> factors = factorize(num);
		int totalFactors = 0;
		for(Exponent pow: factors)
			totalFactors += pow.exp;
		for(int i = 1; i <= totalFactors; i++)
		{
			
		}
	}
	public static void main(String[] args)
	{
		ArrayList<Exponent> x = factorize(5880);
		for(Exponent pow: x)
		{
			System.out.println(pow);
		}
	}
}
