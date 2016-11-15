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
	
	public static void main(String[] args)
	{
		long x = (long)Math.pow(10, 12) + 1;
		while(x > 0 && !check(x))
		{
			System.out.println(x);
			x++;
		}
		System.out.println(x);
	}
}
