import java.util.*;
public class Sort 
{
	private static int[] a;
	private static int[] tempA;
	public Sort(int[] input)
	{
		a = input;
	}
	public void display()
	{
		System.out.println(Arrays.toString(a));
	}
	public void swap(int i)
	{
		int temp = a[i - 1];
		a[i-1] = a[i];
		a[i] = temp;
	}
	public void swap(int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	//static sorting method
	public static int[] swap(int[] a, int x, int y)
	{
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
		return a;
	}
	public static int[] sort(int[] a)
	{
		for(int i = 1; i < a.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(a[j] < a[j-1])
					a = swap(a,j,j-1);
			}
		}
		return a;
	}
	
	
	//Merge Sorting Algorithm
	public void MergeSort()
	{
		tempA = new int[a.length];
		seperate(0,a.length - 1);
	}
	
	public void seperate(int start, int end)
	{
		int middle = end + start;
		middle /= 2;
		if(start < end)
		{
			seperate(start,middle);
			
			seperate(middle + 1,end);
			
			build(start,middle,end);
		}
	}
	
	public void build(int start, int middle, int end)
	{
		int s = start;
		int m = middle + 1;
		int k = s;
		
		for(int i = s; i <= end; i++)
		{
			tempA[i] = a[i];
		}
		
		//sorts between 2 arrays
		while(s <= middle && m <= end)
		{
			if(tempA[s] <= tempA[m])
			{
				a[k] = tempA[s];
				s++;
			}
			else
			{
				a[k] = tempA[m];
				m++;
			}
			k++;
			
		}
		//adds remaining numbers
		while(s <= middle)
		{
			a[k] = tempA[s];
			k++;
			s++;
		}
	}
	
	//Insertion Sort Algorithm
	public void InsertionSort()
	{
		for(int i = 1; i < a.length; i++)
		{
			for(int j = i; j > 0; j--)
			{
				if(a[j] < a[j-1])
					swap(j);
			}
		}
	}
	
	//Bubble sort algorithm
	public void BubbleSort()
	{
		boolean change = true;
		while(change)
		{
			change = false;
			for(int i = 1; i < a.length; i++)
			{
				if(a[i] < a[i-1])
				{
					change = true;
					swap(i);
				}
			}
		}
	}
	//Selection Sort
	public void SelectionSort()
	{
		for(int i = 0; i < a.length - 1; i++)
		{
			int small = 0;
			int index = 0;
			for(int j = i; j < a.length; j++)
			{
				if(a[j] < small)
					swap(i);
			}
		}
	}
	
	//Quick Sort Algorithm
	
	public void QuickSort()
	{
		pivot(0,a.length - 1);
	}
	
	public void pivot(int start, int end)
	{
		if(start < end)
		{
			partition(start,end);
			int middle = start + end;
			middle /=2;
			pivot(start, middle);
			pivot(middle + 1,end);
		}
	}
	
	public void partition(int start, int end)
	{
		int pivot = a[(start + end)/2];
		while(start < end)
		{
			while(a[start] < pivot)
				start++;
			while(a[end] > pivot)
				end--;
			if(start < end)
			{
				swap(start,end);
				start++;
				end--;
			}
		}
	}
}


