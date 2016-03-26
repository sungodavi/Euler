import java.util.Arrays;


public class Euler52 
{
	public static long[] getDigits(long num)
	{
		long[] ans = new long[(int)Math.log10(num) + 1];
		for(int x = 0; x < ans.length; x++)
		{
			ans[x] = (long) (num % 10);
			num /= 10;	
		}
		Arrays.sort(ans);
		return ans;
	}
	public static long solve()
	{
		long num = 1;
		while(true)
		{
			if(Arrays.equals(getDigits(num), getDigits(num * 2))  &&
				Arrays.equals(getDigits(num), getDigits(num * 3)) && 
				Arrays.equals(getDigits(num), getDigits(num * 4)) &&
				Arrays.equals(getDigits(num), getDigits(num * 5)) &&
				Arrays.equals(getDigits(num), getDigits(num * 6)))
				return num;
			num++;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve());
	}

}
