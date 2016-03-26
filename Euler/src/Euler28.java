
public class Euler28 
{
	public static void main(String args[])
	{
		long sum = 1;
		int temp = 0;
		for(int n=2; n < 1001; n += 2)
		{
			for(int x=1; x<=4; x++)
			{
				sum += temp + n*x + 1;
			}
			temp += 4*n;
		}
		System.out.println(sum);
	}

}
