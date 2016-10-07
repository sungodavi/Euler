
public class Euler107 
{
	public static int solve(int[][] a)
	{
		int sum = 0;
		for(int r = 1; r < a.length; r++)
		{
			int min = Integer.MAX_VALUE;
			for(int c = 0; c < r; c++)
			{
				//System.out.print("(" + r + "," + c + ") ");
				if(a[r][c] != 0)
					min = Integer.min(min, a[r][c]);
			}
			System.out.println(min);
			sum += min;
			//System.out.println();
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		int[][] a = {{0,16,12,21,0,0,0},
					{16,0,0,17,20,0,0},
					{12,0,0,28,0,31,0},
					{21,17,28,0,18,19,23},
					{0,20,0,18,0,0,11},
					{0,0,31,19,0,0,27},
					{0,0,0,23,11,27}};
		System.out.println(solve(a));
	}
}
