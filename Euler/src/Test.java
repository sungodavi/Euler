
public class Test 
{
	public static void main(String[] args)
	{
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		int[] test = {2,1,4,7,3,9,8,6,5,0};
		int[] test2 = {2, 1, 4, 7, 5, 9, 8, 6, 3, 0};
		Euler43 x = new Euler43(array);
		x.permutations();
		System.out.println(x.sum);
	}

}
