import java.util.*;
public class Euler95 
{
	public static int divisors(int num)
	{
		int sum = 0;
		for(int i = 1; i <= Math.sqrt(num); i++)
		{
			if(num % i == 0)
				sum += i;
			if(num % i == 0 && num/i != i)
				sum += num / i;
		}
		return sum;
	}
	public static int Aliquot(int num)
	{
		int check = num;
		int chain = 0;
		boolean found = false;
		Set aliquot = new HashSet();
		while(aliquot.add(num))
		{
			chain++;
			num = divisors(num) - num;
			if(num == check)
				found = true;
		}
		if(found)
			return chain;
		return 0;
	}
	public static int solve()
	{
		int chain = 0;
		int ans = 0;
		for(int i = 1; i < 100000; i++)
		{
			int aliquot = Aliquot(i);
			if(aliquot > chain)
			{
				chain = aliquot;
				ans = i;
			}
		}
		System.out.println(ans + " had a chain of " + chain + " numbers");
		return chain;
	}
	
	public static void main(String[] args)
	{
		System.out.println(Aliquot(220));
		System.out.println(solve());
	}
}
