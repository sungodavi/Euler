
public class Euler138 
{
	public static long checkUp(long b)
	{
		long num = 5*b*b + 4;
		//System.out.println(num);
		long sum = 0;
		if(Methods.isPerfectSquare(num + 8*b))
		{
			long sqrt = (long)Math.sqrt(num + 8*b);
			//System.out.println(sqrt);
			if(sqrt % 2 == 0)
				sum += sqrt/2;
		}
		
		return sum;
	}
	
	public static long checkDown(long b)
	{
		long num = 5*b*b + 4;
		long sum = 0;
		if(Methods.isPerfectSquare(num - 8*b))
		{
			long sqrt = (long)Math.sqrt(num - 8*b);
			if(sqrt % 2 == 0)
				sum += sqrt/2;
		}
		return sum;
	}
	public static boolean debug(long b, long l)
	{
		return l*l - b*b/4 == (b+1)*(b+1) || l*l - b*b/4 == (b-1)*(b-1);
	}
	public static long solve(int limit)
	{
		int count = 0;
		long b = 16;
		long sum = 0;
		while(count < limit)
		{
			long l = checkUp(b);
			if(l > 0)
			{
				count++;
				System.out.println("1: " + b + " " + l + " " + debug(b,l));
				sum += l;
			}
			l = checkDown(b);
			if(l > 0)
			{
				count++;
				System.out.println("2: " + b + " " + l + " " + debug(b,l));
				sum += l;
			}
			b += 2;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		//System.out.println(checkUp(71976));
		System.out.println(solve(12));
	}
	
}
