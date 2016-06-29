import java.util.ArrayList;
import java.util.Arrays;

public class Euler70 
{
	//Euler's Totient Function
	//Finds # of relatively prime numbers compared to num
	
	public static int totient(int num)
	{
		ArrayList<Integer> sieve = Methods.sieve(num);
		long ans = num;
		for(int i = 0; i < sieve.size(); i++)
		{
			int temp = sieve.get(i);
			if(num % temp == 0)
			{
				ans *= temp-1;
				ans /= temp;
			}
		}
		return (int)ans;
	}
	
	public static boolean checkPerm(int a, int b)
	{
		if(Methods.getLength(a) != Methods.getLength(b))
			return false;
		int[][] array = new int[2][Methods.getLength(a)];
		int[] tempA = Methods.toArray(a);
		int[] tempB = Methods.toArray(b);
		Sort.sort(tempA);
		Sort.sort(tempB);
		array[0] = tempA;
		array[1] = tempB;
		for(int i = 0; i < array[0].length; i++)
		{
			if(array[0][i] != array[1][i])
				return false;
		}
		return true;
	}
	
	public static int solve()
	{
		double max = Double.MAX_VALUE;
		int ans = 123;
		ArrayList<Integer> sieve = Methods.sieve(2000,5000);
		for(int i = 0; i < sieve.size() - 1; i++)
		{
			for(int j = i + 1; j <sieve.size(); j++)
			{
				int num = sieve.get(i) * sieve.get(j);
				if(num > 10000000)
					break;
				int phi = (sieve.get(i) - 1) * (sieve.get(j) - 1);
				if(checkPerm(num,phi))
					if(1.0 * num/phi < max)
					{
						max = 1.0*num/phi;
						ans = num;
					}
			}
		}
		return ans;
		
	}
	public static void main(String[] args)
	{
		System.out.println(solve());
	}
}
