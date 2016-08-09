import java.util.*;
public class Euler381 
{
	public static long modFact(int num, int mod)
	{
		long ans = 1;
		for(int i = 2; i <= num; i++)
		{
			if(ans == 0)
				break;
			ans = (ans*i)% mod;
		}
		return ans;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		ArrayList<Integer> sieve = Methods.sieve(6,10000000);
		long sum = 4;
		for(Integer i: sieve)
		{
			sum += modFact(i-5,i)*9%i;
		}
		System.out.println(sum);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
