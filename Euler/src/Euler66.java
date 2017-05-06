import java.util.*;
import java.math.BigInteger;
public class Euler66 
{
	public static BigInteger find(ArrayList<Integer> a)
	{
		BigInteger p0 = BigInteger.valueOf(a.get(0)),p1 = p0.multiply(BigInteger.valueOf(a.get(1))).add(BigInteger.ONE);
		BigInteger q0 = BigInteger.ONE,q1 = BigInteger.valueOf(a.get(0));
		if(a.size() % 2 == 0)
			for(int i = 2; i <= 2*(a.size() - 2) + 1; i++)
			{
				if(i < a.size())
				{
					BigInteger temp = p1;
					p1 = BigInteger.valueOf(a.get(i)).multiply(p1).add(p0);
					p0 = temp;
					
					temp = q1;
					q1 = BigInteger.valueOf(a.get(i)).multiply(q1).add(q0);
					q0 = temp;
				}
				else
				{
					BigInteger temp = p1;
					p1 = BigInteger.valueOf(a.get(i % a.size() + 1)).multiply(p1).add(p0);
					p0 = temp;
					
					temp = q1;
					q1 = BigInteger.valueOf(a.get(i % a.size() + 1)).multiply(q1).add(q0);
					q0 = temp;
				}
				
			}
		else
			for(int i = 2; i < a.size() - 1; i++)
			{				
				BigInteger temp = p1;
				p1 = BigInteger.valueOf(a.get(i)).multiply(p1).add(p0);
				p0 = temp;
				
				temp = q1;
				q1 = BigInteger.valueOf(a.get(i)).multiply(q1).add(q0);
				q0 = temp;
			}
		return p1;
	}
	
	public static ArrayList<Integer> continuedFraction(int num)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sqrt = (int)Math.sqrt(num);
		list.add(sqrt);
		int a = -sqrt;
		int d0 = 1;
		int d1 = 1;
		
		do
		{
			a *= -1;
			d1 = num - a*a;
			int gcd = Methods.gcd(d0, d1);
			d1 /= gcd;
			d0 /= gcd;
			int c =  d0 *(sqrt + a) / d1;
			list.add(c);
			a = a*d0 - c*d1;
			d0 = d1;
		}while(d1 != 1 || a != -sqrt);
		return list;		
	}
	
	public static int solve(int limit)
	{
		int maxD = 2;
		BigInteger max = BigInteger.ZERO;
		for(int i = 2; i <= limit; i++)
		{
			if(!(Methods.isPerfectSquare(i)))
			{
				BigInteger x = find(continuedFraction(i));
				if(x.compareTo(BigInteger.ZERO) < 0)
					System.out.println("error");
				if(x.compareTo(max) > 0)
				{
					maxD = i;
					max = x;
				}
			}
			
		}
		return maxD;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(1000));
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}	
}
