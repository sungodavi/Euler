public class Euler68 
{
	public static void swap(int[] a, int x, int y)
	{
		int temp =a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	public static boolean check(int[] a)
	{
		int num = 6 + a[0] + a[1];
		for(int i = 1; i < a.length; i++)
		{
			if(a[i] + a[(i+1) % a.length] + i + 6 != num)
				return false;
		}
		return true;
	}
	public static String solve()
	{
		String max = "";
		int[] a = {1,2,3,4,5};
		for(int i = 2; i <= Methods.fact(a.length); i++)
		{
			System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4]);
			int j = a.length - 2;
			while(j >= 0 && a[j] >= a[j+1])
				j--;
			int l = a.length - 1;
			while(a[j] >= a[l])
				l--;
			swap(a,j,l);
			int k = j+1;
			l = a.length - 1;
			while(k < l)
			{
				swap(a,k,l);
				k++;
				l--;
			}
			if(check(a))
			{
				String s = "";
				for(int x = 0; x < a.length; x++)
					s += "" + (x+6) + a[x] + a[(x+1) % a.length];
				if(s.compareTo(max) > 0)
					max = s;
			}
		}
		return max;
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
