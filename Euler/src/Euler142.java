
public class Euler142 
{
	public static long solve()
	{
		int x = 3;
		while(true)
		{
			for(int y = x - 1; y > 1; y--)
			{
				for(int z = y - 1; z > 0; z--)
				{
					System.out.println(x + " " + y + " " + z);
					if(!(Methods.isPerfectSquare(x+y) && 
							Methods.isPerfectSquare(x-y) &&
							Methods.isPerfectSquare(y-z) &&
							Methods.isPerfectSquare(y+z) &&
							Methods.isPerfectSquare(x+z) &&
							Methods.isPerfectSquare(x-z)))
						continue;
					return x+y+z;
				}
			}
			x++;
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve());
	}
}
