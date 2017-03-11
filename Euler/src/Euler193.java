import java.util.*;
public class Euler193 
{
	public static ArrayList<Integer> sieve;
	public static int recurse(long num, int index, long limit)
	{
		if(num >= limit)
			return 0;
		int count = 1;
		for(int i = index + 1; i < sieve.size(); i++)
		{
			count += recurse(num * sieve.get(i),i,limit);
		}
		return count;
	}
	
	public static int mobius(int num)
	{
		
	}
	public static void main(String[] args)
	{
		int limit = 12;
		sieve = Methods.sieve(limit);
		System.out.println(recurse(1,0,limit));
	}
}
