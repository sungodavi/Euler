import java.util.*;
import java.io.*;
public class Euler54 
{
	private Map suit = new HashMap();
	private char[][] cards = new char[2][5];
	private Map faces = new HashMap();
	private int[] f = new int[5];
	private int[] s = new int[5];
	
	public Euler54(String hand)
	{
		String[] temp = hand.split(" ");
		loadMaps();
		for(int i = 0; i < 5; i++)
		{
			cards[0][i] = temp[i].charAt(0);
			f[i] = (int)faces.get(temp[i].charAt(0));
			cards[1][i] = temp[i].charAt(1);
			s[i] = (int)suit.get(temp[i].charAt(1));
		}
		Arrays.sort(f);
		Arrays.sort(s);
	}
	public int[] getF()
	{
		return f;
	}
	public int[] getS()
	{
		return s;
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
		if(f[1] == f[2] && f[2] == f[3] && (f[0] == f[1] || f[3] == f[4]))
			return f[2];
		return 0;
	}
	
	public int[] pairs()
	{
		int[] array = new int[2];
		int index = 0;
		for(int i = 0; i < 4; i++)
		{
			if(f[i] == f[i+1])
			{
				array[index] = f[i];
				i++;
				index++;
			}
		}
		return array;
	}
	
	public int threeOfAKind()
	{
		for(int i = 0; i < 3; i++)
		{
			if(f[i] == f[i+1] && f[i+1] == f[i+2])
				return f[i];
		}
		return 0;
	}
	
	public int fullHouse()
	{
		if(f[0] == f[1] && f[3] == f[4] && (f[1] == f[2] || f[2] == f[3]))
			return f[2];
		return 0;
	}
	
	public static void main(String[] args) throws IOException
	{
		int count = 0;
		Scanner scan = new Scanner(new File("54.txt"));
		while(scan.hasNext())
		{
			String s = scan.nextLine();
			Euler54 p1 = new Euler54(s.substring(0,14));
			Euler54 p2 = new Euler54(s.substring(15));
			if(Poker.winner(p1,p2))
				count++;
		}
		System.out.println(count);
	}
	
}
