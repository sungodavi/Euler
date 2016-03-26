
import java.util.*;
public class Euler108 
{
	public static ArrayList<Integer> sieve(int num)
	{
		boolean ans[] = new boolean[num + 1];
		ArrayList<Integer> sieve = new ArrayList<Integer>();
		Arrays.fill(ans, true);
		ans[0] = false;
		ans[1] = false;
		for(int i = 2; i<= Math.ceil(Math.sqrt(num)); i++)
		{
			for(int j = i*2; j <= num; j += i)
			{
				ans[j] = false;
			}
		}
		
		for(int i = 0; i < ans.length; i++)
			if(ans[i])
				sieve.add(i);
		
		return sieve;				
	}
	
	public static int getDivisors(int num)
	{
		int ans = 1;
		int[] a = new int[num+1];
		ArrayList<Integer> sieve = sieve(num);
		for(int i = 0; i < sieve.size() && num > 0; i++)
		{
			int temp = sieve.get(i);
			while(num % temp == 0)
			{
				num /= temp;
				a[temp]++;
			}
				
		}
		for(int i = 0; i < a.length; i++)
			ans *= 2*a[i] + 1;
		ans++;
		return ans/2;
	}
	
	public static long solve(int limit)
	{
		int n = 4;
		while(getDivisors(n) < limit)
			n++;
		
		return n;
	}
	public static void main(String[] args)
	{
		System.out.println(solve(1000));
	}
}
