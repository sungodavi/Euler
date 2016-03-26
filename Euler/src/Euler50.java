import java.util.*;

public class Euler50 
{
	public static ArrayList<Integer> sieve(int num)
	{
		boolean[] array = new boolean[num + 1];
		Arrays.fill(array, true);
		array[0] = false;
		array[1] = false;
		
		for(int i = 2; i < Math.sqrt(num); i ++)
		{
			for(int j = 2 * i; j <= num; j += i)
			{
				array[j] = false;
			}
		}
		
		ArrayList list = new ArrayList<Integer>();
		for(int i = 2; i < array.length; i++)
		{
			if(array[i])
				list.add(i);
		}
		return list;
	}
	
	public static boolean checkPrime(int num)
	{
		if(num % 2 == 0)
			return false;
		
		for(int x = 3; x < num; x++)
		{
			if(num % x == 0)
				return false;
		}
		return true;
	}
	public static int Euler50(int num)
	{
		int ans = 0;
		int ansCount = 0;
		ArrayList<Integer> list = sieve(num);
		for(int i = 0; i <= 10; i++)
		{
			int sum = 0;
			int count = 0;
			int j;
			for(j = i; sum < num; j++)
			{
				count++;
				sum += list.get(j);
				if(sum < num && checkPrime(sum) && ansCount < count)
				{
					ansCount = count;
					ans = sum;
				}
			}
			
		}
		System.out.println("Count: " + ansCount);
		return ans;
	}
	
	public static void main(String[] args)
	{
		System.out.println(checkPrime(953));
		System.out.println(Euler50(1000000));
	}

}
