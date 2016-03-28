
public class Euler85 
{
	public static long solve(int l, int w)
	{
		return l * (l+1) * w * (w+1)/4;
	}
	
	public static void main(String[] args)
	{
		int target = 2000000;
		long error = Integer.MAX_VALUE;
		int area = 0;
		int l1 = 0;
		int w1 = 0;
		for(int l = 1; l < 1415; l++)
		{
			for(int w = l; w < 1415; w++)
			{
				long rectangles = solve(l,w);
				if(rectangles <= target && target-rectangles < error)
				{
					error = target-rectangles;
					area = l * w;
					l1 = l;
					w1 = w;
				}
			}
		}
		System.out.println(l1 + " * " + w1 + " = " + area + ". Produced " + solve(l1,w1) + " rectangles.");
	}

}
