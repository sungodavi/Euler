public class Euler94 
{
	public static boolean check1(long x)
	{
		return Methods.isPerfectSquare((3*x + 1) * (x + 1) * (x + 1) * (x - 1) / 16);
	}
	public static boolean check2(long x)
	{
		return Methods.isPerfectSquare((3*x - 1) * (x + 1) * (x-1) * (x-1) / 16);
	}
	public static void main(String[] args)
	{
		int count = 0;
		for(int x = 3; x < 333333333; x += 2)
		{
			if(check1(x))
				count++;
			if(check2(x))
				count++;
		}
		System.out.println(count);
	}
}
