
public class Euler12 
{
	public static int findFactors(long num)
	{
		int counter = 0;
		for(int x=1; x*x<=num; x++)
		{
			if(num% x == 0)
			{
				counter +=2;
			}
		}
		return counter;
	}
	
	public static long Euler12(int input)
	{
		int counter = 0, triangle = 2;;
		long num = 1;
		while(counter < input)
		{
			counter = findFactors(num);
			System.out.println(counter);
			num += triangle;
			triangle ++;
		}
		return num-triangle+1;
	}
	
	public static void main(String[] args)
	{
		long x = Euler12(500);
		System.out.println(x);
	}
	
}
