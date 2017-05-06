import java.util.*;
import java.io.*;
public class Euler99 
{
	public static double compare(int base, int exponent)
	{
		return exponent * Math.log(base);
	}
	
	public static int solve() throws IOException
	{
		Scanner scan = new Scanner(new File("99.txt"));
		double compare = 0;
		int line = 1;
		int ans = 0;
		while(scan.hasNext())
		{
			String s = scan.nextLine();
			String[] nums = s.split(",");
			double temp = compare(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
			if(temp > compare)
			{
				compare = temp;
				ans = line;
			}
			line++;
		}
		scan.close();
		return ans;
	}
	public static void main(String[] args) throws IOException
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
		
	}
}
