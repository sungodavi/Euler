public class Euler58 
{
	public static boolean checkPrime(int num)
	{
		if(num == 1)
			return false;
		if(num == 2)
			return true;
		if(num % 2 == 0)
			return false;
		for(int i = 3; i <= Math.sqrt(num); i+=2)
			if(num % i == 0)
				return false;
		return true;
	}

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
				if(checkPrime(corner))
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
