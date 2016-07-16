import java.util.*;
public class Euler3 
{
	
	public static int solve(long num)
	{
		int largestFactor = 1;
		while(num % 2 == 0)
		{
			num /= 2;
			largestFactor = 2;
		}

		
		int count = 3;
		while(num != 1)
		{
			while(num % count == 0)
			{
				num /= count;
				largestFactor = count;
			}

			count += 2;
		}
		return largestFactor;
	}
	
	public static int solve2(long num)
	{
		ArrayList<Integer> sieve = Methods.sieve((int)Math.sqrt(num));
		int index = sieve.size() - 1;
		while(true)
		{
			if(num % sieve.get(index) == 0)
				return sieve.get(index);
			index--;
		}
	}
	
	public static void main(String args[])
	{
		long startTime = System.currentTimeMillis();
		long input = 600851475143L;
		int output = solve(input);
		System.out.println(output);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}


}
