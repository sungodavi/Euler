import java.util.Arrays;


public class Methods 
{
	public static int Euclid(int x, int y)
	{
		if(y == 0)
		{
			return x;
		}
		else 
			return Euclid(y, x%y);
	}
	
	public static boolean[] sieve(int num)
	{
		boolean ans[] = new boolean[num + 1];
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
		return ans;
	}
	
	public static void main(String[] args)
	{
		boolean[] x = sieve(100);
		for(int y=2; y<x.length; y++)
		{
			if(x[y])
				System.out.println(y);
				
		}

	}

}
