import java.math.BigInteger;
public class Euler97 
{
	public static long nonMersenePrime()
	{
		BigInteger num = BigInteger.valueOf(28433);
		BigInteger base = BigInteger.valueOf(2);
		base = base.pow(7830457);
		num = num.multiply(base).add(BigInteger.ONE);
		return num.mod(BigInteger.TEN.pow(10)).longValue();
	}
	
	public static void main(String[] args)
	{
		System.out.println(nonMersenePrime());
	}
}
