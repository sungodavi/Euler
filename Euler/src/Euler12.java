
public class Euler12 
{
	public static int findFactors(long num)
	{
		int counter = 0;
		for(int x=1; x*x<=num; x++)
		{
			if(num% x == 0)
			{
				counter +=2;
			}
		}
		return counter;
	}
	
	public static long solve(int input)
	{
		int counter = 0, triangle = 2;
		long num = 1;
		while(counter < input)
		{
			counter = findFactors(num);
			num += triangle;
			triangle ++;
		}
		return num-triangle+1;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(500));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
	
}
