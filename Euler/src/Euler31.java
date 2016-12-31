
public class Euler31 
{
	public static int bruteForce()
	{
		int count = 0;
		for(int l200 = 0; l200 <= 1; l200++)
			for(int l100 = 0; l100 <= 2; l100 ++)
				for(int l50 = 0; l50 <= 4; l50 ++)
					for(int l20 = 0; l20 <= 10; l20++)
						for(int l10 = 0; l10 <= 20; l10++)
							for(int l5 = 0; l5 <= 40; l5++)
								for(int l2 = 0; l2 <= 100; l2 ++)
									for(int l1 = 0; l1 <= 200; l1 ++)
										if(200 * l200 + 100 * l100 + 50 * l50 + 
												20 * l20 + 10 * l10 + 5 * l5 + 2 * l2 + l1 == 200)
											count++;
		return count;
	}
	
	public static int solve()
	{
		int[] a = new int[201];
		int[] values = {1,2,5,10,20,50,100,200};
		a[0] = 1;
		for(int v: values)
		{
			for(int i = v; i < a.length; i++)
			{
				a[i] += a[i-v];
			}
		}
		return a[200];
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
