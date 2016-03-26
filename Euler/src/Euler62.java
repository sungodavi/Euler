import java.util.ArrayList;
import java.util.Arrays;


public class Euler62 
{
	
	public static int[] toArray(int num)
	{
		int[] array= new int[(int)Math.log10(num) + 1];
		for(int x = 0; x < array.length; x++)
		{
			array[x] = num % 10;
			num /= 10;
		}
		return array;
	}
	
	public static int toInt(int[] array)
	{
		String temp = "";
		for(int x = 0; x< array.length; x++)
		{
			temp += array[x] + "";
		}
		return Integer.parseInt(temp);
	}
	
	public static int[] swap(int[] a, int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		return a;
	}
	
	public static void permutations(int num)
	{
		
		int[] a = toArray(num);
		Arrays.sort(a);
		for(int x = 0; x < 24; x++)
		{
		int j = a.length - 2;
		int l = j + 1;
		while(j > 0 && a[j] >= a[j + 1])
			j--;
		
		while(l > 0 && a[l] <= a[j])
			l--;
		
		a = swap(a,j,l);
		
		int k = j + 1;
		l = a.length - 1;
		while(k < l)
		{
			swap(a,k,l);
			k++;
			l--;
		}
	
		System.out.println(toInt(a));
		}
		
	}
	
	public static void main(String[] args)
	{
		permutations(1234);
	}

}
