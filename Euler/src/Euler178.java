
public class Euler178 
{
	public static boolean check(String num)
	{
		for(int i = 0; i <= 9; i++)
		{
			if(!num.contains(Integer.toString(i)))
				return false;
		}
		return true;
	}
	public static long recurse(String num)
	{
		if(num.length() == 40)
			if(check(num))
				return 1;
		int digit = num.charAt(num.length() - 1) - '0';
		int sum = 1;
		if(digit < 9)
			sum += recurse(num + Integer.toString(digit + 1));
		if(digit > 0)
			sum += recurse(num + Integer.toString(digit - 1));
		return sum;
	}
	
	public static void main(String[] args)
	{
		System.out.println(recurse("1"));
	}
}
