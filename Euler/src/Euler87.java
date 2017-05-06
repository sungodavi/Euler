import java.util.*;
public class Euler87 
{
	public static int solve(int limit)
	{
		ArrayList<Integer> sieve = Methods.sieve((int)Math.sqrt(limit));
		boolean[] a = new boolean[limit];
		Arrays.fill(a, false);
		
		for(long i: sieve)
			for(long j: sieve)
			{
				if(j*j*j + 24 >= limit)
					continue;
				for(long k: sieve)
				{
					long num = i*i*i*i + j*j*j + k*k;
					if(num < limit)
					{
						a[(int)num] = true;
					}
				}
			}
		return Methods.count(a, true);
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(50000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
