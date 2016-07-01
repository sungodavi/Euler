import java.util.*;
import java.io.*;
public class Euler18 
{
	public static int[][] loadGrid() throws IOException
	{
		Scanner scan = new Scanner(new File("18"));
		int[][] ans = new int[15][15];
		int row = 0;
		for(int count = 1; count < 16; count ++)
		{
			for(int x = 0; x < count; x++)
			{
				ans[row][x] = scan.nextInt();
			}
			row++;
		}
		scan.close();
		return ans;
	}
	
	public static int solve(int[][] grid)
	{
		for(int i = grid.length - 2; i >= 0; i--)
		{
			for(int j = 0; j < i + 1; j++)
			{
				grid[i][j] += Integer.max(grid[i+1][j], grid[i+1][j+1]);
			}
		}
		return grid[0][0];
	}
	
	public static void main(String[] args) throws IOException
	{
		int[][] grid = loadGrid();
		System.out.println(solve(grid));
	}

}
