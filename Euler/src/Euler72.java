import java.util.*;
public class Euler72 
{
	public static ArrayList<Integer> sieve(int num)
	{
		boolean[] a = new boolean[num+1];
		ArrayList<Integer> sieve = new ArrayList<Integer>();
		Arrays.fill(a, true);
		a[0] = false;
		a[1] = false;
		for(int i = 2; i <= Math.sqrt(num); i++)
			for(int j = i + i; j <= num; j+= i)
				a[j] = false;
		
		for(int i = 2; i < a.length; i++)
			if(a[i])
				sieve.add(i);
		return sieve;
	}
	
	public static long Totient(int num)
	{
		double[] a = new double[num+1];
		long ans = 0;
		for(int i = 2; i < a.length; i++)
			a[i] = i;
		for(int i = 2; i <= num; i++)
			if(a[i] == i)
				for(int j = i; j <= num; j+= i)
					a[j] *= (i-1.0)/i;
		for(int i = 0; i < a.length; i++)
			ans += a[i];
		return ans;
	}
	
	public static int solution(int num)
	{
		int sum = 0;
		for(int i = 2; i <= num; i++)
		{
			sum += Totient(i);
		}
		return sum;
	}
	public static void main(String[] args)
	{
		System.out.println(Totient(1000000));
	}
}
