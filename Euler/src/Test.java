public class Test 
{
	public static boolean checkTri(long num)
	{
		return Math.sqrt(num * 2 + .25) - .5 == (int)Math.sqrt(num*2+.25); 
	}
	public static boolean checkPent(long num)
	{
		for(int i = (int)Math.sqrt(num)/2; i * (3 * i-1) <= 2 * num; i++)
			if(i * (3 * i - 1) == 2 *  num)
				return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		Methods.sieve(100000000);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
		
		/*
		SortedSet<Integer> t1 = new TreeSet<Integer>();
		SortedSet<Integer> s1 = new TreeSet<Integer>();
		SortedSet<Integer> p1 = new TreeSet<Integer>();
		for(int i = 1; i <= 100; i++)
		{
			t1.add(((i * (i + 1))/2) % 100);
			s1.add((i*i)%100);
			p1.add((i * (3 * i - 1)/2) % 100);
		}
		
		SortedSet<Integer> t2 = new TreeSet<Integer>();
		SortedSet<Integer> s2= new TreeSet<Integer>();
		SortedSet<Integer> p2 = new TreeSet<Integer>();
		
		for(int t = 45; t < 141; t++)
			t2.add(((t * (t + 1))/2) / 100);
		for(int s = 32; s < 100; s++)
			s2.add((s*s)/100);
		for(int p = 26; p < 82; p++)
			p2.add((p * (3 * p - 1)/2) / 100);
		
		for(Integer end: t1)
		{
			int[][] ans = new int[3][2];
			ans[0][1] = end;
			outer:
			for(Integer start: t2)
			{
				if(checkTri(100 * start + end))
				{
					ans[0][0] = start;
					if(s1.contains(start))
					{
						ans[2][1] = start;
						ans[1][0] = end;
						for(Integer mid: s2)
						{
							if(Methods.isPerfectSquare(100 * mid + start) && checkPent(100 * end + mid))
							{
								ans[1][1] = mid;
								ans[2][0] = mid;
								for(int[] a: ans)
								{
									System.out.println(100 * a[0] + a[1]);
								}
								break outer;
							}
						}
					}
					if(p1.contains(start))
					{
						ans[2][1] = start;
						ans[1][0] = end;
						for(Integer mid: p2)
						{
							if(checkPent(100 * mid + start) && Methods.isPerfectSquare(100 * end + mid))
							{
								ans[1][1] = mid;
								ans[2][0] = mid;
								for(int[] a: ans)
								{
									System.out.println(100 * a[0] + a[1]);
								}
								break outer;
							}
						}
					}
				}
			}
			
		*/
	}
}
