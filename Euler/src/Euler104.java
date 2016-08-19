import java.math.BigInteger;
public class Euler104 
{
	
	public static BigInteger Fibonacci()
	{
		BigInteger f1 = BigInteger.ONE;
		BigInteger f2 = BigInteger.ONE;
		BigInteger temp;
		int count = 0;
		while(true)
		{
			temp = f2;
			f2 = f2.add(f1);
			f1 = temp;
			if(count > 2749)
				if(check(f2))
					break;
			count++;
			System.out.println(f2);
		}
		return f2;
		
	}
	public static boolean check(BigInteger num)
	{
		long end = num.mod(new BigInteger("1000000000")).longValue();
		long start = Integer.parseInt(num.toString().substring(0,9));
		int[] endArray = Methods.toArray(end);
		int[] startArray = Methods.toArray(start);
		Sort.sort(startArray);
		Sort.sort(endArray);
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
