import java.util.Arrays;


public class Euler14 
{
	public static boolean[] array= new boolean[1000000];
	public static long counter = 0;
	public static long ans = 1;

	public static void Euler14()
	{
		Arrays.fill(array, true);
		long temp;
		long count=0;
		for(int x=999999; x>=10; x--)
		{
			if(array[x])
			{
				temp = x;
				count = 0;
				while(temp != 1)
				{
					if(temp % 2 == 0)
					{
						count++;
						temp /= 2;
						if(temp<999999)
							array[(int)(temp)] = false;
					}
					else
					{
						temp = temp * 3 + 1;
						count ++;
					}
				}
				if(count > counter)
				{
					counter = count;
					ans = x;
				}

			}
		}
	}
	
	public static void main(String[] args)
	{
		Euler14();
		System.out.println(Euler14.ans);
	}
}
