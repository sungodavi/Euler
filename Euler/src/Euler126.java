
public class Euler126 
{
	public static int solve(int limit)
	{
		int count = 0;
		int index = 0;
		int[] a = new int[limit * 100];
		for(int l = 1; l < a.length/2 - 1; l++)
			for(int w = 1; w <= l; w++)
				for(int h = 1; h <= w; h++)
				{
					int sum = l*h + l*w + w*h;
					System.out.println(l + " " + w + " " + h + " " + sum);
					if(sum >= a.length)
						break;
					a[sum]++;
					if(a[sum] > count)
					{
						count = a[sum];
						index = sum;
					}
					if(count == limit)
						return index*2;
				}
		return -1;
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve(10));
	}
}
