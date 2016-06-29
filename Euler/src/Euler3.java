
public class Euler3 
{
	public static int solve(long num)
	{
		long temp = num;
		int largestFactor = 1;
		while(temp % 2 == 0)
		{
			temp /= 2;
			largestFactor = 2;
		}

		
		int count = 3;
		while(temp != 1)
		{
			while(temp % count == 0)
			{
				temp /= count;
				largestFactor = count;
			}

			count += 2;
		}
		return largestFactor;
	}
	
	public static void main(String args[])
	{
		long input = 600851475143L;
		int output = solve(input);
		System.out.println(output);
	}


}
