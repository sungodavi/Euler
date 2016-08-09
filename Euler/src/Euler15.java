
public class Euler15 
{
	public static long choose(int numerator, int denominator)
	{
		double ans =1;
		for(int x=numerator; x > denominator; x--)
		{
			
			ans *= x;
			if(numerator-denominator != 0)
				ans /= x-denominator;
		}
		return (long)(ans);
	}
	public static long solve(int size)
	{
		return choose(size*2, size);
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(20));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
