import java.util.*;
import java.math.*;
public class Methods 
{
	private static final BigDecimal SQRT_DIG = new BigDecimal(150);
	private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());
	 
	private static BigDecimal sqrtNewtonRaphson  (BigDecimal c, BigDecimal xn, BigDecimal precision)
	{
		BigDecimal fx = xn.pow(2).add(c.negate());
		BigDecimal fpx = xn.multiply(new BigDecimal(2));
		BigDecimal xn1 = fx.divide(fpx,2*SQRT_DIG.intValue(),RoundingMode.HALF_DOWN);
		xn1 = xn.add(xn1.negate());
		//----
		BigDecimal currentSquare = xn1.pow(2);
		BigDecimal currentPrecision = currentSquare.subtract(c);
		currentPrecision = currentPrecision.abs();
		if ( currentPrecision.compareTo(precision) <= -1 )
		{
			return xn1;
		}
		return sqrtNewtonRaphson(c, xn1,precision);
	}
		
	public static BigDecimal sqrt(BigDecimal c)
	{
		return sqrtNewtonRaphson(c,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
	}
	
	public static BigInteger sqrt(BigInteger x) 
	{
	    BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
	    BigInteger div2 = div;
	    // Loop until we hit the same value twice in a row, or wind
	    // up alternating.
	    while(true) {
	        BigInteger y = div.add(x.divide(div)).shiftRight(1);
	        if (y.equals(div) || y.equals(div2))
	            return y;
	        div2 = div;
	        div = y;
	    }
	}
	
	public static int gcd(int x, int y)
	{
		while(y != 0)
		{
			int temp = x;
			x = y;
			y = temp % y;
		}
		return x;
	}
	
	public static long gcd(long x, long y)
	{
		while(y != 0)
		{
			long temp = x;
			x = y;
			y = temp % y;
		}
		return x;
	}
	
	public static BigInteger gcd(BigInteger x, BigInteger y)
	{
		while(!y.equals(BigInteger.ZERO))
		{
			BigInteger temp = x.add(BigInteger.ZERO);
			x = y.add(BigInteger.ZERO);
			y = temp.mod(y);
		}
		return x;
	}
	
	public static ArrayList<Integer> sieve(int num)
	{
		boolean ans[] = new boolean[num + 1];
		ArrayList<Integer> sieve = new ArrayList<Integer>();
		ans[0] = true;
		ans[1] = true;
		int sqrt = (int)Math.sqrt(num);
		for(int i = 2; i <= sqrt; i++)
			if(!ans[i])
				for(int j = i*2; j <= num; j += i)
					ans[j] = true;
		
		for(int i = 0; i < ans.length; i++)
			if(!ans[i])
				sieve.add(i);
		
		return sieve;
	}
	
	public static ArrayList<Integer> sieve(int start, int end)
	{
		boolean ans[] = new boolean[end + 1];
		ArrayList<Integer> sieve = new ArrayList<Integer>();
		
		for(int i = 0; i < start; i++)
			ans[i] = true;
		
		for(int i = 2; i<= Math.sqrt(end); i++)
			if(!ans[i])
				for(int j = i*2; j <= end; j += i)
					ans[j] = true;
		
		for(int i = 0; i < ans.length; i++)
			if(!ans[i])
				sieve.add(i);
		
		return sieve;
	}
	
	public static boolean checkPrime(long num)
	{
		if(num < 2)
			return false;
		if(num == 2)
			return true;
		if(num % 2 == 0)
			return false;
		for(int i = 3; i <= Math.sqrt(num); i += 2)
			if(num % i == 0)
				return false;
		
		return true;
	}
	
	public static boolean checkPrime(BigInteger num)
	{
		if(num.compareTo(BigInteger.valueOf(2)) < 0)
			return false;
		if(num.equals(BigInteger.valueOf(2)))
			return true;
		if(num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
			return false;
		for(BigInteger i = BigInteger.valueOf(3); i.compareTo(sqrt(num)) < 0; i = i.add(BigInteger.valueOf(2)))
		{
			if(num.mod(i).equals(BigInteger.ZERO))
				return false;
		}
		return true;
	}
	
	public static int toInt(int[] array)
	{
		String s = "";
		for(int i = 0; i < array.length; i++)
			s += array[i];
		return Integer.parseInt(s);
	}
	
	
	public static long toLong(int[] array)
	{
		String s = "";
		for(int i = 0; i < array.length; i++)
			s += array[i];
		return Long.parseLong(s);
	}
	
	public static int getLength(long num)
	{
		return (int)Math.log10(num) + 1;
	}
	
	public static int getLength(BigInteger num)
	{
		return num.toString().length();
	}
	public static int[] toArray(long num)
	{
		int[] a = new int[(int)Math.log10(num) + 1];
		int index = a.length - 1;
		while(num > 0)
		{
			a[index] = (int)num % 10;
			num /= 10;
			index--;
		}
		return a;
	}
	
	public static BigInteger[] toFraction(double d)
	{
		BigInteger num = BigInteger.ONE;
		BigInteger denom = BigInteger.ONE;
		BigDecimal decimal = BigDecimal.valueOf(d);
		String temp = decimal.toString();
		int index = temp.length() - temp.indexOf(".") - 1;

		
		decimal = decimal.multiply(BigDecimal.TEN.pow(index));
		denom = denom.multiply(BigInteger.TEN.pow(index));

		num = decimal.toBigInteger();
		BigInteger gcd = Methods.gcd(num,denom);
		num = num.divide(gcd);
		denom = denom.divide(gcd);
		
		BigInteger[] array = {num,denom};
		return array;
	}
	
	public static int[] toArray(BigInteger num)
	{
		int[] a = new int[num.toString().length()];
		int index = a.length - 1;
		while(num.compareTo(BigInteger.ZERO) > 0)
		{
			a[index] = num.mod(BigInteger.TEN).intValue();
			num = num.divide(BigInteger.TEN);
			index--;
		}
		return a;
	}
	
	public static boolean isPerfectSquare(long num)
	{
		long sqrt = (long)Math.sqrt(num);
		return sqrt * sqrt == num;
	}
	
	public static boolean isPerfectSquare(BigInteger num)
	{
		BigInteger sqrt = sqrt(num);
		return sqrt.multiply(sqrt).equals(num);
	}
	public static long fact(long num)
	{
		long ans = 1;
		for(int i = 2; i <= num; i++)
		{
			ans *= i;
		}
		return ans;
	}
	
	public static long combo(int n, int r)
	{
		long ans = 1;
		int max = Integer.max(r, n-r);
		int min = Integer.min(n-r, r);
		for(int i = n; i > max; i--)
			ans *= i;
		for(int i = min; i > 1; i--)
			ans /= i;
		return ans;
	}
	public static BigInteger bigCombo(int n, int r)
	{
		BigInteger ans = BigInteger.ONE;
		int max = Integer.max(r, n-r);
		int min = Integer.min(n-r, r);
		for(int i = n; i > max; i--)
			ans = ans.multiply(BigInteger.valueOf(i));
		for(int i = min; i > 1; i--)
			ans = ans.divide(BigInteger.valueOf(i));
		return ans;
	}
	public static int[][] primeFactorization(long num)
	{
		ArrayList<Integer> sieve = sieve((int)Math.sqrt(num) + 1);
		int size = 0;
		for(int i = 0; i < sieve.size(); i++)
		{
			if(num % sieve.get(i) == 0)
				size++;
		}
		int[][] a = new int[size][2];
		int index = 0;
		for(int i = 0 ; i < sieve.size(); i++)
		{
			int exp = 0;
			int base = sieve.get(i);
			while(num % base == 0)
			{
				num /= base;
				exp++;
			}
			if(exp != 0)
			{
				System.out.println(base + "^" + exp);
				a[index][0] = base;
				a[index][1] = exp;
				index++;
			}
		}
		return a;
	}
	
	public static int count(boolean[] a, boolean check)
	{
		int count = 0;
		for(boolean b: a)
			if(b == check)
				count++;
		
		return count;
	}
	public static int count(int[] a, int check)
	{
		int count = 0;
		for(int b: a)
			if(b == check)
				count++;
		
		return count;
	}
	public static int count(double[] a, double check)
	{
		int count = 0;
		for(double b: a)
			if(b == check)
				count++;
		
		return count;
	}
	
	public static ArrayList<Integer> divisors(int num)
	{
		if(num <= 0)
			throw new IllegalArgumentException();
		ArrayList<Integer> factors = new ArrayList<Integer>();
		factors.add(1);
		int powerFactor = 1;
		while((num & 1) == 0)
		{
			powerFactor <<= 1;
			factors.add(powerFactor);
			num >>= 1;
		}
		int factor = 3;
		int limit = factors.size();
		powerFactor = 1;
		while(factor * factor <= num)
		{
			if(num % factor == 0)
			{
				powerFactor *= factor;
				for(int i = 0; i < limit; i++)
				{
					factors.add(powerFactor * factors.get(i));
				}
				num /= factor;
			}
			else
			{
				powerFactor = 1;
				limit = factors.size();
				factor += 2;
			}
		}
		if(num > 1)
		{
			if(num != factor)
			{
				limit = factors.size();
				powerFactor = 1;
			}
			powerFactor *= num;
			for(int i = 0; i < limit; i++)
			{
				factors.add(powerFactor * factors.get(i));
			}
		}
		Collections.sort(factors);
		return factors;
	}
	
	public static int totient(int num)
	{
		int ans = num;
		if((num & 1) == 0)
		{
			ans >>= 1;
			while((num & 1) == 0)
				num >>= 1;
		}
		ArrayList<Integer> sieve = Methods.sieve(num);
		int index = 1;
		while(num > 1)
		{
			int prime = sieve.get(index++);
			if(num % prime == 0)
			{
				ans = ans / prime * (prime - 1);
				while(num % prime == 0)
					num /= prime;
			}
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		int x = 36;
		System.out.println(totient(2048));
	}
}
