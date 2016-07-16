import java.util.*;
public class Euler112 
{
	public static boolean checkBouncy(long num)
	{
		int[] array = Methods.toArray(num);
		boolean increasing = true;
		boolean decreasing = true;
		for(int i = 0; i < array.length - 1; i++)
		{
			if(array[i] > array[i+1])
				decreasing = false;
			if(array[i] < array[i+1])
				increasing = false;
		}
		return !(decreasing || increasing);
	}
	
	public static long solve()
	{
		int num = 1;
		int count = 0;
		double percent = 0;
		while(percent != 99)
		{
			if(checkBouncy(num))
				count++;
			percent = 100.0 * count/num;
			num++;
		}
		return num - 1;
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