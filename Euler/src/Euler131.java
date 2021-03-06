public class Euler131 
{
	public static boolean check(int x)
	{
		return Methods.checkPrime(3 * x * (x + 1) + 1);
	}
	
	public static int solve(int limit)
	{
		int count = 0;
		for(int i = 1; 3 * i * (i + 1) + 1 < limit; i++)
		{
			if(check(i))
				count++;
		}
		return count;
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
