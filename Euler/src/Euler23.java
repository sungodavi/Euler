
public class Euler23 
{
	public static int abundantArray[] = new int[28123];
	public static long checkNumber(int num)
	{
		long ans = 0;
		for(int x=1; x <= num / 2; x++)
		{
			if(num % x == 0)
				ans += x;
		}
		return ans;
	}
	
	public static void fill()
	{
		int count = 0;
		for(int x=12; x < abundantArray.length; x++)
		{
			if(checkNumber(x) > x)
			{
				abundantArray[count] = x;
				//System.out.println(x);
				count ++;
			}
		}
	}
	
	public static boolean checkAbundant(int num)
	{
		for(int x=0; abundantArray[x] < num; x++)
		{
			for(int y = 0;  abundantArray[y] < num; y++)
			{
				if(abundantArray[x] + abundantArray[y] == num)
					return false;
			}
		}
		return true;
	}
	
	public static long solve()
	{
		long ans = 0;
		for(int x=1; x<= abundantArray.length-1; x++)
		{
			if(checkAbundant(x))
			{
				ans += x;
				System.out.println(x);
			}
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		fill();
		long x = solve();
		System.out.println(x);
	}
	
		
}
