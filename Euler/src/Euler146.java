import java.util.*;
public class Euler146 
{
	public static void main(String[] args)
	{
		int limit = 1000000;
		ArrayList<Integer> sieve = Methods.sieve(limit * limit + 27);
	}
}
