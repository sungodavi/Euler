import java.util.*;
public class Euler59 
{
	public static int solve()
	{
		ArrayList<Integer> sieve = Methods.sieve(10000,999999);
		for(int n = 0; n < sieve.size(); n++)
		{
			System.out.println(sieve.get(n));
			if(check(sieve.get(n)) == 8)
				return sieve.get(n);
		}
		return 0;
	}
	
	public static int check(int num)
	{
		int max = 0;
		for(int i = 0; i <= 9; i++)
		{
			int check = check(num,i);
			if(max < check)
				max = check;
		}
		return max;
	}
	
	public static int check(int num, int replace)
	{
		int count = 0;
		int length = Methods.getLength(num);
		String initial = num + "";
		if(!initial.contains(replace + ""))
			return 0;
		for(int i = 0; i <= 9; i++)
		{
			int[] array = Methods.toArray(num);
			for(int j = 0; j < array.length; j++)
			{
				if(array[j] == replace)
					array[j] = i;
			}
			int replacedNum = Methods.toInt(array);
			
			System.out.println(replacedNum);
			if(Methods.checkPrime(replacedNum))
				if(Methods.getLength(replacedNum) == length)
					count++;
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		int x = solve();		
		System.out.println(x);
	}

}
