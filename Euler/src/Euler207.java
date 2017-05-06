
public class Euler207 
{
	public static long solve(int numerator, int denominator)
	{
		long n = 1;
		long d = 1;
		long i;
		for(i = 3; n * denominator >= d * numerator; i++)
		{
			long num = i * (i-1);
			d++;
			if((i & (i-1)) == 0)
				n++;
		}
		return (i-1) * (i-2);
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1,12345));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime / 1000) + " seconds");
	}
}
