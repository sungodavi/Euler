
public class Euler34 
{
	public static int sumFact(int num)
	{
		int ans = 0;
		while(num > 0)
		{
			ans += Methods.fact(num % 10);
			num /= 10;
		}
		return ans;
	}
	public static long solve()
	{
		long sum = 0;
		
		for(int x = 3; x <= 100000; x++)
			if(sumFact(x) == x)
				sum += x;
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long x = solve();
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
