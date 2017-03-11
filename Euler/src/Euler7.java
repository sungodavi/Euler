public class Euler7 
{
	public static int findPrime(int numOfPrimes)
	{
		int[] prime = new int[numOfPrimes];
		prime[0] = 2;
		int n = 3;
		int index = 0;
		while(index < numOfPrimes - 1)
		{
			index++;
			prime[index] = n;
			outer:
			while(true)
			{
				n+=2;
				int k =1;
				while(true)
				{
					if(n % prime[k] == 0)
						break;
					if(n/prime[k] <= prime[k])
						break outer;
					k++;
				}
			}
		}
		return prime[numOfPrimes - 1];
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		long x = findPrime(10001);
		System.out.println(x);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	}

}
