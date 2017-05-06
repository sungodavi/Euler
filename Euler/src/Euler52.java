import java.util.Arrays;


public class Euler52 
{
	public static int[] getDigits(long num)
	{
		int[] ans = Methods.toArray(num);
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
