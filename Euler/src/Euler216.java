
public class Euler216 
{
	public static void main(String[] args)
	{
		for(int i = 2; i <= 36; i++)
		{
			int num = i*i*2 - 1;
			if(!Methods.checkPrime(num))
				System.out.println(i + ": " + num);
		}
	}
}
