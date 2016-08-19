class Fraction
{
	long n, d;
	public Fraction(long num, long denom)
	{
		n = num;
		d = denom;
		long gcd = Methods.gcd(n, d);
		n /= gcd;
		d /= gcd;
	}
	public String toString()
	{
		return n + "/" + d;
	}
	public boolean checkTerminating()
	{
		long temp = d;
		
		while(temp % 2 == 0)
			temp /= 2;
		while(temp % 5== 0)
			temp /= 5;
		
		return temp == 1;
	}
	public boolean equals(Fraction f)
	{
		return n == f.n && d == f.d;
	}
	public int compare(Fraction f)
	{
		if(n*f.d > d*f.n)
			return 1;
		if(n*f.d == d*f.n)
			return 0;
		return -1;
	}
}
public class Euler183 
{
	public static int M(int n)
	{
		int limit = (int)(Math.round(1.0 * n/Math.E));
		int gcd = Methods.gcd(n,limit);
		Fraction f1 = new Fraction(n/gcd,limit/gcd);
		if(f1.checkTerminating())
			return -n;
		return n;
	}
	public static int solve(int limit)
	{
		int sum = 0;
		for(int i = 5; i <= limit; i++)
			sum += M(i);
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(solve(10000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
