import java.util.*;

public class Euler77 
{
	public static int solve(int num)
	{
		int[] a = new int[num+1];
		a[0] = 1;
		ArrayList<Integer> sieve = Methods.sieve(num);
		for(int i: sieve)
			for(int j = i; j < a.length; j++)
				a[j] += a[j-i];
		
		for(int i = 0; i < a.length; i++)
			if(a[i] > 5000)
				return i;
		
		return -1;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(100));
	}
}
