import java.io.*;
import java.util.*;

public class Euler82 
{
	public static void display(int[][] grid)
	{
		for(int[] i: grid)
		{
			System.out.println(Arrays.toString(i));
		}
	}
	public static int solve(int[][] grid)
	{
		int len = grid.length;
		for(int c = 1; c < len; c++)
		{
			int[] sums = new int[len];
			for(int r = 0; r < len; r++)
			{
				int min = Integer.MAX_VALUE;
				for(int r2 = 0; r2 < len; r2++)
				{
					int sum = grid[r2][c-1] + grid[r2][c];
					if(r2 > r)
					{
						for(int i = r2 - 1; i >= r; i--)
						{
							sum += grid[i][c];
						}
					}
					else
						for(int i = r2 + 1; i <= r; i++)
						{
							sum += grid[i][c];
						}
					min = Integer.min(sum, min);
				}
				sums[r] = min;
			}
			for(int r = 0; r < len; r++)
			{
				grid[r][c] = sums[r];
			}
		}
		int ans = Integer.MAX_VALUE;
		for(int r = 0; r < len; r++)
		{
			ans = Integer.min(ans, grid[r][len-1]);
		}
		return ans;
	}
	public static void main(String[] args) throws IOException
	{
		/*int[][] test = {{131,673,234,103,18},
						{201,96,342,965,150},
						{630,803,746,422,111},
						{537,699,497,121,956},
						{805,732,524,37,331}};*/
		long startTime = System.currentTimeMillis();
		Scanner scan = new Scanner(new File("81.txt"));
		int[][] a = new int[80][80];
		int count = 0;
		while(scan.hasNext())
		{
			String[] s = scan.nextLine().split(",");
			for(int i = 0; i < s.length; i++)
			{
				a[count][i] = Integer.parseInt(s[i]);
			}
			count++;
		}		
		System.out.println(solve(a));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
		scan.close();
	}
}
