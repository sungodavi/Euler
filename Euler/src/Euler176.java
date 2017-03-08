import java.util.*;
public class Euler176 
{
	public static Map<Integer,Integer> counts;
	public static int countA(int c)
	{
		int count = 0;
		for(int i = 1; i < Math.sqrt(c); i++)
		{
			if(c % i != 0)
				continue;
			int j = c/i;
			if((i + j) % 2 != 0)
				continue;
			int m = (i+j)/2;
			int n = (j - i)/2;
			if((m + n) % 2 == 0 || Methods.gcd(m, n) > 1)
				continue;
			//System.out.println(m + " " + n);
			count++;
		}
		return count;
	}
	public static int countB(int c)
	{
		if(c % 2 != 0)
			return 0;
		int count = 0;
		c /= 2;
		for(int i = 1; i < Math.sqrt(c); i++)
		{
			if(c % i != 0)
				continue;
			int j = c/i;
			if((i + j) % 2 == 0 || Methods.gcd(i,j) > 1)
				continue;
			//System.out.println(i + " " + j);
			count++;
		}
		return count;
	}
	public static int count(int num)
	{
		int count = countA(num) + countB(num);
		for(int i = 2; i <= Math.sqrt(num); i++)
		{
			if(num % i == 0)
			{
				count += counts.containsKey(i) ? counts.get(i) : 0;
				if(num != i*i)
					count += counts.containsKey(i) ? counts.get(num/i) : 0;
			}
		}
		counts.put(num, count);
		return count;
	}
	public static int solve(int limit)
	{
		counts = new HashMap<Integer,Integer>();
		int c = 3;
		while(count(c) != limit)
		{
			c++;
			System.out.println(c);
			if(c < 0)
				System.out.println("error");
		}
		return c;
	}
	public static void main(String[] args)
	{
		System.out.println(solve(47547));
		System.out.println(count(43200));
	}
	
}
