
public class Euler39 
{
	public static int check(int p)
	{
		int count = 0;
		for(int a = 1; a < p/2; a++)
		{
			if((p * (p-2*a)) % (2 * (p-a)) == 0)
				count++;
		}
		return count;
	}
	
	public static int solve(int max)
	{
		int temp = 0;
		int ans = 0;
		for(int p = 12; p <= max; p+=2)
		{
			int solutions = check(p);
			if(solutions > temp)
			{
				temp = solutions;
				ans = p;
			}
		}
		return ans;
	}
	public static void main(String [] args)
	{
		System.out.println(solve(1000));
	}
}
