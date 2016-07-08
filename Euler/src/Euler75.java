import java.util.Arrays;

public class Euler75 
{
	public static int check(int p)
	{
		int count = 0;
		for(int a = 1; a < p/3; a++)
		{
			if((p * (p-2*a)) % (2 * (p-a)) == 0)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		
	}
}
