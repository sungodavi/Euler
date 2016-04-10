import java.math.*;
public class Euler206 
{
	
	public static boolean check(BigInteger num)
	{
		if(num.toString().length() != 19)
			return false;
		char digit = 49;
		for(int i = 0; i < 17; i+= 2,digit++)
			if(num.toString().charAt(i) != digit)
				return false;
		
		if(num.toString().charAt(18) == digit)
			return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		BigInteger num = new BigInteger("1010101010");
		while(!check(num.multiply(num)))
		{
			num = num.add(BigInteger.TEN);
		}
		System.out.println(num);
	}

}
