import java.util.Arrays;
import java.math.BigInteger;
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
			System.out.println(det);
		}
		return det;
	}
	
	public static long[] cramer(long[][] a, long[] ans)
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
	public static long[] OP(int degree)
	{
		long[][] system = new long[degree][degree];
		long[] ans = new long[degree];
		for(int r = 0; r < degree; r++)
		{
			ans[r] = f(r+1);
			for(int c = 0; c < degree; c++)
			{
				int x = r + 1;
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
	public static long FIT(long[] polynomial)
	{
		int x = polynomial.length + 1;
		long num = 0;
		for(int i = 0; i < polynomial.length; i++)
		{
			long temp = polynomial[i];
			for(int j = polynomial.length - 1; j > i; j--)
			{
				temp *= x;
			}
			num += temp;
		}
		return num;
	}
	public static long solve(int degree)
	{
		long sum = 0;
		for(int i = 1; i <= degree; i++)
		{
			long[] op = OP(i);
			System.out.println(Arrays.toString(op));
			for(int j = 1; j <= i; j++)
			{
				System.out.println(check(op,j));
			}
			sum += FIT(op);
		}
		return sum;
	}
	public static long check(long[] a, int val)
	{
		long sum = 0;
		for(int i = 0; i < a.length; i++)
		{
			long temp = a[i];
			for(int j = a.length - 1; j > i; j--)
			{
				temp *= val;
			}
			//System.out.println("sum : " + sum);
			sum += temp;
		}
		return sum;
	}
	public static void main(String[] args)
	{
		/*int[][] a = {{5,4,6},{3,2,8},{1,9,7}};
		int[][] system = {{2,1,1},{1,-1,-1},{1,2,1}};
		int[] ans = {3,0,0};
		int[][] OPTest = {{1,1},{2,1}};
		int[] OPTestAns = {1,8};
		System.out.println(Arrays.toString(cramer(OPTest,OPTestAns)));
		System.out.println(determinant(a, 3));
		System.out.println(Arrays.toString(cramer(system,ans)));
		int[] op = OP(4);
		System.out.println(Arrays.toString(OP(1)));
		System.out.println(FIT(op));*/
		for(int i = 1; i <= 10; i++)
		{
			System.out.println(i + ": " + f(i));
		}
		System.out.println(Arrays.toString(OP(8)));
		//System.out.println(solve(5));
		//System.out.println(Arrays.toString(OP(11)));
	}
}
