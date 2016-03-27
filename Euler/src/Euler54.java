import java.util.*;
public class Euler54 
{
	private char[][] player1 = new char[2][5];
	private char[][] player2 = new char[2][5];
	private int score1 = 0;
	private int score2 = 0;
	private Map suit = new HashMap();
	private Map face = new HashMap();	
	private int[] player1Suit = new int[5];
	private int[] player1Face = new int[5];
	private int[] player2Suit = new int[5];
	private int[] player2Face = new int[5];
	
	public Euler54(String input)
	{
		String[] array = input.split(" ");
		for(int i = 0; i < 5; i++)
		{
			player1[0][i] = array[i].charAt(0);
			player1[1][i] = array[i].charAt(1);
			player2[0][i] = array[i + 5].charAt(0);
			player2[1][i] = array[i + 5].charAt(1);
		}
		suit.put('H', 0);
		suit.put('D', 1);
		suit.put('C', 2);
		suit.put('S', 3);
		for(char i = '2'; i <= '9'; i++)
		{
			face.put(i, i-'0');
		}
		face.put('T', 10);
		face.put('J',11);
		face.put('J',12);
		face.put('Q',12);
		face.put('K',13);
		face.put('A',14);
		for(int i = 0; i < 5; i++)
		{
			player1Suit[i] = (int)suit.get(player1[1][i]);
			player1Face[i] = (int)face.get(player1[0][i]);
			player2Suit[i] = (int)suit.get(player2[1][i]);
			player2Face[i] = (int)face.get(player2[0][i]);
		}
		Sort.sort(player1Face);
		Sort.sort(player2Face);
	}
	public int checkRoyalFlush()
	{
		Sort.sort(player1Face);
		Sort.sort(player2Face);
		boolean p1Score = true;
		boolean p2Score = true;
		for(int i = 0; i < 4; i++)
		{
			if(player1Suit[i] != player1Suit[i+1])
			{
				p1Score = false;
			}
			if(player2Suit[i] != player2Suit[i+1])
			{
				p2Score = false;
			}
		}
		if(!(p1Score || p2Score))
			return 0;
		for(int i = 10; i <= 14; i++)
		{
			if(player1Suit[i-10] != i)
				p1Score = false;
			if(player2Suit[i-10] != i)
				p2Score = false;
		}
		if(!(p1Score || p2Score))
			return 0;
		else if(p1Score && !p2Score)
			return 1;
		return -1;
	}
	
	public int checkFlush()
	{
		
		boolean p1Score = true;
		boolean p2Score = true;
		for(int i = 0; i < 4; i++)
		{
			if(player1Suit[i] != player1Suit[i+1])
			{
				p1Score = false;
			}
			if(player2Suit[i] != player2Suit[i+1])
			{
				p2Score = false;
			}
		}
		System.out.println(p1Score + " " + p2Score);
		if(!(p1Score || p2Score))
			return 0;
		for(int i = 0; i < 4; i++)
		{
			if(player1Suit[i] + 1 != player1Suit[i+1])
				p1Score = false;
			if(player2Suit[i] + 1!= player2Suit[i+1])
				p2Score = false;
		}
		if(!(p1Score || p2Score))
			return 0;
		else if(p1Score && !p2Score)
			return 1;
		return -1;
	}
	
	public int fourOfAKind()
	{
		boolean p1Score = false,p2Score = false;
		if(player1Face[1] == player1Face[2] && player1Face[2] == player1Face[3] && (player1Face[0] == player1Face[1] || player1Face[3] == player1Face[4]))
			p1Score = true;
		if(player2Face[1] == player2Face[2] && player2Face[2] == player2Face[3] && (player2Face[0] == player2Face[1] || player2Face[3] == player2Face[4]))
			p2Score = true;
		if(p1Score == p2Score)
			return 0;
		if(p1Score && !p2Score)
			return 1;
		return -1;
		
	}
	public static void main(String[] args)
	{
		String test = "2D 9C AS AH AC 3D 6D 7D TD QD";
		Euler54 hand = new Euler54(test);
		System.out.println(hand.checkFlush());
	}
	
}
