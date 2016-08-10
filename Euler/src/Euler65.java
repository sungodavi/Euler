import java.math.BigInteger;
import java.util.*;
public class Euler65 
{
	public static int findE(int num)
	{
		int[] sequence = new int[num - 1];
		int k = 1;
		BigInteger numerator = BigInteger.ONE, denominator;
		
		Arrays.fill(sequence,1);

		for(int index = 1; index < sequence.length; index += 3)
			sequence[index] = 2 * (k++);
		
		denominator = BigInteger.valueOf(sequence[sequence.length - 1]);
		for(int i = sequence.length - 2; i >= 0; i--)
		{
			BigInteger temp = denominator;
			denominator = denominator.multiply(BigInteger.valueOf(sequence[i])).add(numerator);
			numerator = temp;
		}
		numerator = numerator.add(denominator.multiply(BigInteger.valueOf(2)));
		System.out.println(numerator + "/" + denominator);
		return sum(numerator);
	}
	
	public static int sum(BigInteger num)
	{
		int sum = 0;
		while(num.compareTo(BigInteger.ZERO) > 0)
		{
			sum += num.mod(BigInteger.TEN).intValue();
			num = num.divide(BigInteger.TEN);
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		System.out.println(findE(100));
	}
}
