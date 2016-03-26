import java.util.Arrays;

public class Euler35 {
	public static int[] toArray(int num) {
		int digits = (int) Math.log10(num) + 1;
		int[] array = new int[digits];
		for (int x = digits - 1; x > 0; x--) {
			array[x] = num % 10;
			num /= 10;
		}
		array[0] = num;
		return array;
	}

	public static long toInt(int[] a) {
		long ans = 0;
		for (int x = 0; x < a.length; x++) {
			ans += a[x] * Math.pow(10, a.length - x - 1);
		}
		return ans;
	}

	public static boolean checkPrime(long num) {
		if(num == 1)
			return false;
		if (num == 2)
			return true;
		if (num % 2 == 0)
			return false;
		for (int x = 3; x <= Math.sqrt(num); x++) {
			if (num % x == 0)
				return false;
		}
		return true;
	}
	
	public static boolean[] sieve(int num) {
		boolean ans[] = new boolean[num + 1];
		Arrays.fill(ans, true);
		ans[0] = false;
		ans[1] = false;
		for (int i = 2; i <= Math.ceil(Math.sqrt(num)); i++) {
			for (int j = i * 2; j <= num; j += i) {
				ans[j] = false;
			}
		}
		return ans;
	}
	
	public static boolean rotations(int num)
	{
		int[] array = toArray(num);
		int digits = (int)(Math.log10(num)) + 1;
		for(int x = 0; x < digits - 1; x++)
		{
			int[] temp = Arrays.copyOf(array, digits);
			temp[0] = array[digits - 1];
			for(int a = 1; a < digits; a++)
				temp[a] = array[a-1];
			
			
			array = temp;
			
			
			if(!checkPrime(toInt(array)))
				return false;
		}
		return true;
	}
	
	public static int solve()
	{
		boolean[] nums = sieve(1000000);
		int count = 13;
		for(int x = 101; x < nums.length; x += 2)
		{
			if(nums[x])
				if(rotations(x))
					count++;
		}
		return count;	
	}
	
	public static void main(String[] args)
	{
		System.out.println(solve());
	}
}
