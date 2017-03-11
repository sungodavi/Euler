public class Euler5 
{
	public static long lcm(long a,long b)
	{
		return a * b / Methods.gcd(a, b);
	}
	
	public static long solve(int num)
	{
		long ans = 1;
		for(int i = 2; i <= num; i++)
		{
			ans = lcm(ans,i);
		}
		return ans;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long x  = solve(20);
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
