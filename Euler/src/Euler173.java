
public class Euler173 
{
	public static int count(int size)
	{
		int count = 0;
		for(int i = 2; i <= Math.sqrt(size); i += 2)
			if(size % i == 0)
				if(size/i != i && (size/i) % 2 == 0)
					count++;
		return count;
	}
	
	public static long solve(int limit)
	{
		long count =0 ;
		for(int i = 8; i <= limit; i++)
			count += count(i);
		return count;
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
