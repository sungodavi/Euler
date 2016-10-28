
public class Euler153 
{
	public static int sum(int n)
	{
		int sum = 0;
		for(int i = 1; i <= n; i++)
		{
			if(n % i != 0)
				continue;
			System.out.println("i: " + i);
			for(int j = 1; j <= Math.sqrt(i); j++)
			{
				if(Methods.isPerfectSquare(i - j*j))
				{
					System.out.println(j + " + " + (i - j*j) + "i");
					if(j*j == n)
						sum += j;
					else
						sum += 2*j;
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		int x = 7;
		System.out.println(x = x++);
		System.out.println(x);
		System.out.println(sum(4));
	}
}
