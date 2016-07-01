import java.math.BigInteger;
import java.util.Arrays;

public class Euler123 
{
	public static long[] primes(int size)
	{
		long[] a = new long[size];
		a[0] = 2;
		int index = 0;
		int n = 3;
		while(index < size - 1)
		{
			index++;
			a[index] = n;
			outer:
			while(true)
			{
				n+=2;
				int k = 1;
				while(true)
				{
					if(n % a[k] == 0)
						break;
					if(n <= a[k] * a[k])
						break outer;
					k++;
				}
			}
		}
		return a;
	}
	
	public static void main(String[] args)
	{
		long[] primes = primes(100000);
		BigInteger num;
		for(int i = 7037;;i+=2)
		{
			long p = primes[i-1];
			num = BigInteger.valueOf(2).multiply(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(p)).mod(BigInteger.valueOf(p*p));
			System.out.println(i + " " + num);
			if(num.compareTo(BigInteger.TEN.pow(10)) > 0)
			{
				break;
			}
		}
	}
}
