public class Euler176 
{
	public static int countA(long len)
	{
		int count = 0;
		for(int k = 1; k <= len/2; k++)
		{
			if(len % k == 0)
			{
				long temp = len / k;
				for(int j = 1; j <= Math.sqrt(temp); j++)
				{
					if(temp % j == 0 && (j + temp/j) % 2 == 0)
					{
						long m = (temp/j + j) / 2;
						long n = m - j;

						if((m + n) % 2 != 0)
							count++;
					}
				}
			}
		}
		return count;
	}
	
	public static int countB(long len)
	{
		len /= 2;
		int count = 0;
		for(int k = 1; k <= len/2; k++)
		{
			if(len % k == 0)
			{
				long temp = len/k;
				for(int j = 1; j <= Math.sqrt(temp); j++)
				{
					if(temp % j == 0 && (j + temp / j) % 2 != 0)
					{
						count++;
					}
				}
			}
		}
		return count;
	}
	
	public static long solve(int limit)
	{
		long len = 12;
		while(countA(len) + countB(len) != limit)
		{
			System.out.println(len);
			len++;
		}
		return len;
	}
	public static void main(String[] args)
	{
		System.out.println(solve(47547));
	}
}
