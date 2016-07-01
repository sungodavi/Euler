import java.util.*;
public class Euler60 
{
	public static ArrayList<Integer> sieve = Methods.sieve(10000);
	public static HashSet<Integer> makePairs(int p)
	{
		int p1 = sieve.get(p);
		HashSet<Integer> pairs = new HashSet<Integer>();
		for(int i = 1; i < sieve.size(); i++)
		{
			int p2 = sieve.get(i);
			if(checkConcat(p1,p2))
				pairs.add(p2);		
		}
		return pairs;
	}
	public static boolean hasPairs(int p)
	{
		int p1 = sieve.get(p);
		HashSet<Integer> pairs = new HashSet<Integer>();
		for(int i = p + 1; i < sieve.size(); i++)
		{
			int p2 = sieve.get(i);
			if(checkConcat(p1,p2))
				return true;		
		}
		return false;
	}
	public static boolean checkConcat(int p1, int p2)
	{
		return Methods.checkPrime(Integer.parseInt("" + p1 + p2)) && 
				Methods.checkPrime(Integer.parseInt("" + p2 + p1));
	}
	
	public static HashSet<Integer> intersection(HashSet<Integer> s1, HashSet<Integer> s2)
	{
		s1.retainAll(s2);
		return s1;
	}
	
	public static void main(String[] args)
	{
		HashSet<Integer>[] pairs = new HashSet[sieve.size()];
		for(int i = 0; i < pairs.length; i++)
		{
			pairs[i] = makePairs(i);
		}
		
	}
}
