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
	
	public static void main(String[] args)
	{
		String test;
	}
	
}
