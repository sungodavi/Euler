
public class Euler41 
{
	public static int fact(int num)
	{
		int ans = 1;
		for(int x = 2; x <= num; x++)
		{
			ans *= x;
		}
		return ans;
	}
	
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
	
	public static long toInt(int[] array)
	{
		long ans = 0;
		for(int x = 0; x< array.length; x++)
		{
			ans += array[x] * Math.pow(10,array.length - x - 1);
		}
		return ans;
	}
	
	public static boolean checkPrime(long num)
	{
		if(num % 2 == 0)
			return false;
		for(int x = 3; x <= Math.sqrt(num); x++)
		{
			if(num % x == 0)
				return false;
		}
		return true;
	}
	
	public static long permutations(int[] a)
	{
		long ans = 0;
		for(int i = 0; i < fact(a.length); i++)
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
			//System.out.println(toInt(a));
			if(checkPrime(toInt(a)) && toInt(a) > ans)
				ans = toInt(a);
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
		long x = solve();
		System.out.println(x);
	}
}
