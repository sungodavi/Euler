import java.util.ArrayList;

public class Euler24 
{
	public static ArrayList<String> numbers = new ArrayList<String>(5);
	
	public static void fill()
	{
		for(int x=0; x< 10; x++)
		{
			numbers.add(Integer.toString(x));
		}
	}
	
	public static int Factorial(int num)
	{
		int ans=1;
		for(int x=2; x<= num; x++)
			ans *= x;
		return ans;
	}
	
	public static int[] makeArray()
	{
		int[] array = new int[10];
		int num = 1000000;
		for(int x=9; x>1; x--)
		{
			int temp =1;
			while(temp * Factorial(x) < num)
			{
				temp++;
			}
			num -= (temp-1) * Factorial(x);
			array[x] = temp;
		}
		return array;
	}
	
	public static void main(String[] args)
	{
		int ans = 0;
		int[] array = {2, 6, 6, 2, 5, 1, 2, 1, 2};
		for(int x=9, y=0; y<8; x--, y++)
		{
			ans += array[y] * Factorial(x);
		}
		System.out.println(ans);
	}
}
