import java.util.*;
import java.math.BigInteger;

public class Methods 
{
	//add sort algorithm
	public static int Euclid(int x, int y)
	{
		if(y == 0)
			return x;
		
		else 
			return Euclid(y, x%y);
	}
	
	public static BigInteger convert(long num)
	{
		return new BigInteger(num + "");
	}
	
	public static ArrayList<Integer> sieve(int num)
	{
		boolean ans[] = new boolean[num + 1];
		ArrayList<Integer> sieve = new ArrayList<Integer>();
		Arrays.fill(ans, true);
		ans[0] = false;
		ans[1] = false;
		for(int i = 2; i<= Math.ceil(Math.sqrt(num)); i++)
		{
			for(int j = i*2; j <= num; j += i)
			{
				ans[j] = false;
			}
		}
		
		for(int i = 0; i < ans.length; i++)
		{
			if(ans[i])
				sieve.add(i);
		}
		return sieve;
	}
	
	public static int toInt(int[] array)
	{
		String s = "";
		for(int i = array.length -1; i >= 0; i--)
			s += array[i];
		return Integer.parseInt(s);
	}
	
	public static int[] toArray(long num)
	{
		int[] a = new int[(int)Math.log10(num) + 1];
		int index = 0;
		while(num > 0)
		{
			a[index] = (int)num % 10;
			num /= 10;
			index++;
		}
		return a;
	}
	public static int[] toArray(BigInteger num)
	{
		int[] a = new int[num.toString().length()];
		int index = 0;
		while(num.compareTo(BigInteger.ZERO) > 0)
		{
			a[index] = num.mod(BigInteger.TEN).intValue();
			num = num.divide(BigInteger.TEN);
			index++;
		}
		return a;
	}
	public static String toString(Collection a)
	{
		return Arrays.toString(a.toArray());
	}
	
	public static int totient(int num)
	{
		ArrayList<Integer> sieve = sieve(num);
		double ans = num;
		for(int i = 0; sieve.get(i) <= num/2; i++)
		{
			int temp = sieve.get(i);
			if(num % temp == 0)
			{
				ans *= temp-1;
				ans /= temp;
			}
		}
		return (int)ans;
	}
	
}
