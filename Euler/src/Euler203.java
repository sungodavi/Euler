import java.util.*;
import java.math.BigInteger;
public class Euler203 
{
	public static int countFactor(int fact, int num)
	{
		int sum = 0;
		for(int i = num; i <= fact; i *= num)
			sum += fact / i;
		
		return sum;
	}
	
	public static boolean checkSquareFree(int n, int r)
	{
		ArrayList<Integer> sieve = Methods.sieve(n);
		
		for(int prime: sieve)
			if(countFactor(n,prime) - countFactor(n-r,prime) - countFactor(r,prime) > 1)
				return false;
		
		return true;
	}
	
	public static BigInteger solve(int limit)
	{
		Set<BigInteger> SFNums = new HashSet<BigInteger>();
		
		for(int n = 1; n < limit; n++)
			for(int r = 1; r <= n; r++)
				if(checkSquareFree(n,r))
					SFNums.add(Methods.bigCombo(n, r));
			
		BigInteger sum = BigInteger.ZERO;
		for(BigInteger num: SFNums)
			sum = sum.add(num);
		
		return sum;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(50));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
