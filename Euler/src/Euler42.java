import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Euler42 
{
	public static String[] array;
	public static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static void fill() throws IOException
	{
		Scanner scan  = new Scanner(new File("words.txt"));
		String s = scan.next();
		array = s.split(",");
		for(int x=0; x< array.length; x++)
		{
			array[x] = array[x].substring(1, array[x].length() -1);
			//System.out.println(array[x]);
		}
		
	}
	
	public static int triangle(int n)
	{
		return n*(n+1)/2;
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

	public static boolean check(String word)
	{
		int x = 1;
		while(triangle(x) <= digitMode(word))
		{
			if(digitMode(word) == triangle(x))
				return true;
			x++;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException
	{
		fill();
		int count = 0;
		for(int x=0; x<array.length; x++)
		{
			if(check(array[x]))
			{
				System.out.println(array[x]);
				count ++;
			}
		}
		System.out.println(count);
	}

}
