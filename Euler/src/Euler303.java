import java.util.*;
public class Euler303 
{
	private long[] a;
	public boolean checkArray()
	{
		for(int i = 1; i < a.length; i++)
			if(a[i] == Long.MAX_VALUE)
				return false;
		
		return true;
	}
	public void check(int num)
	{
		for(int i = 1; i <= Math.sqrt(num); i++)
		{
			if(num % i == 0 && num/i < a.length)
			{
				a[i] = Long.min(a[i], num);
				if(i != num/i && num/i < a.length)
					a[num/i] = Long.min(a[num/i], num);
			}
		}
	}
	public int toBase3(int num)
	{
		int[] a = new int[(int)(Math.log(num)/Math.log(3)) + 1];
		for(int i = 0; i < a.length; i++)
		{
			int pow = (int)Math.pow(3, a.length - 1 - i);
			a[i] = num/pow;
			num %= pow;
		}
		return Methods.toInt(a);
	}
	public long solve(int size)
	{
		a = new long[size + 1];
		Arrays.fill(a, Long.MAX_VALUE);
		int num = 1;
		while(!checkArray())
		{
			check(toBase3(num));
			num++;
			System.out.println(Arrays.toString(a));
		}
		long sum = 0;
		for(long i: a)
			sum += i;

		return sum - Long.MAX_VALUE;
	}
	
	public static void main(String[] args)
	{
		Euler303 solution = new Euler303();
		//System.out.println(solution.toBase3(13254));
		System.out.println(solution.solve(10));
	}
}
