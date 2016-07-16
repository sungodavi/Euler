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
		long startTime = System.currentTimeMillis();
		long x = Fibonacci(new BigInteger("1"),new BigInteger("2"));
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
