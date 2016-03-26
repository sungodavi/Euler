
public class Euler30 
{
	
	public static int[] digits(int num)
	{
		int[] array = new int[(int)(Math.log10(num) + 1)];
		for(int x = 0; x < array.length; x++)
		{
			array[x] = num % 10;
			num /= 10;
		}
		
		return array;
	}
	
	public static boolean check(int num)
	{
		int[] digits = digits(num);
		int ans = 0;
		for(int x = 0; x < digits.length; x++)
		{
			//System.out.println(digits[x]);
			ans += digits[x] * digits[x] * digits[x] * digits[x] * digits[x];
			//System.out.println(ans);
		}
		//System.out.println();
		if(ans == num)
			return true;
		return false;
	}
	
	public static int Euler30()
	{
		int ans = 0;
		for(int x=4150; x <= 355000; x++)
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
		int x = Euler30();
		System.out.println(x);		
	}

}
