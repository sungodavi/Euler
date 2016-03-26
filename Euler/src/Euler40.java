
public class Euler40 
{
	public static int getDigit(int num, int place)
	{
		int digits = (int)Math.log10(num) + 1;
		System.out.println(num + " " + place);
		num %= Math.pow(10, digits - place + 1);
		num /= Math.pow(10, digits - place);
		return num;
	}
	public static int solve()
	{
		int ans = 1;
		int digits = 1;
		int checkpoint = 10;
		for(int x=2; x <= 1000000; x++)
		{
			digits += (int)Math.log10(x) + 1;

			if(digits >= checkpoint)
			{
				int temp = digits - checkpoint;
				ans *= getDigit(x, (int)Math.log10(x) + 1 - temp);
				checkpoint *= 10;
			}
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		int x = solve();
		System.out.println(x);
	}
}
