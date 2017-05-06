import java.util.*;
import java.math.BigInteger;
public class Euler160 
{
	public static long countFactors(long fact, int num)
	{
		long sum = 0;
		for(long i = num; i <= fact; i *= num)
		{
			sum += fact/i;
		}
		return sum;
	}
	public static long solve(long limit)
	{
		long trail = 1;;
		long fives = countFactors(limit,5);
		long twos = fives;		
		for(int i = 2; i <= limit; i++)
		{
			int temp = i;
			while(temp % 2 == 0 && twos > 0)
			{
				temp = temp >> 1;
				twos--;
			}
			while(temp % 5 == 0 && fives > 0)
			{
				temp /= 5;
				fives--;
			}
			trail *= temp % 100000;
			trail %= 100000;
			//System.out.println(i);
		}
		return trail;
	}
	
	public static void main(String[] args)
	{
		//long limit = 1000000000000l;
		for(int limit = 100000; limit < 100010; limit++)
			System.out.println(solve(limit));
	}
}
