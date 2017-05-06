import java.math.BigInteger;


public class Euler16 
{
	public static long solve()
	{
		long sum = 0;
		BigInteger num = new BigInteger("2");
		num = num.pow(1000);
		String s = num.toString();
		for(int x=0; x < s.length(); x++)
		{
			sum += Character.getNumericValue(s.charAt(x));
		}
		return sum;
	}
	public static void main(String[] args)
	{
		long sum = 0;
		BigInteger num = new BigInteger("2");
		num = num.pow(1000);
		String s = num.toString();
		for(int x=0; x < s.length(); x++)
		{
			sum += Character.getNumericValue(s.charAt(x));
		}
		System.out.println(sum);
	}
}
