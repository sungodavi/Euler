import java.util.*;
import java.io.*;
public class Euler81 
{
	public long[][] matrix;
	public Euler81(long[][] grid)
	{
		matrix = grid;
	}
	public long solve()
	{
		for(int i = 1; i < matrix.length; i++)
		{
			matrix[i][0] += matrix[i-1][0];
			matrix[0][i] += matrix[0][i-1];
		}
		
		for(int r = 1; r < matrix.length; r++)
			for(int c = 1; c < matrix.length; c++)
				matrix[r][c] += (int)Math.min(matrix[r][c-1], matrix[r-1][c]);

		System.out.println();
		display();
		System.out.println();
		return matrix[matrix.length-1][matrix.length-1];
	}
	public void display()
	{
		for(int i = 0; i < matrix.length; i++)
		{
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
	public static void main(String[] args) throws IOException
	{
		Scanner scan = new Scanner(new File("81.txt"));
		long[][] a = new long[80][80];
		int count = 0;
		while(scan.hasNext())
		{
			String[] s = scan.nextLine().split(",");
			for(int i = 0; i < s.length; i++)
			{
				a[count][i] = Integer.parseInt(s[i]);
			}
			System.out.println(Arrays.toString(a[count]));
			count++;
		}		
		Euler81 grid = new Euler81(a);
		System.out.println(grid.solve());
	}
}
