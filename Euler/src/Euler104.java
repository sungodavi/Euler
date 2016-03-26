import java.math.BigInteger;
import java.util.*;
public class Euler104 
{
	
	public static BigInteger Fibonacci()
	{
		BigInteger f1 = BigInteger.ONE;
		BigInteger f2 = BigInteger.ONE;
		BigInteger temp;
		outer:
		while(true)
		{
			temp = f2;
			f2 = f2.add(f1);
			f1 = temp;
			System.out.print(f2 + " ");
			if(f2.compareTo(new BigInteger("100000000")) == 1)
				if(check(f2))
					break outer;
		}
		return f2;
		
	}
	
	public static int[] toArray(long num)
	{
		int[] ans = new int[9];
		int count = 0;
		while(num > 0)
		{
			ans[count] = (int) (num % 10);
			num/=10;
			count++;
		}
		Arrays.sort(ans);
		return ans;
	}
	public static boolean check(BigInteger num)
	{
		long end = num.mod(new BigInteger("1000000000")).longValue();
		long start = Integer.parseInt(num.toString().substring(0,9));
		int[] endArray = toArray(end);
		int[] startArray = toArray(start);
		for(int i = 1; i <= 9; i++)
		{
			if(endArray[i-1] != i || startArray[i-1] != i)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args)
	{
		Fibonacci();
	}

}
