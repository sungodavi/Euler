
public class Euler37 
{
	public static int counter = 0;
	public static boolean checkPrime(int num)
	{
		if(num == 1)
			return false;
		if(num > 2 && num % 2 == 0)
			return false;
		for(int x = 3; x <= Math.sqrt(num); x++)
		{
			if(num % x == 0)
				return false;
		}
		return true;
	}
	
	public static boolean checkTrunc(int num)
	{
		int digits = (int)(Math.log10(num)) + 1;
		int temp = num;
		int temp2 = num;
		for(int x = 1; x < digits; x++)
		{
			temp /= 10;
			temp2 %= Math.pow(10, digits - x);
			if(!checkPrime(temp) || !checkPrime(temp2))
				return false;
		}
		return true;
		
	}
	public static int solve()
	{
		int sum = 0;
		int x = 11;
		while(counter < 11)
		{
			if(checkPrime(x))
			{
				if(checkTrunc(x))
				{
					counter ++;
					sum += x;
				}

			}
			x+=2;
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		int x = solve();
		System.out.println(x);
	}
}
