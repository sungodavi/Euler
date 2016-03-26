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
		for(int x=0; x< array.length; x++)
		{
			array[x] = array[x].substring(1, array[x].length() -1);
			//System.out.println(array[x]);
		}
		Arrays.sort(array);
		scan.close();
		
	}
	
	public static int digitMode(String s)
	{
		int ans = 0;
		for(int x = 0 ; x < s.length(); x++)
		{
			ans += letters.indexOf(s.charAt(x)) + 1;
			//System.out.println(ans);
		}
		return ans;
	}
	
	public static long solve()
	{
		long ans = 0;
		for(int x=0; x< array.length; x++)
		{
			ans += digitMode(array[x]) * (x+1);
			System.out.println(ans);
		}
		return ans;
	}
	public static void main(String[] args) throws IOException
	{
		fill();
		long x = solve();
		System.out.println(x);
	}

}
