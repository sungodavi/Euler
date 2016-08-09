
public class Euler19 
{
	public static int day = 1;
	public static int counter = 0;
	
	public static void add(int num)
	{
		day += num;
		if(day >= 7)
		{
			day %= 7;
		}
	}
	
	public static void solve()
	{
		for(int x=1901; x<=2000; x++)
			for(int d=1; d<=12; d++)
			{
				add(31);
				if(day == 0)
				{
					counter ++;
				}
			
			}
		counter--;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		solve();
		System.out.println(counter);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
