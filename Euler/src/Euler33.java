import java.util.Arrays;


public class Euler33 
{
	public static int[] getDigits(long num)
	{
		int[] ans = new int[4];
		for(int x = 0; x < ans.length; x++)
		{
			ans[x] = (int) (num % 10);
			num /= 10;	
		}
		Arrays.sort(ans);
		return ans;
	}
	public static long concat(int a, int b)
	{
		String temp = "" + a + b;
		return Integer.parseInt(temp, 10);
	}
	
	public static int common(int[] array)
	{
		for(int x = 0; x < array.length - 1; x++)
		{
			if(array[x] == array[x+1])
				return array[x];
		}
		return 123;
	}
	
	public static void main(String[] args)
	{
		System.out.println(common(getDigits(concat(49,98))));
	}

}
