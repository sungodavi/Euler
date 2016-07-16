
public class Euler4 
{
	public static boolean isPalindrome(int num)
	{
		int[] digits = Methods.toArray(num);
		int end = digits.length-1;
		for(int n = 0; n < digits.length / 2 + 1; n++)
		{
			if(digits[n] != digits[end-n])
				return false;
		}
			return true;
	}
	
	public static int solve()
	{
		int ans = 0;
		for(int x = 999; x >=100; x--)
		{
			for(int y = 999; y >= 100; y--)
			{
				if(isPalindrome(x*y) && x*y > ans)
					ans = x*y;
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
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
