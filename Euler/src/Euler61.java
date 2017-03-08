import java.util.*;

public class Euler61 
{
	public static ArrayList<Integer>[] sets;
	public static int recurse(int og ,int current, int count, HashSet<Integer> used)
	{
		if(count == 0)
		{
			if(og / 100 == current % 100)
				return current;
		}
		for(int i = 3; i <= 8; i++)
		{
			if(used.contains(i))
				continue;
			for(int num: sets[i])
			{
				used.add(i);
				if(num / 100 == current % 100)
				{
					int r;
					if(og == 0)
						r = recurse(num, num, count - 1, used);
					else
						r = recurse(og, num, count - 1, used);
					if(r > 0)
						return r + current;
				}
				used.remove(i);
			}
		}
		return 0;
	}
	
	public static ArrayList<Integer> triangle()
	{
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 45; i <= 140; i++)
			l.add(i * (i + 1) / 2);
		return l;
	}
	
	public static ArrayList<Integer> square()
	{
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 32; i <= 99; i++)
			l.add(i * i);
		return l;
	}
	
	public static ArrayList<Integer> pentagon()
	{
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 26; i <= 81; i++)
			l.add(i * (3 * i - 1) / 2);
		return l;
	}
	
	public static ArrayList<Integer> hexagon()
	{
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 23; i <= 70; i++)
			l.add(i * (2 * i - 1));
		return l;
	}
	
	public static ArrayList<Integer> heptagon()
	{
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 21; i <= 63; i++)
			l.add(i * (5 * i - 3) / 2);
		return l;
	}
	
	public static ArrayList<Integer> octagon()
	{
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(int i = 19; i <= 58; i++)
			l.add(i * (3 * i - 2));
		return l;
	}
	
	public static void load()
	{
		sets = new ArrayList[9];
		sets[3] = triangle();
		sets[4] = square();
		sets[5] = pentagon();
		sets[6] = hexagon();
		sets[7] = heptagon();
		sets[8] = octagon();
		
	}
	
	public static int solve()
	{
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(3);
		for(int i: sets[3])
		{
			int r = recurse(i,i,5,set);
			if(r > 0)
				return r;
		}
		return -1;
	}
	public static void main(String[] args)
	{
		load();
		System.out.println(solve());
	}
}
