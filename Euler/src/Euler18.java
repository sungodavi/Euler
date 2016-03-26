import java.util.*;
import java.io.*;
public class Euler18 
{
	
	public static int[][] makeRight(int[][] array)
	{
		int[][] ans = new int[array.length-1][array[0].length - 1];
		for(int x = 1; x < array.length; x++ )
		{
			for(int y = 1; y <= x; y++)
			{
				ans[x-1][y-1] = array[x][y];
			}
		}
		return ans;
	}
	
	public static int[][] makeLeft(int[][] array)
	{
		int[][] ans = new int[array.length-1][array[0].length - 1];
		for(int x = 1; x <= ans.length; x++)
		{
			for(int y = 0; y < x; y++)
			{
				ans[x-1][y] = array[x][y];
			}
		}
		return ans;
	}
	
	public static int[][] make() throws IOException
	{
		Scanner scan = new Scanner(new File("18"));
		int[][] ans = new int[15][15];
		int count = 1;
		int row = 0;
		while(count < 16)
		{
			for(int x=0; x<count; x++)
			{
				ans[row][x] = scan.nextInt();
			}
			count ++;
			row ++;
		}
		scan.close();
		return ans;
		
	}
	
	public static void display(int[][] make)
	{
		for(int x = 0; x < make.length; x++)
		{
			for(int y=0; y < make.length; y ++)
			{
				if(make[x][y] != 0)
					System.out.print(make[x][y] + " ");
			}
			System.out.println();
		}
	}
	
	public static int recurse(int[][] array)
	{
		if(array.length == 2)
			return array[0][0] + Math.max(array[1][0], array[1][1]);
		
		return array[0][0] + Math.max(recurse(makeLeft(array)), recurse(makeRight(array)));
	}

	public static void main(String[] args) throws IOException
	{
		int[][] make = make();
		System.out.println(recurse(make));
	}

}
