import java.math.*;
public class Euler206 
{
	public static BigInteger x = new BigInteger("101010101");
	public static boolean checkSquare(BigInteger num)
	{
		BigInteger sqrt = Methods.sqrt(num);
		return sqrt.multiply(sqrt).equals(num);
	}
	
	public static void main(String[] args)
	{
		
		//System.out.println(checkSquare(new BigInteger("1389019170")));
		String s = "you suck dick";
		outer:
		for(int a = 9; a >= 0; a--)
			for(int b = 9; b >= 0; b--)
				for(int c = 9; c >= 0; c--)
					for(int d = 9; d >= 0; d--)
						for(int e = 9; e >= 0; e--)
							for(int f = 9; f >= 0; f--)
								for(int g = 9; g >= 0; g--)
									for(int h = 9; h >= 0; h--)
									{
										s = "1" + a + "2" + b + "3" + c + "4" + d + "5" + e +"6" + f + "7" + g +"8" + h +"9";
										//System.out.println(s);
										if(checkSquare(new BigInteger(s)))
											break outer;
									}
		System.out.println("sqrt of " + s + "00 is: " + Methods.sqrt(new BigInteger(s)) + "0");
									
	}

}
