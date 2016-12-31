import java.util.ArrayList;

public class Euler46 
{
	public static int solve()
	{
		int x = 35;
		boolean found = false;
		while(true)
		{
			x+=2;
			if(Methods.checkPrime(x))
				continue;
			found = true;
			for(int i = 1; x - 2 * i * i > 2; i++)
			{
				if(Methods.checkPrime(x - 2 * i * i))
				{
					found = false;
					break;
				}
			}
			if(found)
				return x;
		}
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
