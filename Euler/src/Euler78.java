import java.util.Arrays;

public class Euler78 
{
	public static int solve(int num)
	{
		long[] a = new long[num+1];
		a[0] = 1;
		for(int i = 1; i < a.length; i++)
			for(int j = i; j < a.length; j++)
				a[j] += a[j-i];
		
		for(int index = a.length - 1; index >= 0; index--)
		{
			if(a[index] < 1000000)
				break;
			if(a[index] % 1000000 == 0)
				return index;
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(750000));
	}
}
