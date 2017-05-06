
public class Euler174 
{
	public static long L(int t)
	{
		int count = 0;
		for(int i = 1; i <= Math.sqrt(t); i++)
		{
			if(t % i == 0)
				if((i + t/i) % 2 == 0)
					count++;
		}
		return count;
	}
	
	public static long N(int t)
	{
		for(int t = 1; )
	}
	public static void main(String[] args)
	{
		System.out.println(L(32));
	}
}
