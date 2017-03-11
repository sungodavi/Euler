import java.util.ArrayList;
public class Euler134 
{
	public static int len(long num)
	{
		return (int)(Math.log10(num)) + 1;
	}
	public static long modInverse(long p1, long p2)
	{
		long q,r0 = p1,r1 = p2,s0 = 1,s1 = 0,t0 = 0,t1 = 1;
		while(r1 != 0)
		{
			q = r0 / r1;
			long temp = r1;
			r1 = r0 % r1;
			r0 = temp;
			
			temp = s0 - q*s1;
			s0 = s1;
			s1 = temp;
			
			temp = t0 - q*t1;
			t0 = t1;
			t1 = temp;
		}
		return s0;
	}
	
	public static long find(long p1, long p2)
	{
		int exp = (int)Math.pow(10, len(p1));
		return exp * ((p2 + modInverse(exp,p2)) * (p2 - p1) % p2) + p1;
	}
	
	public static long solve(int limit)
	{
		ArrayList<Integer> sieve = Methods.sieve(5, limit + 100);
		long sum = 0;
		for(int i = 0; i < sieve.size() - 1; i++)
		{
			if(sieve.get(i) >= limit)
				break;
			long num = find(sieve.get(i),sieve.get(i+1));
			if(num % sieve.get(i+1) != 0 || num < 0)
				System.out.println("error");
			sum += num;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
