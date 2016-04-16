import java.util.*;
import java.math.*;
public class Euler64 
{
	
	public static void continuedFraction(int num)
	{
		BigDecimal sqrt = Methods.sqrt(BigDecimal.valueOf(num));
		Queue<Long> a = new LinkedList<Long>();
		Set<BigDecimal> sequence = new HashSet();
		long aN = 0;
		
		
		while(sequence.add(sqrt))
		{
			aN = sqrt.toBigInteger().longValue();
			a.add(aN);
			sqrt = BigDecimal.ONE.divide(sqrt.subtract(BigDecimal.valueOf(aN)),20,BigDecimal.ROUND_HALF_DOWN);
			System.out.println(aN);
		}
		
	}
	
	public static void main(String[] args)
	{
		continuedFraction(23);
	}

}
