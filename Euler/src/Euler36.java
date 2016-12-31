

public class Euler36 
{
	static boolean isPalindrome(String str) 
	{    
	    int n = str.length();
	    for(int i = 0; i < n/2; i++ )
	        if (str.charAt(i) != str.charAt(n-i-1)) 
	        	return false;
	    
	    return true;    
	}
	
	static long solve()
	{
		long sum = 0;
		for(int x = 1; x <= 1000000; x++)
			if(isPalindrome(x + ""))
				if(isPalindrome(Integer.toString(x, 2)))
					sum += x;
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long x = solve();
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}
	
}
