import java.util.*;
import java.math.BigInteger;
public class Euler188 
{
	public static long solve(int b, int e)
	{
		BigInteger ans = BigInteger.valueOf(b);
		BigInteger exponent = BigInteger.ONE;
		for(int i = 1; i <= e - 1; i++)
		{
			exponent = ans.mod(BigInteger.valueOf(40000000)); //Euler's Theorem
			ans = BigInteger.valueOf(b).modPow(exponent, BigInteger.valueOf(100000000));
			
		}
		return ans.longValue();
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(1777,1855));
	}
}
