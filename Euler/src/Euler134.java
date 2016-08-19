
public class Euler134 
{
	public static int modInverse(int m, int n, int mod)
	{
		m %= mod;
		n %= mod;
		int a = 1;
		int lastA = 0;
		int b = 0;
		int lastB = 1;
		int q = mod / m;
		int r = mod % m;
		while(r != 0)
		{
			
		}
	}
	
	public static void main(String[] args)
	{
		System.out.println(modInverse(5,4,9));
	}
}
