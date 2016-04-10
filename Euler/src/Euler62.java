import java.util.*;
public class Euler62 
{
	
	public static boolean checkCube(long num)
	{
		for(int i = (int) (Math.cbrt(num) - 10); i <= Math.cbrt(num) + 10; i++)
		{
			if(i * i * i == num)
				return true;
		}
		return false;
	}
	
	public static int permutations(long num)
	{
		int cubes = 0;
		int[] a = Methods.toArray(num);
		int divide = 1;
		int len = Methods.getLength(num);
		Sort.sort(a);
		for(int i = 0; i <= 9; i++)
		{
			int count = 0;
			for(int j = 0; j < a.length; j++)
			{
				if(a[j]  == i)
					count++;
			}
			if(count != 0)
				divide *= Methods.fact(count);
		}
		System.out.println(divide);
		for(int x = 1; x < Methods.fact(Methods.getLength(num))/divide; x++)
		{
			int j = a.length - 2;
			int l = j + 1;
			while(j > 0 && a[j] >= a[j + 1])
				j--;
		
			while(l > 0 && a[l] <= a[j])
				l--;
		
			a = Methods.swap(a,j,l);
			
			int k = j + 1;
			l = a.length - 1;
			while(k < l)
			{
				Methods.swap(a,k,l);
				k++;
				l--;
			}
			
			
			if(checkCube(Methods.toInt(a)))
			{
				if(Methods.getLength(Methods.toInt(a)) == len)
				{
					System.out.println(Methods.toInt(a));
					cubes++;
				}
			}
			
		
		}
		return cubes;
	}
	
	
	public static long solve()
	{
		int i = 346;
		while(true)
		{
			if(permutations(i * i * i) == 5)
				return i * i * i;
			i++;
		}
	}
	public static void main(String[] args)
	{
		System.out.println(solve());
		//System.out.println(permutations(125000000));
	}

}
