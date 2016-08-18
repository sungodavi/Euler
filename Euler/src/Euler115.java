import java.util.*;
public class Euler115 
{
	public static long F(int blockSize,int limit)
	{
		ArrayList<Long> list = new ArrayList<Long>();
		for(int i = 0; i <= blockSize; i++)
			list.add(Long.valueOf(1));
		int size = blockSize - 1;
		while(list.get(size) < limit)
		{
			size++;
			for(int j = blockSize; j <= size; j++)
			{
				for(int k = j; k <= size; k++)
				{
					if(k == size)
						list.set(size,list.get(size) + 1);
					else
						list.set(size, list.get(size) + list.get(size-k-1));
				}
			}
			list.add(Long.valueOf(1));
		}
		return size;
	}
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		System.out.println(F(50,1000000));
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
	}
}
