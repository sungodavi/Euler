import java.util.ArrayList;
import java.util.Arrays;


public class Euler49 
{
	public static boolean check(int num1, int num2)
	{
		int[] a1 = Methods.toArray(num1);
		int[] a2 = Methods.toArray(num2);
		Arrays.sort(a1);
		Arrays.sort(a2);
		if(Arrays.equals(a1, a2))
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> sieve = Methods.sieve(1000,9999);
		for(int i = 0; i < sieve.size() - 1; i++)
		{
			for(int j = 1; i + j < sieve.size(); j++)
			{
				int x = (int) sieve.get(i);
				int y = (int)sieve.get(i+j);
				int z = y + (y-x);
				if(Methods.checkPrime(z))
					if(check(x,y) && check(x,z))
						System.out.println("" + x + y + z);			
			}				
		}
	}

}
