import java.util.*;
import java.awt.Point;
import java.math.*;
public class Geometry 
{
	public static double toDegress(double radian)
	{
		return radian/Math.PI*180;
	}
	
	public static double toRadian(double degree)
	{
		return degree * Math.PI/180;
	}
	
	public static double[] lawOfCosines(long a, long b, long c)
	{
		double A = 1.0 * (c * c + b * b - a*a)/(2 * b * c);
		A = toDegress(Math.acos(A));
		double B = 1.0 * (c * c - b * b + a*a)/(2 * a * c);
		B = toDegress(Math.acos(B));
		
		double[] array = {A,B,180 -  A - B};
		return array;		
	}
	
	public static double shoelaceArea(Point a, Point b, Point c)
	{
		double area = a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y);
		area = Math.abs(area/2);
		return area;
	}
	public static double[] barycentricCoordinates(Point a, Point b, Point c, Point p)
	{
		double ABC = shoelaceArea(a,b,c);
		double ABP = shoelaceArea(a,b,p);
		double ACP = shoelaceArea(a,c,p);
		double BCP = shoelaceArea(b,c,p);
		
		double u = ACP/ABC;
		double v = ABP/ABC;
		double w = BCP/ABC;
		
		double[] array = {u,v,w};
		return array;
	}
	
	public static boolean pointInTriangle(Point a, Point b, Point c, Point p)
	{
		double[] array = barycentricCoordinates(a,b,c,p);
		double sum = 0;
		for(int i = 0; i < array.length; i++)
		{
			sum += array[i];
			if(array[i] < 0 || array[i] > 1)
				return false;
		}
		if(sum <= 1)
			return true;
		return false;
	}
	
}
