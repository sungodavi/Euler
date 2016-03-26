
public class Euler6 
{
	public static long solve(int num)
	{
		int ans = 0;
		for(int a=1; a<=num; a++)
		{
							
			for(int b=a+1; b<=num; b++)
			{
				ans += 2*a*b;
			}
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		long ans = solve(100);
		System.out.println(ans);
	}
	

}
