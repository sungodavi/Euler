import java.math.*;
import java.util.*;
public class Euler64 
{
	
	public static int continuedFraction(int input)
	{
		BigDecimal sqrt = BigDecimal.valueOf(input);
		long aN = Methods.sqrt(sqrt).toBigInteger().longValue();
		int numerator = 1;
		Queue<Long> a = new LinkedList<Long>();
	}
	
	public static void main(String[] args)
	{
		int count = 0;
		
		for(int i = 2; i <= 5; i++)
		{
			if(!Methods.isPerfectSquare(i))
			{
				System.out.println(continuedFraction(i));
				if(continuedFraction(i) % 2 != 0)
					count++;
			}
		}
	}
}

