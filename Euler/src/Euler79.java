import java.util.*;
import java.io.*;
public class Euler79 
{
	public ArrayList<int[]> list = new ArrayList<int[]>();
	public HashSet<Integer>[] ans = new HashSet[10];
	public void read() throws IOException
	{
		Scanner scan = new Scanner(new File("79.txt"));

		while(scan.hasNextInt())
			list.add(Methods.toArray(scan.nextInt()));
	}
	
	public void display()
	{
		for(int i = 0; i < ans.length; i++)
			ans[i] = new HashSet<Integer>();
		
		for(int[] a: list)
		{
			ans[a[1]].add(a[0]);
			ans[a[2]].add(a[0]);
			ans[a[2]].add(a[1]);
		}
		int iterator = 0;
		for(HashSet<Integer> set : ans)
			System.out.println(iterator++ + ": " + Arrays.toString(set.toArray()));
	}
	
	public int solve()
	{
		//find numbers that don't appear
		boolean nums[] = new boolean[10];
		Arrays.fill(nums, false);
		for(int[] a: list)
			for(int i: a)
				nums[i] = true;
		
		//find key size
		int size = -1;
		for(HashSet<Integer> set: ans)
		{
			size = Integer.max(size, set.size());
		}
		
		//solve
		String s = "";
		for(int i = 0; i <= size; i++)
		{
			for(int index = 0; index < ans.length; index++)
			{
				if(ans[index].size() == i && nums[index])
					s += index;
			}
		}
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException
	{
		Euler79 test = new Euler79();
		test.read();
		test.display();
		System.out.println(test.solve());
	}
}
