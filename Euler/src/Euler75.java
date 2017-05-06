public class Euler75 
{	
	public static int p(int m, int n)
	{
		return 2 * m * (m + n);
	}
	public static int solve(int num)
	{
		int[] a = new int[num];
		for(int m = 2; m < 865; m++)
		{
			for(int n = 1; n < m; n++)
			{
				int p = p(m,n);
				if(p >= a.length)
					break;
				if((m - n) % 2 == 0 || Methods.gcd(m, n) > 1)
					continue;
				
				for(int k = 1; p*k < a.length; k++)
					a[p * k]++;
			}
		}
		return Methods.count(a, 1);
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1500000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
