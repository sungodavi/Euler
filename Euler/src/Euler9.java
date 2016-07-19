
public class Euler9 
{
	public static boolean checkTriplet(int a, int b, int c)
	{
		return a*a + b*b == c*c;
	}
	
	public static boolean checkCondition(int a, int b, int c)
	{
		if(a + b + c == 1000)
			return true;
		return false;
	}
	
	public static int solve()
	{
		int c=13;
		while(c != 0)
		{
			for(int x=1; x<c; x++)
			{
				for(int y = x+1; y<c; y++)
				{
					if(checkTriplet(x,y,c))
					{
						if(checkCondition(x,y,c))
						{
							System.out.println(x);
							System.out.println(y);
							System.out.println(c);
							return x*y*c;
						}

					}
				}
			}
			c++;
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int x = solve();
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
