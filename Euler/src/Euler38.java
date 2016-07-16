import java.util.*;
public class Euler38 
{
	public static boolean checkPandigital(int num)
	{
		int[] a = Methods.toArray(num);
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] != i + 1)
				return false;
		}
		return true;
	}
	public static int solve()
	{
		for(int i = 9876; i >= 9123; i--)
		{
			if(checkPandigital(Integer.parseInt(""+ i + (2 * i))))
				return Integer.parseInt(i + "" + (2*i));
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
