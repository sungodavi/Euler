
public class Euler30 
{	
	public static boolean check(int num)
	{
		int[] digits = Methods.toArray(num);
		int ans = 0;
		for(int x = 0; x < digits.length; x++)
		{
			ans += digits[x] * digits[x] * digits[x] * digits[x] * digits[x];
		}
		return ans == num;
	}
	
	public static int solve()
	{
		int ans = 0;
		for(int x = 4150; x <= 355000; x++)
		{
			if(check(x))
			{
				ans += x;
			}
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int x = solve();
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
