
public class Euler28 
{
	public static long solve()
	{
		long sum = 1;
		int temp = 0;
		for(int n = 2; n < 1001; n += 2)
		{
			for(int x=1; x<=4; x++)
			{
				sum += temp + n*x + 1;
			}
			temp += 4*n;
		}
		return sum;
	}
	public static void main(String args[])
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
