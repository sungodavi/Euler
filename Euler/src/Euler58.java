public class Euler58 
{
	public static int solve()
	{
		double percent = 100;
		int side = 1;
		int corner = 1;
		int count = 0;
		
		
		while(percent > 10)
		{
			side += 2;
			for(int i = 1; i <= 4; i++)
			{
				corner += side - 1;
				if(Methods.checkPrime(corner))
					count++;
			}
			percent = 100.0 * count/(2 * side - 1);
		}
		return side;
				
	}
	public static void main(String[] args)
	{
		System.out.println(solve());
	}
}
