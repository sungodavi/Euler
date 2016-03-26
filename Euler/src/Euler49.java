import java.util.ArrayList;
import java.util.Arrays;


public class Euler49 
{
	public static ArrayList<Integer> sieve(int start, int end)
	{
		boolean[] array = new boolean[end + 1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		Arrays.fill(array,true);
		for(int x = 0; x < start; x++)
			array[x] = false;
		
		for(int i = 2; i <= Math.sqrt(end); i++)
		{
			for(int j = i * 2; j <= end; j += i)
			{
				array[j] = false;
			}
		}
		
		for(int i = start; i < array.length; i++)
		{
			if(array[i])
				list.add(i);
		}
		
		return list;
	}
	
	public static int[] toArray(int num) {
		int digits = (int) Math.log10(num) + 1;
		int[] array = new int[digits];
		for (int x = digits - 1; x > 0; x--) {
			array[x] = num % 10;
			num /= 10;
		}
		array[0] = num;
		return array;
	}
	
	public static boolean checkPrime(int num)
	{
		if(num % 2 == 0)
			return false;
		for(int i = 3; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
	
	public static boolean permutations(int num1, int num2)
	{
		int[] a1 = toArray(num1);
		int[] a2 = toArray(num2);
		Arrays.sort(a1);
		Arrays.sort(a2);
		if(Arrays.equals(a1, a2))
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> sieve = sieve(1000,9999);
		for(int i = 0; i < sieve.size() - 1; i++)
		{
			for(int j = 1; i + j < sieve.size(); j++)
			{
				int x = (int) sieve.get(i);
				int y = (int)sieve.get(i+j);
				int z = y + (y-x);
				if(checkPrime(z))
					if(permutations(x,y) && permutations(x,z))
						System.out.println("" + x + y + z);			
			}				
		}
	}

}
