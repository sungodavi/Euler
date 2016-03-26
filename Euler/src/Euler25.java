import java.math.BigInteger;


public class Euler25 
{
	public static long count = 2;
	public static BigInteger ans = new BigInteger("3");
	public static long Fibonacci(BigInteger x, BigInteger y)
	{
		System.out.println(x);
		if(check(x))
		{
			return count;
		}
		count ++;
		return Fibonacci(y, x.add(y));
	}
	
	public static boolean check(BigInteger x)
	{
		if(x.toString().length() >= 1000)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		long x = Fibonacci(new BigInteger("1"),new BigInteger("2"));
		System.out.println(x);
	}
}
