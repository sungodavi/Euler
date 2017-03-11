
public class Euler135 
{
	public static int solve(int limit)
	{
		int[] solutions = new int[limit + 1];
		for(int x = 1; x <= limit; x++)
		{
			for(int y = 1; x*y <= limit; y++)
			{
				if((x+y) % 4 == 0)
					if(3 * y > x && (3*y - x) % 4 == 0)
						solutions[x*y]++;
			}
		}
		
		return Methods.count(solutions, 10);
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
