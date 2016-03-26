import java.math.BigInteger;
public class Euler57 
{
	public static BigInteger[] root2(int times)
	{
		BigInteger num1 = BigInteger.ONE;
		BigInteger denom1 = BigInteger.ONE;
		BigInteger num2 = new BigInteger("3");
		BigInteger denom2 = new BigInteger("2");
		for(int i = 1; i < times; i++)
		{
			BigInteger temp1 = num2;
			BigInteger temp2 = denom2;
			num2 = num2.add(num2.add(num1));
			denom2 = denom2.add(denom2.add(denom1));
			num1 = temp1;
			denom1 = temp2;
		}
		BigInteger[] array = {num2,denom2};
		return array;
	}
	
	public static int digit(BigInteger num)
	{
		return num.toString().length() - 1;
	}
	
	public static void main(String[] args)
	{
		int count = 0;
		for(int i = 1; i <= 1000; i++)
		{
			BigInteger[] a = root2(i);
			System.out.println(a[0] + "/" + a[1]);
			if(digit(a[0]) > digit(a[1]))
				count++;			
		}
		System.out.println(count);
	}

}
