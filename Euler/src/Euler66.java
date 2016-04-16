import java.util.*;
public class Euler66 
{
	public static long Diophantine(int D)
	{
		long  x = D;
		while(true)
		{
			for(long i = 1; !Methods.isPerfectSquare(x + 1); i++)
			{
				x = D * i * i;
			}
			
			x += 1;
			//System.out.println(x);
			if(Methods.isPerfectSquare((x - 1)/D))
			{
				System.out.println(D + " = " + Math.sqrt(x) + "^2");
				return (int)Math.sqrt(x);
			}
			x += D - 1;
		}
		
	}
	
	public static void main(String[] args)
	{
		int max = -1;
		long maxD = 0;
		for(int i = 2; i <= 10000; i++)
		{
			if(!Methods.isPerfectSquare(i))
			{
				long diophantine = Diophantine(i);
				if(diophantine > maxD)
				{
					maxD = diophantine;
					max = i;
				}
			}
		}
		System.out.println("ans: " + max);
	}
	
}
