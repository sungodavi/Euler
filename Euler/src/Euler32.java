import java.util.*;


public class Euler32 
{
	private static int[] a = {1,2,3,4,5,6,7,8,9};
	
	public static boolean check()
	{
		if(Integer.parseInt("" + a[0] + a[1]) * Integer.parseInt("" + a[2] + a[3] + a[4]) == Integer.parseInt("" + a[5] + a[6] + a[7] + a[8]))
		{	
			return true;
		}
		if(Integer.parseInt("" + a[0] + a[1] + a[2] + a[3]) * Integer.parseInt("" + a[4]) == Integer.parseInt("" + a[5] + a[6] + a[7] + a[8]))
		{
			return true;
		}
		return false;
	}
	
	public static void swap(int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	public static int fact(int num)
	{
		int ans = 1;
		for(int x = 2; x <= num; x++)
			ans *= x;
		return ans;
	}
	public static long permutations()
	{
		ArrayList<Integer> count = new ArrayList<Integer>();
		for(int x = 0; x < fact(a.length) - 1; x++)
		{
			int j = a.length - 2;
			int l = j+1;
			
			while(a[j] > a[j+1] && j > 0)
				j--;
			
			int k = j + 1;
			
			while(a[j] >= a[l] && l > 0)
				l--;
			
			swap(j,l);
			l = a.length - 1;
			while(k < l)
			{
				swap(k,l);
				k++;
				l--;
			}
			if(check())
			{
				if(!count.contains(Integer.parseInt("" + a[5] + a[6] + a[7] + a[8])))
					count.add(Integer.parseInt("" + a[5] + a[6] + a[7] + a[8]));
			}
		}
		int ans = 0;
		for(int x1 = 0; x1 < count.size(); x1++)
		{
			ans += count.get(x1);
		}
		return ans;
	}
		
		
	public static void main(String[] args)
	{
		System.out.println(permutations());
	}
	

}
