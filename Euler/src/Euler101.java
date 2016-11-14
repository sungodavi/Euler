import java.math.BigInteger;
import java.util.Arrays;

public class Euler101 
{
	public static BigInteger determinant(long a[][], int size)
	{
		if(size == 1)
			return BigInteger.valueOf(a[0][0]);
		BigInteger det = BigInteger.ZERO;
		long[][] b = new long[size - 1][size - 1];
		for(int i = 0; i < size; i++)
		{
			for(int c = 0; c < size; c++)
			{
				if(c == i)
					continue;
				for(int r = 1; r < size; r++)
				{
					if(c < i)
						b[r - 1][c] = a[r][c];
					else
						b[r-1][c-1] = a[r][c];
				}
			}
			if(i % 2 == 0)
				det = det.add(BigInteger.valueOf(a[0][i]).multiply(determinant(b, size - 1)));
			else
				det = det.subtract(BigInteger.valueOf(a[0][i]).multiply(determinant(b, size - 1)));
		}
		return det;
	}
	
	public static BigInteger[] cramer(long[][] a, long[] ans)
	{
		BigInteger det = determinant(a,a.length);
		BigInteger[] solutions = new BigInteger[ans.length];
		for(int i = 0; i < ans.length; i++)
		{
			long[][] aTemp = new long[a.length][a.length];
			for(int c = 0; c < a.length; c++)
			{
				if(c == i)
				{
					for(int r = 0; r < a.length; r++)
					{
						aTemp[r][c] = ans[r];
					}
				}
				else
					for(int r = 0; r < a.length; r++)
					{
						aTemp[r][c] = a[r][c];
					}
			}
			solutions[i] = determinant(aTemp,aTemp.length).divide(det);
		}
		return solutions;
	}
	public static long f(int x)
	{
		long sum = 0;
		for(int i = 0; i <= 10; i++)
		{
			long num = 1;
			for(int j = 0; j < i; j++)
			{
				num *= x;
			}
			if(i % 2 == 0)
				sum += num;
			else
				sum -= num;
		}
		return sum;
	}
	public static BigInteger[] OP(int degree)
	{
		long[][] system = new long[degree][degree];
		long[] ans = new long[degree];
		for(int r = 0; r < degree; r++)
		{
			ans[r] = f(r+1);
			for(int c = 0; c < degree; c++)
			{
				int x = r+1;
				int num = 1;
				for(int j = degree - 1; j > c; j--)
				{
					num *= x;
				}
				system[r][c] = num;
			}
		}
		//System.out.println(Arrays.deepToString(system));
		return cramer(system,ans);
	}
	public static BigInteger FIT(BigInteger[] polynomial)
	{
		int x = polynomial.length + 1;
		BigInteger num = BigInteger.ZERO;
		for(int i = 0; i < polynomial.length; i++)
		{
			BigInteger temp = polynomial[i];
			for(int j = polynomial.length - 1; j > i; j--)
			{
				temp = temp.multiply(BigInteger.valueOf(x));
			}
			num = num.add(temp);
		}
		return num;
	}
	public static BigInteger solve(int degree)
	{
		BigInteger sum = BigInteger.ZERO;
		for(int i = 1; i <= degree; i++)
		{
			BigInteger[] op = OP(i);
			sum = sum.add(FIT(op));
		}
		return sum;
	}
	public static BigInteger check(BigInteger[] a, int val)
	{
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < a.length; i++)
		{
			BigInteger temp = a[i];
			for(int j = a.length - 1; j > i; j--)
			{
				temp = temp.multiply(BigInteger.valueOf(val));
			}
			//System.out.println("sum : " + sum);
			sum = sum.add(temp);
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(10));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
