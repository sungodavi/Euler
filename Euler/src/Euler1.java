public class Euler1 
{
	
	public static int solve()
	{
		int count = 0;
		for(int x = 3; x < 1000; x+=3)
			count += x;
		
		for(int x = 5; x < 1000; x+=5)
			count += x;
		
		for(int x = 15; x < 1000; x+=15)
			count -= x;
		
		return count;
	}
	
	
	public static void main(String[] args) 
	{
		
		System.out.println(solve());

	}

}
