import java.util.*;
public class Euler96 {
	public static int[][] puzzle;
	public static ArrayList<Integer>[][] solutions = new ArrayList[9][9];
	
	public Euler96(int[][] matrix)
	{
		puzzle = matrix;
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				solutions[r][c] = new ArrayList<Integer>();
				if(puzzle[r][c] != 0)
					solutions[r][c].add(puzzle[r][c]);
				else
				{
					for(int i = 1; i <= 9; i++)
						solutions[r][c].add(i);
				}
			}
		}
		
		for(int r = 0; r < 1; r++)
			for(int c = 0; c < 2; c++)
			{
				remove(r,c);
				showSolutions();
			}
	}
	
	public static void remove(int r, int c)
	{
		if(puzzle[r][c] != 0)
		{
			solutions[r][c].clear();
			solutions[r][c].add(puzzle[r][c]);
		}
		Integer num = puzzle[r][c];
			
		//check rows & columns
		for(int i = 0; i < 9; i++)
		{
			if(c != i)
				solutions[r][i].remove(num);
			if(r != i)
				solutions[i][c].remove(num);
		}
		
		//check box
		{
			for(int i = r/3*3; i < r/3*3 + 3; i++)
				for(int j = c/3*3; j < c/3*3 + 3; j++)
				{
					solutions[i][j].remove(num);
				}
		}
	}
	
	public static int check(int r, int c)
	{
		boolean check;
		int num;
		
		for(int index = 0; index < solutions[r][c].size(); index++)
		{
			num = solutions[r][c].get(index);
			
			//check rows
			check = true;
			for(int i = 0; i < 9; i++)
			{
				if(r != i && solutions[r][i].contains(num))
				{
					check = false;
					break;
				}
			}
			
			//check columns
			if(check)
				return num;
			
			check = true;
			for(int i = 0; i < 9; i++)
			{
				if(c != i && solutions[i][c].contains(num))
				{
					check = false;
					break;
				}
			}
			if(check)
				return num;
			
			check = true;
			for(int i = r/3*3; i < r/3*3 + 3; i++)
			{
				for(int j = c/3*3; j < c/3*3 + 3; j++)
				{

					if(!(r == j && c == i) && solutions[i][j].contains(num))
					{
						check = false;
						break;
					}
				}
			}
			if(check)
				return num;
		}
		return 0;	
	}
	
	public static void solve()
	{
		boolean check = false;
		while(!check)
		{
			check = true;
			for(int r = 0; r < 9; r++)
			{
				for(int c = 0; c < 9; c++)
				{
					if(puzzle[r][c] == 0)
					{
						check = false;
						int temp = check(r,c);
						puzzle[r][c] = temp;
						if(temp != 0)
						{
							remove(r,c);
						}
					}	
				}
			}
			display();
			System.out.println();
			showSolutions();
			System.out.println();
		}
	}
	
	public static void display()
	{
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				System.out.print(puzzle[r][c] + " ");
			}
			System.out.println();
		}
	}
	
	public static void showSolutions()
	{
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				System.out.printf("%-20s ", Arrays.toString(solutions[r][c].toArray()));
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int[][]matrix1 = {{0,0,3,0,2,0,6,0,0},
						{9,0,0,3,0,5,0,0,1},
						{0,0,1,8,0,6,4,0,0},
						{0,0,8,1,0,2,9,0,0},
						{7,0,0,0,0,0,0,0,0},
						{0,0,6,7,0,8,2,0,0},
						{0,0,2,6,0,9,5,0,0},
						{8,0,0,2,0,3,0,0,9},
						{0,0,5,0,1,0,3,0,0}};
		Euler96 puzzle1 = new Euler96(matrix1);
		puzzle1.display();
		System.out.println();
		showSolutions();
		//puzzle1.solve();
	}
}


