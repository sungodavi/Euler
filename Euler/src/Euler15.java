
public class Euler15 
{
	public static long choose(int numerator, int denominator)
	{
		double ans =1;
		for(int x=numerator; x > denominator; x--)
		{
			
			ans *= x;
			if(numerator-denominator != 0)
				ans /= x-denominator;
		}
		return (long)(ans);
	}
	public static long pascalsTriangle(int size)
	{
		return choose(size*2, size);
	}
	
	public static void main(String[] args)
	{
		long x = pascalsTriangle(20);
		System.out.println(x);
	}

}
