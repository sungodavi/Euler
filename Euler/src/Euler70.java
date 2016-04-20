import java.util.ArrayList;
import java.util.Arrays;

public class Euler70 
{
	//Euler's Totient Function
	//Finds # of relatively prime numbers compared to num
	
	public static double totient(int num)
	{
		ArrayList<Integer> sieve = Methods.sieve(num);
		double ans = 1;
		for(int i = 0; sieve.get(i) <= num/2; i++)
		{
			int temp = sieve.get(i);
			if(num % temp == 0)
			{
				ans *= temp-1;
				ans /= temp;
			}
		}
		return ans;
	}
	
	public static boolean checkPerm(int a, int b)
	{
		int[] aArray = Methods.toArray(a);
		int[] bArray = Methods.toArray(b);
		Sort.sort(aArray);
		Sort.sort(bArray);
		if(Arrays.equals(aArray, bArray))
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		double max = Double.MAX_VALUE;
		double ans = 0;
		int num = 100;
		while(num < 10000000)
		{
			double phi = 1.0 / totient(num);
			System.out.println(num + " " + phi);
			if(checkPerm(num,Methods.totient(num)))
			{
				if(max > phi)
				{
					max = phi;
					ans = num;
				}
			}
			num++;
		}
		System.out.println(max + " " + ans);
	}
}
