import java.util.*;
public class Euler187 
{
	public static long solve(int num)
	{
		int count = 0;
		ArrayList<Integer> sieve = Methods.sieve(num/2);
		int index = sieve.size() - 1;
		for(int i = 0; i < sieve.size(); i++)
		{
			int factor = sieve.get(i);
			while(index >= 0 && factor * sieve.get(index) >= num)
			{
				index--;
			}
			if(index < i)
				break;
			count += index + 1 - i;
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(100000000));
	}
	
	
}
