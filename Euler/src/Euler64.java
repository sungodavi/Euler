import java.util.*;
import java.math.*;
public class Euler64 
{
	public static int continuedFraction(int num)
	{
		int denominator = 1;
		int a = 0;
		int target = (int)(Math.sqrt(num));
		int count = 0;
		do
		{
			a -= (int)((Math.sqrt(num) + a)/denominator) * denominator;
			denominator = (num - a * a)/denominator;
			a *= -1;
			count++;	
		}while(a != target || denominator != 1);
		
		return count;
		
	}
	
	public static void main(String[] args)
	{
		int count = 0;
		for(int i = 2; i <= 10000; i++)
		{
			if(!Methods.isPerfectSquare(i))
			{
				int period = continuedFraction(i);
				if(period % 2 != 0)
					count++;
			}
		}
		System.out.println("the continued fractions of square roots <= 10,000 is odd " + count + " times.");
	}

}
