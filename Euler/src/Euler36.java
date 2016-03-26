import java.lang.*;

public class Euler36 
{
	static boolean isPalindrome(String str) 
	{    
	    int n = str.length();
	    for(int i = 0; i < n/2; i++ )
	        if (str.charAt(i) != str.charAt(n-i-1)) return false;
	    return true;    
	}
	
	static long Euler36()
	{
		long sum = 0;
		for(int x = 1; x <= 1000000; x++)
		{
			if(isPalindrome(x + ""))
			{
				if(isPalindrome(Integer.toString(x, 2)))
				{
					sum += x;
					//System.out.println(x + " " + Integer.toString(x, 2));
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args)
	{
		long x = Euler36();
		System.out.println(x);
	}
	
}
