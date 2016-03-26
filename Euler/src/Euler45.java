
public class Euler45 
{
	public static long tri(long n)
	{
		return n*(n+1)/2;
	}
	
	public static long pent(long n)
	{
		return n*(3*n-1)/2;
	}
	public static long hex(long n)
	{
		return n*(2*n-1);
	}
	public static long solve()
	{
		boolean check = false;
		boolean temp1 = false;
		boolean temp2 = false;
		long x = 286;
		while(!check)
		{
			temp1 = false;
			temp2 = false;
			
			int p = 166;
			while(pent(p) <= tri(x))
			{
				if(pent(p) == tri(x))
				{
					temp1 = true;
					break;
				}
				else p++;
			}
			
			int h = 144;
			while(hex(h) <= tri(x))
			{
				if(hex(h) == tri(x))
				{
					temp2 = true;
					break;
				}
				else h++;
			}
			
			if(temp1 == true && temp2 == true)
			{
				check = true;
				//System.out.println(x + " " + tri(x) + " " + pent(p) + " " +hex(h));
				break;
			}
			
			
			x++;
		}
		return tri(x);
	}
	
	public static void main(String[] args)
	{
		long x = solve();
		System.out.println(x);
	}
}
