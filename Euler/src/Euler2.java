
public class Euler2 {
	public static int count = 2; // counter for fibonacci numbers
	public static void fib(int num1, int num2)
	{
		if(num1 < 4000000) // 4 million
		{
			if((num2+num1) % 2 == 0)
				count += num2 + num1;
			fib(num2, num2+num1);
		}
		
	}

	public static void main(String[] args) 
	{
		long startTime = System.currentTimeMillis();
		fib(1,2);
		System.out.println(count);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}