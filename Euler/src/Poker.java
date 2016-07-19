import java.util.Arrays;

public class Poker 
{
	public static boolean winner(Euler54 p1, Euler54 p2)
	{
		int[] p1Val = {p1.highCard(),p1.pairs()[0],p1.pairs()[1],p1.threeOfAKind(),p1.straight(),p1.checkFlush(), p1.fullHouse(), p1.fourOfAKind(), p1.checkStraightFlush(), p1.checkRoyalFlush()};
		int[] p2Val = {p2.highCard(),p2.pairs()[0],p2.pairs()[1],p2.threeOfAKind(),p2.straight(),p2.checkFlush(), p2.fullHouse(), p2.fourOfAKind(), p2.checkStraightFlush(), p2.checkRoyalFlush()};
		for(int i = p1Val.length - 1; i >= 0; i--)
		{
			if(p1Val[i] > p2Val[i])
				return true;
			
			if(p1Val[i] == p2Val[i] && p1Val[i] != 0)
			{
				System.out.println("high card deciding");
				int highCardIndex = 4;
				while(highCardIndex >= 0 && p1.getF()[highCardIndex] == p2.getF()[highCardIndex])
					highCardIndex --;
				
				if(p1.getF()[highCardIndex] > p2.getF()[highCardIndex])
					return true;
				return false;
			}
			if(p2Val[i] > p1Val[i])
				return false;
		}
		System.out.println("Undecided");
		return false;

	}
}
