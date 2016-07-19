import java.util.ArrayList;
import java.util.Arrays;


public class Euler27 
{
	public static boolean check(int num, int a, int b)
	{
		return Methods.checkPrime(num * num + num * a + b);
	}
	
	public static int solve()
	{
		ArrayList<Integer> sieve = Methods.sieve(1000);
		int[] max = new int[3];
		for(int a = -999; a < 1000; a++)
		{
			for(int b : sieve)
			{
				int n = 0;
				while(check(n,a,b))
				{
					n++;
				}
				
				if(n > max[2])
				{
					max[0] = a;
					max[1] = b;
					max[2] = n;
				}
					
			}
		}
		System.out.println("a: " + max[0] + ", b: " + max[1] + ", number of primes generated: " + max[2]);
		return max[0] * max[1];
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int x = solve();
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
