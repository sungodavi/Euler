
public class Euler10 
{
	public static boolean checkPrime(long num)
	{
		if(num % 2 == 0)
			return false;
		for(int x=3; x<= Math.ceil(Math.sqrt(num)); x+= 2)
		{
			if(num % x == 0)
				return false;
		}
			
		return true;
	}
	
	public static long Euler10()
	{
		long ans = 2;
		long temp = 3;
		while(temp < 2000000)
		{
			if(checkPrime(temp))
			{
				ans += temp;
				//System.out.println(temp);
			}
			temp += 2;
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		long x = Euler10();
		System.out.println(x);
	}
	
}
