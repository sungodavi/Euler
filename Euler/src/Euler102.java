import java.util.*;
import java.io.*;
import java.awt.*;
public class Euler102 
{
	public static void main(String[] args) throws IOException
	{
		Point p = new Point(0,0);
		Point a,b,c;
		Scanner scan = new Scanner(new File("102.txt"));
		int count = 0;
		System.out.println(p);
		while(scan.hasNext())
		{
			String s = scan.nextLine();
			String[] array = s.split(",");
			a = new Point(Integer.parseInt(array[0]),Integer.parseInt(array[1]));
			b = new Point(Integer.parseInt(array[2]),Integer.parseInt(array[3]));
			c = new Point(Integer.parseInt(array[4]),Integer.parseInt(array[5]));
			if(Geometry.pointInTriangle(a, b, c, p))
			{
				System.out.println("Triangle (" + a.x + "," + a.y + ")" + "," + "(" + b.x + "," + b.y + ")" + "," + "(" + c.x + "," + c.y + ")" + " contains origin");
				count++;
			}
			else
				System.out.println("Triangle (" + a.x + "," + a.y + ")" + "," + "(" + c.x + "," + c.y + ")" + "," + "(" + c.x + "," + c.y + ")" + "DOES NOT contains origin");

		}
		System.out.println(count);
	}
}
