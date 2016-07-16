import java.util.*;

public class Euler29 
{
	public static int solve()
	{
		Set<Double> set = new HashSet<Double>();
		for (int a = 2; a <= 100; a++)
		    for (int b = 2; b <= 100; b++) 
		    	set.add(Math.pow(a, b));
		
		return set.size();
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
