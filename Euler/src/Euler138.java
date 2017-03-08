import java.math.BigInteger;
import java.util.ArrayList;
public class Euler138 
{
	public static long recurse(int bUp, int lUp, int bDown, int lDown, int limit)
	{
		long x0 = 0,x1 = bUp,y1 = lUp,y0 = 0;
		long X1, X0 = bDown, Y1, Y0 = lDown;
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(Y1);
		list.add(y1);
		for(int i = 1; i <= limit/2 - 1; i++)
		{
			long temp1 = x1;
			long temp2 = y1;
			x1 = -9 * x0 -4 * y0 - 8;
			y1 = -20 * x0 - 9 * y0 - 16;
			x0 = temp1;
			y0 = temp2;
			
			temp1 = X1;
			temp2 = Y1;
			X1 = -9 * X0 -4 * Y0 - 8;
			Y1 = -20 * X0 - 9 * Y0 - 16;
			X0 = temp1;
			Y0 = temp2;
			list.add(Y1);
			list.add(y1);
		}
	}
	public static long checkUp(long b)
	{
		BigInteger B = BigInteger.valueOf(b);
		BigInteger num = BigInteger.valueOf(5).multiply(B).multiply(B).add(BigInteger.valueOf(4));
		//System.out.println(num);
		long sum = 0;
		if(Methods.isPerfectSquare(num.add(BigInteger.valueOf(8).multiply(B))))
		{
			BigInteger sqrt = Methods.sqrt(num.add(BigInteger.valueOf(8).multiply(B)));
			//System.out.println(sqrt);
			if(sqrt.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
				sum += sqrt.longValue()/2;
		}
		return sum;
	}
	
	public static long checkDown(long b)
	{
		BigInteger B = BigInteger.valueOf(b);
		BigInteger num = BigInteger.valueOf(5).multiply(B).multiply(B).add(BigInteger.valueOf(4));
		//System.out.println(num);
		long sum = 0;
		if(Methods.isPerfectSquare(num.subtract(BigInteger.valueOf(8).multiply(B))))
		{
			BigInteger sqrt = Methods.sqrt(num.subtract(BigInteger.valueOf(8).multiply(B)));
			//System.out.println(sqrt);
			if(sqrt.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
				sum += sqrt.longValue()/2;
		}
		return sum;
	}
	
	public static long findL(long b)
	{
		if(b % 4 != 0)
			return 0;
		long tempB = b / 4;
		for(int i = 1; i <= Math.sqrt(tempB); i++)
		{
			if(tempB % i == 0)
			{
				if((i + tempB/i) % 2 != 0)
				{
					long factor = tempB / i;
					if(Math.abs(factor * factor - i*i - b) == 1)
					{
						System.out.println(i + " " + factor);
						return i*i + factor * factor;
					}
				}
			}
		}
		return 0;
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
			long l = findL(b);
			//System.out.println(b);
			if(l != 0)
			{
				count++;
				System.out.println(b + " " + l + " " + debug(b,l));
				sum += l;
			}
			b += 4;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		//System.out.println(checkUp(71976));
		System.out.println(solve(12));
		//System.out.println(findL(28284464));
	}
	
}
