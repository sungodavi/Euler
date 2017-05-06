public class Euler159
{
	public static int[] roots;
	public static int digitalRoot(int num)
	{
		int sum = 0;
		while(num > 0)
		{
			sum += num % 10;
			num /= 10;
		}
		if(sum >= 10)
			return digitalRoot(sum);
		return sum;
	}
	public static int DR(int num)
	{
		return num - (int)((num -1)/9)*9;
	}
	public static int recurse(int num)
	{
		//System.out.println(num);
		if(roots[num] > 0)
			return roots[num];
		int max = DR(num);
		if(Methods.checkPrime(num))
		{
			roots[num] = max;
			return max;
		}
		for(int i = 2; i <= Math.sqrt(num); i++)
		{
			if(num % i == 0)
			{
				max = Integer.max(max, recurse(i) + recurse(num/i));
			}
		}
		roots[num] = max;
		return max;
	}
	
	public static int sum(int limit)
	{
		roots = new int[limit + 1];
		int sum = 0;
		for(int i = 2; i < limit; i++)
		{
			sum += recurse(i);
		}
		return sum;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(sum(1000000));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}