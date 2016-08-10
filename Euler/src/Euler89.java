import java.util.*;
import java.io.*;
public class Euler89 
{
	private static Map<String,Integer> roman = new HashMap<String,Integer>();
	private static String Roman;
	private static int arabic;
	private static String improved;
	
	public Euler89(String input)
	{
		Roman = input;
		roman.put("I",1);
		roman.put("V",5);
		roman.put("X",10);
		roman.put("L",50);
		roman.put("C",100);
		roman.put("D",500);
		roman.put("M",1000);
		roman.put("IV", 4);
		roman.put("IX", 9);
		roman.put("XL", 40);
		roman.put("XC", 90);
		roman.put("CD", 400);
		roman.put("CM", 900);
		toArabic();
		toRoman();
	}
	
	public void toArabic()
	{
		int ans = 0;
		Object temp;
		String r = Roman;
		while(r.length() > 0)
		{
			boolean incomplete = true;;
			if(r.length() > 0)
			{
				if(r.length() > 1)
				{
					temp = r.substring(0, 2);
					if(roman.containsKey(temp))
					{
						incomplete = false;
						ans += (int)roman.get(temp);
						r = r.substring(2);
					}
				}
				if(incomplete)
				{
					temp = r.substring(0,1);
					ans += (int)roman.get(temp);
					r = r.substring(1);
				}
			}
			System.out.println(r + " " + ans);
		}
		arabic = ans;
	}
	
	public void toRoman()
	{
		String s = "";
		int temp;
		//check for M
		for(int i = 1; i <= arabic/1000; i++)
			s+= "M";
		
		//check for C and D
		temp = arabic/100;
		temp %= 10;
		if(temp == 4)
		{
			s += "CD";
			temp = 0;
		}
		else if(temp == 9)
		{
			s += "CM";
			temp = 0;
		}
		else if(temp >= 5)
		{
			s += "D";
			temp -= 5;
		}
		for(int i = 1; i <= temp; i++)
		{
			s += "C";
		}
		//check for X and L
		
		temp = arabic/10;
		temp %= 10;
		if(temp == 4)
		{
			s += "XL";
			temp = 0;
		}
		else if(temp == 9)
		{
			s += "XC";
			temp = 0;
		}
		else if(temp >= 5)
		{
			s += "L";
			temp -= 5;
		}
		for(int i = 1; i <= temp; i++)
		{
			s += "X";
		}
		
		//check for I and V
		temp = arabic;
		temp %= 10;
		if(temp == 4)
		{
			s += "IV";
			temp = 0;
		}
		else if(temp == 9)
		{
			s += "IX";
			temp = 0;
		}
		else if(temp >= 5)
		{
			s += "V";
			temp -= 5;
		}
		for(int i = 1; i <= temp; i++)
		{
			s += "I";
		}
		improved = s;		
	}
	
	public int solve()
	{
		System.out.println(Roman + " = " + improved + " = " + arabic);
		System.out.println("solve: " + (Roman.length() - improved.length()));
		return Roman.length() - improved.length();
	}
	public static void main(String[] args) throws IOException
	{
		long startTime = System.currentTimeMillis();
		Scanner scan = new Scanner(new File("89.txt"));
		long ans = 0;
		while(scan.hasNext())
		{
			String s = scan.nextLine();
			Euler89 num = new Euler89(s);
			ans += num.solve();
		}
		System.out.println(ans);
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time: " + (1.0 * totalTime/1000) + " seconds");
		scan.close();
	}

}