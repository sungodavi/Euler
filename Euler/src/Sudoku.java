import java.util.*;
import java.io.*;
public class Sudoku {
	//github op
	public static int[][] puzzle;
	public static ArrayList<Integer>[][] solutions;
	
	public Sudoku(int[][] input)
	{
		puzzle = input;
		solutions = new ArrayList[9][9];
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
				solutions[r][c] = new ArrayList<Integer>();
		}
		
		for(int r = 0; r < 9; r++)
		{
			for(int c = 0; c < 9; c++)
			{
				if(puzzle[r][c] != 0)
					solutions[r][c].add(puzzle[r][c]);
				else
				{
					for(int i = 1; i <= 9; i++)
						solutions[r][c].add(i);
					
					//check rows
					for(int i = 0; i < 9; i++)
						solutions[r][c].remove((Integer)puzzle[r][i]);
					
					//check columns
					for(int i = 0; i < 9; i++)
						solutions[r][c].remove((Integer)puzzle[i][c]);
					
					//check box
					for(int i = r/3*3; i < r/3*3+3; i++)
						for(int j = c/3*3; j < c/3*3 + 3; j++)
							solutions[r][c].remove((Integer)puzzle[i][j]);
				}
			}
		}
	}
	
	public static void remove(int num, int r, int c)
	{
		//check rows
		for(int i = 0; i < 9; i++)
			solutions[r][i].remove((Integer)num);
		
		//check columns
		for(int i = 0; i < 9; i++)
			solutions[i][c].remove((Integer)num);
		
		//check box
		for(int i = r/3*3; i < r/3*3+3; i++)
			for(int j = c/3*3; j < c/3*3 + 3; j++)
				solutions[i][j].remove((Integer)num);
	}
	
	public static int check(int r, int c)
	{
		//System.out.println("Current Position: " + r + "," + c);
		//System.out.println(Arrays.toString(solutions[r][c].toArray()));
		if(solutions[r][c].size() == 1)
			return solutions[r][c].get(0);
		
		boolean check = false;
		for(int index = 0; index < solutions[r][c].size(); index++)
		{
			//check row
			check = true;
			for(int i = 0; i < 9; i++)
			{
					
				if(i != c && solutions[r][i].contains(solutions[r][c].get(index)))
				{
					check = false;
					break;
				}
			}
			if(check)
			{
				int temp = solutions[r][c].get(index);
				remove(solutions[r][c].get(index),r,c);
				return temp;
			}
			
			//check column
			check = true;
			for(int i = 0; i < 9; i++)
			{
				
				if(r != i && solutions[i][c].contains(solutions[r][c].get(index)))
				{
					check = false;
					break;
				}
			}
			if(check)
			{
				int temp = solutions[r][c].get(index);
				remove(solutions[r][c].get(index),r,c);
				return temp;
			}
			
			//check box
			check = true;
			outer:
			for(int i = r/3*3; i < r/3*3+3; i++)
				for(int j = c/3*3; j < c/3*3 + 3; j++)
				{					
					if(!(i==r && j == c) && solutions[i][j].contains(solutions[r][c].get(index)))
					{
						check = false;
						break outer;
					}
				}
			if(check)
			{
				int temp = solutions[r][c].get(index);
				remove(solutions[r][c].get(index),r,c);
				return temp;
			}
			
			
		}
		return 0;	
	}
	
	public static boolean solve()
	{
		boolean check = true;
		//System.out.println("Round " + count);
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++)
			{
				if(puzzle[i][j] == 0)
				{
					check = false;
					int temp = check(i,j);
					puzzle[i][j] = temp;
					if(temp != 0)
					{
						solutions[i][j].clear();
						solutions[i][j].add(temp);
					}
					//System.out.println("("+i+","+j+")");
					//display();
					//System.out.println();
				}
			}
		return check;
	}
	
	public static int[][] getPuzzle()
	{
		return puzzle;
	}
	
	public static void display()
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9 ; j++)
				System.out.print(puzzle[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void showSolutions()
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
	
	public static int getSum()
	{
		String x = "" + puzzle[0][0] + puzzle[0][1] + puzzle[0][2];
		return Integer.parseInt(x);
		
	}
	
	public static void test()
	{
		int[][]	test = {{0,0,0,0,0,0,9,0,7},
						{0,0,0,4,2,0,1,8,0},
						{0,0,0,7,0,5,0,2,6},
						{1,0,0,9,0,4,0,0,0},
						{0,5,0,0,0,0,0,4,0},
						{0,0,0,5,0,7,0,0,9},
						{9,2,0,1,0,8,0,0,0},
						{0,3,4,0,5,9,0,0,0},
						{5,0,7,0,0,0,0,0,0}};
		
		Sudoku puzzle = new Sudoku(test);
		while(!puzzle.solve())
		{
			puzzle.display();
			puzzle.showSolutions();
			System.out.println();
			
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException
	{
		test();
		/*
		int count = 0;
		int sum = 0;
		Scanner scan = new Scanner(new File("96.txt"));
		//Scanner scan = new Scanner(System.in);	
		Sudoku puzzle1;
		while(scan.hasNextLine())
		{
			int[][] puzzle = new int[9][9];
			System.out.println(scan.nextLine());
			for(int i = 0 ; i < 9; i++)
			{
				String temp = scan.nextLine();
				for(int j = 0; j < 9; j++)
				{
					puzzle[i][j] = temp.charAt(j) - '0';
				}
			}
			
			puzzle1 = new Sudoku(puzzle);
			
			while(!puzzle1.solve())
			{
			}
			puzzle1.display();		
			sum += puzzle1.getSum();
		}
		
		System.out.print(sum);
		scan.close();
		*/
	}
}