
public class Euler34 
{
	public static int getDigits(int num)
	{
		//int temp = num;
		int ans = 0;
		int digits = (int)(Math.log10(num)) + 1;
		for(int x=0; x < digits; x++)
		{
			ans += factorial(num % 10);
			num /= 10;
		}
		//System.out.println(ans + " " + temp);
		return ans;
	}
	
	public static int factorial(int num)
	{
		int ans = 1;
		for(int x=2; x <= num; x++)
		{
			ans *= x;
		}
		return ans;
	}
	
	public static long Euler34()
	{
		long sum = 0;
		for(int x = 3; x <= 100000; x++)
		{
			if(getDigits(x) == x)
			{
				//System.out.println(x);
				sum += x;
			}
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		long x = Euler34();
		System.out.println(x);
	}
}
