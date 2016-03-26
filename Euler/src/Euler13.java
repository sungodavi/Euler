import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class Euler13 
{
	public static BigInteger sum(BigInteger[] nums)
	{
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < nums.length; i++)
		{
			sum = sum.add(nums[i]);
		}
		return new BigInteger(sum.toString().substring(0, 10));
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new File("13.txt"));
		BigInteger[] nums = new BigInteger[100];
		int count = 0;
		while(scan.hasNext())
		{
			String temp = scan.nextLine();
			nums[count] = new BigInteger(temp);
			count++;
		}
		System.out.println(sum(nums));
	}

}
