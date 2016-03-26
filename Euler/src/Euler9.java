
public class Euler9 
{
	public static boolean checkTriplet(int a, int b, int c)
	{
		if(a*a + b*b == c*c)
			return true;
		return false;
	}
	
	public static boolean checkCondition(int a, int b, int c)
	{
		if(a + b + c == 1000)
			return true;
		return false;
	}
	
	public static int Euler9()
	{
		int c=13;
		while(c != 0)
		{
		for(int x=1; x<c; x++)
		{
			for(int y = x+1; y<c; y++)
			{
				if(checkTriplet(x,y,c))
				{
					if(checkCondition(x,y,c))
					{
						System.out.println(x);
						System.out.println(y);
						System.out.println(c);
						return x*y*c;
					}

				}
			}
		}
		c++;
		}
		return 4;
	}
	
	public static void main(String[] args)
	{
		int x = Euler9();
		System.out.println(x);
	}

}
