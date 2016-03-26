import java.util.*;
public class Euler96 
{
	private static int[][] puzzle;
	@SuppressWarnings("unchecked")
	private static ArrayList<Integer>[][] solutions = new ArrayList[9][9];
	
	public Euler96(int[][] matrix)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 1; i <= 9; i++)
		{
			temp.add(i);
		}
		puzzle = matrix;
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				solutions[r][c] = new ArrayList<Integer>();
				if(puzzle[r][c] != 0)
					solutions[r][c].add(puzzle[r][c]);
				else
					solutions[r][c].addAll(temp);
			}
		}
		getSolutions();
	}
	public void getSolutions()
	{
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				
				if(puzzle[r][c] == 0)
				{
					for(int i = 0; i < 9; i++)
					{
						solutions[r][c].remove((Integer)puzzle[r][i]);
						solutions[r][c].remove((Integer)puzzle[i][c]);
					}
					
					for(int i = r/3*3; i < r/3*3 + 3; i++)
					{
						for(int j = c/3*3; j < c/3*3+3; j++)
						{
							if(!(i == r && j==c))
								solutions[r][c].remove((Integer)puzzle[i][j]);
						}
					}
				}
			}
		}
	}
	public void remove(int r, int c)
	{
		Integer num = puzzle[r][c];
		if(num != 0)
		{
			solutions[r][c].clear();
			solutions[r][c].add(num);
		}
		//checks rows and columns
		for(int i = 0; i < 9; i++)
		{
			if(i != r)
				solutions[i][c].remove(num);
			if(i != c)
				solutions[r][i].remove(num);
		}
		
		//check box
		for(int i = r/3*3; i < r/3*3 + 3; i++)
		{
			for(int j = c/3*3; j < c/3*3+3; j++)
			{
				if(!(i == r && j==c))
					solutions[i][j].remove(num);
			}
		}
	}
	
	public static int check(int r, int c)
	{
		if(puzzle[r][c] == 0)
		{
			for(int index = 0; index < solutions[r][c].size(); index++)
			{
				Integer num = solutions[r][c].get(index);
				boolean found;
				
				//check rows and columns
				found = true;
				for(int i = 0; i < 9; i++)
				{
					if(i != r)
					{
						if(solutions[i][c].contains(num))
						{
							found = false;
							break;
						}
					}
					if(i != c)
					{
						if(solutions[r][i].contains(num))
						{
							found = false;
							break;
						}
					}
				}
				if(found)
					return (int)num;
				
				//check box
				found = true;
				outer: 
				for(int i = r/3*3; i < r/3*3 + 3; i++)
				{
					for(int j = c/3*3; j < c/3*3+3; j++)
					{
						if(!(i == r && j==c))
							if(solutions[i][j].contains(num))
							{
								found = false;
								break outer;
							}
					}
				}
				if(found)
					return (int)num;
			}
			return 0;
		}
		return -1;
	}
	
	public void solve()
	{
		boolean complete = false;
		boolean change = true;
		while(!complete && change)
		{
			complete = true;
			change = false;
			for(int r = 0; r < 9; r++)
			{
				for(int c = 0; c < 9; c++)
				{
					if(puzzle[r][c] == 0)
					{
						complete = false;
						int num =check(r,c);
						puzzle[r][c] = num;
						if(num != 0)
						{
							change = true;
							remove(r,c);
						}
					}
				}
			}
		}
	}
	
	public void bruteForce()
	{
		
	}
	public void display()
	{
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				if(c == 2 || c == 5)
					System.out.print(puzzle[r][c] + " | ");
				else
					System.out.print(puzzle[r][c] + " ");
			}
			if(r == 2 || r== 5)
				System.out.println("\n---------------------");
			else
				System.out.println();
		}
	}
	
	public void showSolutions()
	{
		System.out.println();
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				System.out.printf("%-19s ",Arrays.toString(solutions[r][c].toArray()));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		int[][]matrix1 = {{0,0,3,0,2,0,6,0,0},
						 {9,0,0,3,0,5,0,0,1},
						 {0,0,1,8,0,6,4,0,0},
						 {0,0,8,1,0,2,9,0,0},
						 {7,0,0,0,0,0,0,0,0},
						 {0,0,6,7,0,8,2,0,0},
						 {0,0,2,6,0,9,5,0,0},
						 {8,0,0,2,0,3,0,0,9},
						 {0,0,5,0,1,0,3,0,0}};
		int[][] matrix2 = {{2,0,0,0,8,0,3,0,0},
						  {0,6,0,0,7,0,0,8,4},
						  {0,3,0,5,0,0,2,0,9},
						  {0,0,0,1,0,5,4,0,8},
						  {0,0,0,0,0,0,0,0,0},
						  {4,0,2,7,0,6,0,0,0},
						  {3,0,1,0,0,7,0,4,0},
						  {7,2,0,0,4,0,0,6,0},
						  {0,0,4,0,1,0,0,0,3}};
		
		int[][] matrix3 = {{0,0,0,0,0,0,9,0,7},
						  {0,0,0,4,2,0,1,8,0},
						  {0,0,0,7,0,5,0,2,6},
						  {1,0,0,9,0,4,0,0,0},
						  {0,5,0,0,0,0,0,4,0},
						  {0,0,0,5,0,7,0,0,9},
						  {9,2,0,1,0,8,0,0,0},
						  {0,3,4,0,5,9,0,0,0},
						  {5,0,7,0,0,0,0,0,0}};
		
		Euler96 puzzle = new Euler96(matrix1);
		puzzle.display();
		puzzle.solve();
		System.out.println();
		puzzle.display();
		System.out.println();
		
		Euler96 puzzle3 = new Euler96(matrix3);
		puzzle.display();
		puzzle.solve();
		System.out.println();
		puzzle.display();
		puzzle.showSolutions();
		
	}

}


