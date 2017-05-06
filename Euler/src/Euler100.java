import java.math.BigInteger;

public class Euler100 
{
	public static boolean check(long total)
	{
		BigInteger num = BigInteger.valueOf(2).multiply(BigInteger.valueOf(total)).subtract(BigInteger.ONE);
		num = num.multiply(num);
		if(!num.mod(BigInteger.valueOf(8)).equals(BigInteger.ONE))
			return false;
		//System.out.println(num);
		num = (num.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(8));
		BigInteger sqrt = Methods.sqrt(num);
		return num.mod(sqrt).equals(BigInteger.ZERO) && num.divide(sqrt).equals(sqrt.add(BigInteger.ONE));
	}
	
	public static BigInteger solve(int limit)
	{
		BigInteger x = BigInteger.valueOf(15);
		BigInteger y = BigInteger.valueOf(21);
		while(y.compareTo(BigInteger.TEN.pow(limit)) <= 0)
		{
			BigInteger xTemp = x.multiply(BigInteger.valueOf(3)).add(y.multiply(BigInteger.valueOf(2))).subtract(BigInteger.valueOf(2));
			BigInteger yTemp = x.multiply(BigInteger.valueOf(4)).add(y.multiply(BigInteger.valueOf(3))).subtract(BigInteger.valueOf(3));
			x = xTemp;
			y = yTemp;
		}
		return x;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(12));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
