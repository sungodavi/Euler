import java.util.*;
public class euler1 {
	//test cloud
	public static void main(String[] args) 
	{
		int count = 0;
		for(int x = 3; x < 1000; x ++)
		{
			if(x%3 == 0 || x%5 == 0)
				count += x;
				
		}
		System.out.println(count);
		//System.out.println(1000/3 + 1000/5 - 1000/10);

	}

}
