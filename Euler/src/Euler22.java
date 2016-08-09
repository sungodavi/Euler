import java.io.*;
import java.util.*;
public class Euler22 
{
	public static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static String[] array;
	public static void fill() throws IOException
	{
		Scanner scan  = new Scanner(new File("names.txt"));
		String s = scan.next();
		array = s.split(",");
		
		for(String x: array)
			x = x.substring(1, x.length() -1);
		
		Arrays.sort(array);
		scan.close();
		
	}
	
	public static int digitMode(String s)
	{
		int ans = 0;
		char[] a = s.toCharArray();
		for(char letter: a)
			ans += letters.indexOf(letter) + 1;
		
		return ans;
	}
	
	public static long solve()
	{
		long ans = 0;
		for(int x = 0; x < array.length; x++)
			ans += digitMode(array[x]) * (x+1);
		
		return ans;
	}
	public static void main(String[] args) throws IOException
	{
		long startTime = System.currentTimeMillis();
		fill();
		long x = solve();
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
