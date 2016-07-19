import java.util.*;
import java.math.*;
public class Euler62 
{
	public static String toString(BigInteger num)
	{
		int[] a = Methods.toArray(num);
		Arrays.sort(a);
		String s = "";
		
		for(int i: a)
			s += i;
		
		return s;
	}
	
	public static BigInteger solve()
	{
		HashMap<String, LinkedList<Integer>> map = new HashMap<String, LinkedList<Integer>>();
		int num = 1;
		while(true)
		{
			BigInteger cube = BigInteger.valueOf(num).pow(3);
			String s = toString(cube);
			if(!map.containsKey(s))
			{
				map.put(s, new LinkedList<Integer>());
				map.get(s).add(num);
			}
			else
			{
				map.get(s).add(num);
				if(map.get(s).size() == 5)
				{
					System.out.println(Arrays.toString(map.get(s).toArray()));
					int ans = map.get(s).poll();
					return BigInteger.valueOf(ans).pow(3);
				}
			}
			num++;
		}
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve());
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
