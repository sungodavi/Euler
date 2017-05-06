
public class Euler126 
{
	public static int solve(int limit)
	{
<<<<<<< HEAD
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
=======
		int[] a = new int[1000000];
		int maxL = (limit - 2) / 4;
		for(int l = 1; l <= maxL; l++)
		{
			for(int w = 1; w <=l; w++)
			{
				if(l + w + l*w > limit)
					break;
				for(int h = 1; h <= w; h++)
				{
					int sum = l*h + w*h + l*h;
					if(sum > limit)
						break;
					a[sum]++;
				}
			}
		}
>>>>>>> branch 'master' of https://github.com/sungodavi/Euler.git
	}
}
