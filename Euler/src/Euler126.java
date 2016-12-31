
public class Euler126 
{
	public static int solve(int limit)
	{
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
	}
}
