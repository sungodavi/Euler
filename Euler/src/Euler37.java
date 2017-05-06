
public class Euler37 
{
	public static int counter = 0;

	public static boolean checkTrunc(int num)
	{
		int digits = (int)(Math.log10(num)) + 1;
		int temp = num;
		int temp2 = num;
		for(int x = 1; x < digits; x++)
		{
			temp /= 10;
			temp2 %= Math.pow(10, digits - x);
			if(!Methods.checkPrime(temp) || !Methods.checkPrime(temp2))
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
			if(Methods.checkPrime(x))
			{
				if(checkTrunc(x))
				{
					counter ++;
					sum += x;
				}

			}
			x += 2;
		}
		return sum;
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
