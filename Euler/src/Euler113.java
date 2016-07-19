import java.math.BigInteger;
public class Euler113 
{
	public static boolean checkBouncy(BigInteger num)
	{
		int[] array = Methods.toArray(num);
		boolean decreasing = true;
		boolean increasing = true;
		for(int i = 0; i < array.length - 1; i++)
		{
			if(array[i] > array[i+1])
				decreasing = false;
			if(array[i] < array[i+1])
				increasing = false;
		}
		return !(decreasing || increasing);
	}
	
	public static BigInteger solve()
	{
		BigInteger num = new BigInteger("100");
		BigInteger count = BigInteger.ZERO;
		BigInteger limit = BigInteger.TEN;
		limit = limit.pow(10);
		while(num.compareTo(limit) != 0)
		{
			if(!checkBouncy(num))
				count = count.add(BigInteger.ONE);
			num = num.add(BigInteger.ONE);
		}
		return count;
	}
	public static void main(String[] args)
	{		
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
