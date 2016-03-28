import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Euler67 
{
	public static int[][] make(int size) throws IOException
	{
			Scanner scan = new Scanner(new File("67"));
			int[][] ans = new int[size][size];
			int count = 1;
			while(count <= size)
			{
				for(int x=0; x < count; x++)
				{
					ans[count - 1][x] = scan.nextInt();
				}
				count ++;
			}
			scan.close();
			return ans;
	}
	
	public static int solve(int[][] array)
	{
		for(int x = array.length - 2; x >= 0 ; x--)
		{
			for(int y = 0; y < array.length - 1; y ++)
			{
				
				array[x][y] += Math.max(array[x+1][y], array[x+1][y+1]);
			}
		}
		return array[0][0];
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
	public static void main(String[] args) throws IOException
	{
		int[][] make = make(100);
		display(make);
		int ans = solve(make);
		System.out.println(ans);
	}
}
