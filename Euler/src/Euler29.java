import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Euler29 
{
	
	public static void main(String[] args)
	{
		ArrayList<Double> set = new ArrayList<Double>();
		for (int a = 2; a <= 100; a++) {
		    for (int b = 2; b <= 100; b++) {
		        double result = Math.pow(a,b);
		        if (!set.contains(result)) {
		            set.add(result);
		        }
		    }
		}
		System.out.println(set.size());
	}

}
