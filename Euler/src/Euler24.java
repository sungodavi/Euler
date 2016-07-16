import java.util.ArrayList;
import java.util.Arrays;

public class Euler24 
{
	public static int[] swap(int[] a, int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		return a;
	}
	public static long solve()
	{
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		int j,k,l;
		for(int iterate = 1; iterate < 1000000; iterate++)
		{
			j = a.length - 2;
			l = j+1;
			while(j > 0 && a[j] > a[j+1])
				j--;
			k = j+1;
			while(l > 0 && a[j] > a[l])
				l--;
			a = swap(a,j,l);
			
			l = a.length-1;
			while(k < l)
			{
				a = swap(a,k,l);
				k++;
				l--;
			}
		}
		return Methods.toLong(a);
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
