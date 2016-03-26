
public class Euler4 
{
	public static boolean palindrome(int num)
	{
		int[] digits = new int[(int)(Math.ceil(Math.log10(num)))];
		int temp = num;
		for(int x=0; x< Math.ceil(Math.log10(num)); x++)
		{
			digits[x] = temp % 10;
			temp /= 10;
		}
		int end = digits.length-1;
		int count = 0;
		boolean ans;
		for(int n=0; n< digits.length; n++)
		{
			if(digits[n] == digits[end-n])
				count ++;
		}
		if(count == digits.length)
			return true;
		return false;
	}
	
	public static int findPrime(int a, int b)
	{
		int ans = 0;
		for(int x = 999; x>=100; x--)
		{
			for(int y = 999; y >= 100; y--)
			{
				if(palindrome(x*y) && x*y > ans)
					ans = x*y;
			}
		}
		return ans;
	}
	public static void main(String[] args)
	{
		int x = findPrime(999,999);
		System.out.println(x);
	}

}
