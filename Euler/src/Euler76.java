import java.util.Arrays;

public class Euler76 
{
	public static int solve(int num)
	{
		int[] a = new int[num+1];
		a[0] = 1;
		for(int i = 1; i < a.length; i++)
		{
			for(int j = i; j < a.length; j++)
			{
				a[j] += a[j-i];
			}
		}
		System.out.println(Arrays.toString(a));
		return a[num];
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(100) - 1);
	}
}
