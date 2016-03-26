
public class Euler21 
{
	public static int counter = 0;
	public static int checkNumber(int num)
	{
		int sum = 0;
		for(int x=1; x< num; x++)
		{
			if(num % x == 0)
				sum += x;
		}
		return sum;
	}
	
	public static boolean amicableNumbers(int x, int y)
	{
		if(checkNumber(x) == y & checkNumber(y) == x)
			return true;
		return false;
	}
	
	public static void Euler21(int num)
	{
		for(int a = 1; a < num; a++)
		{
			int b = checkNumber(a);
			if(a != b)
			{
				if(amicableNumbers(a, b))
				{
					//System.out.println(a + " " + b);
					counter += a + b;
				}
			}
		}
		counter /= 2;
	}
	
	public static void main(String[] args)
	{
		Euler21(10000);
		System.out.println(counter);
	}

}
