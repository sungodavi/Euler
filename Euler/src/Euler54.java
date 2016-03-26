import java.util.*;
public class Euler54 
{
	public static char[][] player1 = new char[2][5];
	public static char[][] player2 = new char[2][5];
	public static int score1 = 0;
	public static int score2 = 0;
	ArrayList<Character> face = new ArrayList<Character>();
	
	
	public Euler54(String input)
	{
		String[] array = input.split(" ");
		for(int i = 0; i < 5; i++)
		{
			player1[0][i] = array[i].charAt(0);
			player1[1][i] = array[i].charAt(1);
		}
		
		for(int i = 0; i < 5; i++)
		{
			player2[0][i] = array[i + 5].charAt(0);
			player2[1][i] = array[i + 5].charAt(1);
		}
		
		
	}
}
