import java.math.BigInteger;

public class Euler26 {

	public static void main(String[] args) {
		BigInteger temp = BigInteger.TEN;
		BigInteger check = BigInteger.ONE;
		int[] ans = new int[2];

		for (int n = 999; n > 1; n--) 
		{
			if (n % 2 != 0 || n % 5 != 0) 
			{
				for (int s = 0; s < 10; s++) 
				{
					for (int k = 1; k < n; k++) 
					{
						if (temp.pow(k + s).mod(BigInteger.valueOf(n)).equals(temp.pow(s))) 
						{
							//System.out.println(n + " " + k);
							if (k > ans[0]) 
							{
								ans[0] = k;
								ans[1] = n;
							}
							break;
						}
					}
				}
			}
		}
		System.out.println(ans[1]);
	}
}
