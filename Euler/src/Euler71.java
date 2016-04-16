import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
public class Euler71 
{	
	public static int getNumerator(int denominator)
	{
		return (int)Math.floor(3.0 * denominator/7);
	}
	public static int[] solve(int d)
	{
		double limit = 1.0 * 3/7;
		int num = 0, denom = 1;
		for(; d >= 2; d--)
		{
			double fraction = 1.0*getNumerator(d)/d;
			if(fraction < 3.0/7 && fraction > 1.0*num/denom)
			{
				denom = d;
				num = getNumerator(d);
			}
		}
		int[] array = {num,denom};
		return array;
	}
	public static void main(String[] args)
	{
		int[] array = solve(1000000);
		System.out.println(array[0] + "/" + array[1]);
	}
}
