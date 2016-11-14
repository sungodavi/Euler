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
		int sum = 0;
		for(int x = 3; x <= 333333334; x += 2)
		{
			if(check1(x))
				sum += (3*x + 1);
			if((3*x - 1 < 1000000000) && check2(x))
				sum += (3*x - 1);
		}
		System.out.println(sum);
	}
}
