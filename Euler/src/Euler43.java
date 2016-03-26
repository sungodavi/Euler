import java.math.BigInteger;
public class Euler43 {
	public static int[] a;
	public static BigInteger sum = BigInteger.ZERO;

	public Euler43(int[] array) {
		a = array;
	}
	
	public static long build()
	{
		long ans = 0;
		for(int x = 0; x< a.length; x++)
		{
			ans += a[x] * Math.pow(10,a.length - x - 1);
		}
		return ans;
	}

	public static void swap(int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	public static void display() {
		for (int x = 0; x < a.length; x++) {
			System.out.print(a[x]);
		}
		System.out.println();
	}

	public static long fact(int num) {
		int ans = 1;
		for (int x = 2; x <= num; x++)
			ans *= x;
		return ans;
	}

	public static boolean check() {
		if ((a[1] * 100 + a[2] * 10 + a[3]) % 2 == 0)
			if ((a[2] * 100 + a[3] * 10 + a[4]) % 3 == 0)
				if ((a[3] * 100 + a[4] * 10 + a[5]) % 5 == 0)
					if ((a[4] * 100 + a[5] * 10 + a[6]) % 7 == 0)
						if ((a[5] * 100 + a[6] * 10 + a[7]) % 11 == 0)
							if ((a[6] * 100 + a[7] * 10 + a[8]) % 13 == 0)
								if ((a[7] * 100 + a[8] * 10 + a[9]) % 17 == 0)
									return true;
		return false;
	}

	public static void permutations() {
		for (int x = 0; x < fact(a.length) + 123; x++) 
		{
			int j = a.length - 2;
			
			while (j > 0 && a[j] >= a[j + 1]) 
				j--;

			int l = a.length - 1;
			while (l > 0 && a[j] >= a[l]) 
				l--;
			
			swap(j, l);
			

			int k = j + 1;
			l = a.length - 1;
			
			
			while (k < l) 
			{
				swap(k, l);
				k++;
				l--;
			}

			if (check())
			{
				System.out.println(build());
				
				sum = sum.add(BigInteger.valueOf(build()));
			}

		}

	}

}
