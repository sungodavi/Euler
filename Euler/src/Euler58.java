import java.util.*;
public class Euler58 
{
	public static boolean checkPrime(int num)
	{
		if(num == 1)
			return false;
		if(num == 2)
			return true;
		if(num % 2 == 0)
			return false;
		for(int i = 3; i <= Math.sqrt(num); i+=2)
			if(num % i == 0)
				return false;
		return true;
	}
	
	public static double getNums(int size)
	{
		int num = 1;
		int count = 0;
		int factor = 2;
		int denom = 1;
		for(int i = 3; i <= size; i+=2)
		{
			for(int j = 1; j <= 4; j++)
			{
				denom++;
				num += factor;
				if(checkPrime(num))
				{
					count++;
				}
			}
			factor+=2;
		}
		System.out.println(100.0 * count/denom);
		return 100.0 * count/denom;
	}
	
	public static void main(String[] args)
	{
		int size = 7;
		while(getNums(size) > 10)
			size += 200;
		System.out.println(size);
	}
}
