import java.util.*;
public class Euler124 
{
	public static ArrayList<Integer> sieve;
	public static int[][] sort(int[][] a)
	{
		int temp1,temp2;
		for(int i = 1; i < a.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(a[j][1] < a[j-1][1])
				{
					temp1 = a[j-1][0];
					temp2 = a[j-1][1];
					a[j-1][0] = a[j][0];
					a[j-1][1] = a[j][1];
					a[j][0] = temp1;
					a[j][1] = temp2;
				}
			}
		}
		return a;
	}
	public static int rad(int n)
	{
		int rad = 1;
		int index = 0;
		while(n > 1)
		{
			int prime = sieve.get(index);
			if(n % prime == 0)
			{
				rad *= prime;
				while(n % prime == 0)
					n /= prime;
			}
			index++;
		}
		return rad;
	}
	public static int bruteForce()
	{
		sieve = Methods.sieve(100000);
		int[][] rads = new int[100001][2];
		for(int i = 1; i < rads.length; i++)
		{
			rads[i][0] = i;
			rads[i][1] = rad(i);
		}
		rads = sort(rads);
		return rads[10000][0];
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(bruteForce());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
