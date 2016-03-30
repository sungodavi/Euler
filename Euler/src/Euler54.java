import java.util.*;
public class Euler54 
{
	public static Map suit = new HashMap();
	public static char[][] cards;
	public static Map faces = new HashMap();
	public static int[] f = new int[5];
	public static int[] s = new int[5];
	
	public Euler54(String hand)
	{
		String[] temp = hand.split(" ");
		loadMaps();
		for(int i = 0; i < 5; i++)
		{
			cards[0][i] = temp[i].charAt(0);
			f[i] = (int)faces.get(temp[i].charAt(0));
			cards[1][i] = temp[i].charAt(1);
			s[i] = (int)faces.get(temp[i].charAt(1));
		}
		Arrays.sort(f);
		Arrays.sort(s);
	}
	
	public void loadMaps()
	{
		suit.put('H',1);
		suit.put('D', 2);
		suit.put('C',3);
		suit.put('S',4);
		
		for(char i = '2'; i <= '9'; i++)
		{
			faces.put(i, i - '0');
		}
		faces.put('T', 10);
		faces.put('J', 11);
		faces.put('Q', 12);
		faces.put('K', 13);
		faces.put('A',14);
	}
	
	//returns high card
	public int checkFlush()
	{
		for(int i = 0; i < 4; i++)
		{
			if(s[i] != s[i+1])
				return 0;
		}
		return f[4];
	}
	//returns high card
	public int checkStraightFlush()
	{
		if(checkFlush() == 0)
			return 0;
		return straight();
	}
	public int checkRoyalFlush()
	{
		if(checkStraightFlush() == 0)
			return 0;
		if(f[0] == 10)
			return f[4];
		return 0;			
	}
	public int straight()
	{
		for(int i = 0; i < 4; i++)
		{
			if(f[i] + 1 != f[i + 1])
				return 0;
		}
		return f[4];
	}
	public int highCard()
	{
		return f[4];
	}
	
	public int fourOfAKind()
	{
<<<<<<< HEAD
		if(f[1] == f[2] && f[2] == f[3] && (f[0] == f[1] || f[3] == f[4]))
			return f[2];
		return 0;
	}
	
	public int[] pairs()
	{
		int[] array = new int[2];
		int index = 0;
=======
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
		if(p1Score == p2Score)
			return 0;
		if(p1Score && !p2Score)
			return 1;
		return -1;
	}
	
	public int checkStraightFlush()
	{
		boolean p1Score = true;
		boolean p2Score = true;
>>>>>>> refs/remotes/origin/master
		for(int i = 0; i < 4; i++)
		{
			if(f[i] == f[i+1])
			{
				array[index] = f[i];
				i++;
				index++;
			}
		}
<<<<<<< HEAD
		return array;
	}
	
	public int threeOfAKind()
=======
		System.out.println(p1Score + " " + p2Score);
		System.out.println(Arrays.toString(player2Face));
		if(!(p1Score || p2Score))
			return 0;
		for(int i = 0; i < 4; i++)
		{
			if(player1Suit[i] + 1 != player1Suit[i+1])
				p1Score = false;
			if(player2Suit[i] + 1!= player2Suit[i+1])
				p2Score = false;
		}
		System.out.println(p1Score + " " + p2Score);
		if(!(p1Score || p2Score))
			return 0;
		else if(p1Score && !p2Score)
			return 1;
		return -1;
	}
	public int fourOfAKind()
>>>>>>> refs/remotes/origin/master
	{
		for(int i = 0; i < 3; i++)
		{
			if(f[i] == f[i+1] && f[i+1] == f[i+2])
				return f[i];
		}
		return 0;
	}
	
<<<<<<< HEAD
	public static void main(String[] args)
	{
		String test = 
=======
	public int fullHouse()
	{
		boolean p1Score = false,p2Score = false;
		if(player1Face[0] == player1Face[1] && player1Face[3] == player1Face[4] && (player1Face[1] == player1Face[2] || player1Face[2] == player1Face[3]))
			p1Score = true;
		if(player2Face[0] == player2Face[1] && player2Face[3] == player2Face[4] && (player2Face[1] == player2Face[2] || player2Face[2] == player2Face[3]))
			p2Score = true;
		if(p1Score == p2Score)
			return 0;
		if(p1Score && !p2Score)
			return 1;
		return -1;
		
	}
	public static void main(String[] args)
	{
		String test = "2H 2D 4C 4D 4S 3C 3D 3S 9S 9D";
		Euler54 hand = new Euler54(test);
		System.out.println(hand.fullHouse());
>>>>>>> refs/remotes/origin/master
	}
	
}
