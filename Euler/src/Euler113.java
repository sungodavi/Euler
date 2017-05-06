import java.util.Arrays;

public class Euler113 
{
	
	public static int[] num;
	public static int checkInc(int index)
	{
		if(num[index] == 9)
		{
			if(index == 0)
				num[index] = -1;
			else
				num[index] = checkInc(index - 1);
			return num[index];
		}
		return ++num[index];
	}
	public static int checkDec(int index)
	{
		if(num[index] == 0)
		{
			if(index == 0)
				num[index] = -1;
			else
				num[index] = checkDec(index - 1);
			return num[index];
		}
		return --num[index];
	}
	public static int countInc(int size)
	{
		int count = 0;
		num = new int[size];
		num[num.length - 1] = 1;
		while(num[0] != -1)
		{
			checkInc(num.length - 1);
			count++;
			System.out.println(Arrays.toString(num) + count);
		}
		return count;
	}
	
	public static int countDec(int size)
	{
		int count = 0;
		num = new int[size];
		Arrays.fill(num, 9);
		while(num[0] != -1)
		{
			checkDec(num.length - 1);
			count++;
			//System.out.println(Arrays.toString(num) + count);
		}
		return count - 1;
	}
	
	public static int countBouncy(int limit)
	{
		int count = 0;
		for(int i = 1; i <= limit; i++)
			if(Euler112.checkBouncy(i))
				count++;
		return count;
	}
	public static void main(String[] args)
	{
		//System.out.println(countDec(6));
		System.out.println(countInc(6) + countDec(6) - 9);
		System.out.println(countBouncy(999999));
	}
}
