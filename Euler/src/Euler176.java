<<<<<<< HEAD
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
	
=======
public class Euler176 
{
	public static int countA(long len)
	{
		int count = 0;
		for(int k = 1; k <= len/2; k++)
		{
			if(len % k == 0)
			{
				long temp = len / k;
				for(int j = 1; j <= Math.sqrt(temp); j++)
				{
					if(temp % j == 0 && (j + temp/j) % 2 == 0)
					{
						long m = (temp/j + j) / 2;
						long n = m - j;

						if((m + n) % 2 != 0)
							count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int countB(long len)
	{
		len /= 2;
		int count = 0;
		for(int k = 1; k <= len/2; k++)
		{
			if(len % k == 0)
			{
				long temp = len/k;
				for(int j = 1; j <= Math.sqrt(temp); j++)
				{
					if(temp % j == 0 && (j + temp / j) % 2 != 0)
					{
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static long solve(int limit)
	{
		long len = 12;
		while(countA(len) + countB(len) != limit)
		{
			System.out.println(len);
			len++;
		}
		return len;
	}
	public static void main(String[] args)
	{
		System.out.println(solve(47547));
	}
>>>>>>> branch 'master' of https://github.com/sungodavi/Euler.git
}
