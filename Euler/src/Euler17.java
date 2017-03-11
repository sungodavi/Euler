
public class Euler17 
{
	public static int[] ones = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4};
	public static int[] tens = {3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
	public static int[] tens2 = {6, 6, 5, 5, 5, 7, 6, 6};
	public static int hundred = 7;
	public static int thousand = 8;
	public static long counter = 0;
	
	public static int convert(int num)
	{
		int temp = num;
		int count = 0;
		while(temp > 0)
		{
			if(temp == 1000)
			{
				count += thousand;
				return count;
			}
			else if(temp > 100)
			{
				count += hundred + ones[temp/100] + 3;
				temp %= 100;
			}
			else if(temp == 100)
				return 7;
			else if(temp >= 20)
			{
				count += tens2[temp/10 -2];
				temp %= 10;
			}
			else if(temp >= 10)
			{
				count += tens[temp % 10];
				return count;
			}
			else
			{
				count += ones[temp];
				return count;
			}

		}
		return count;
	}
	
	public static long solve()
	{
		for(int x = 1; x <= 1000; x++)
			counter += convert(x);

		return counter;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
