
public class Euler91 
{
	 public static long solve(int size)
	 {
		 int result = 3 * size * size;
		 for(int x = 1; x <= size; x++)
		 {
			 for(int y = 1; y <= size; y++)
			 {
				 int d = Methods.gcd(x, y);
				 result += 2 * (Integer.min(y * d/x, (size-x) * d/y));
			 }
		 }
		 return result;
	 }
	 
	 public static void main(String[] args)
	 {
		 long startTime = System.currentTimeMillis();
		 System.out.println(solve(50));
		 long endTime   = System.currentTimeMillis();
		 long totalTime = endTime - startTime;
		 System.out.println("Total Time: " + (1.0 * totalTime/1000) + " seconds");
	 }
}
