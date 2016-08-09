
public class Euler41 
{
	public static int[] build(int num)
	{
		int[] ans = new int[num];
		for(int x = 0; x < num; x++)
		{
			ans[x] = x+1;
		}
		return ans;
	}
	
	public static int[] swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		return array;
	}
	
	
	public static long permutations(int[] a)
	{
		long ans = 0;
		for(int i = 0; i < Methods.fact(a.length); i++)
		{
			int j = a.length - 2;
			int l = j + 1;
			while(j > 0 && a[j] > a[j + 1])
				j--;
			int k = j+1;
			
			while(l > 0 && a[l] < a[j])
				l--;
			
			swap(a,j,l);
			
			l = a.length - 1;
			while(k < l)
			{
				swap(a,k,l);
				l--;
				k++;
			}

			int num = Methods.toInt(a);
			if(Methods.checkPrime(num) && num > ans)
				ans = num;
		}
		return ans;
	}
	
	public static long solve()
	{
		long ans = 0;
		for(int x = 3; x < 10; x++)
		{
			long temp = permutations(build(x));
			if(temp > ans)
				ans = temp; 
		}
		return ans;
		
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long x = solve();
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
