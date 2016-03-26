
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

	public static void main(String[] args) {
		fib(1,2);
		System.out.println(count);

}
}