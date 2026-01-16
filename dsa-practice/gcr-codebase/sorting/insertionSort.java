import java.util.*;
public class insertionSort
{
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter employees id's in an array");
	int len=sc.nextInt();
	int [] arr = new int[len];
	
	//here we initialize an array
	for(int i=0;i<len;i++)
	{
	    arr[i]=sc.nextInt();
	}
	
	System.out.println("\nArray before sorting");
	display(arr);
	insertElement(arr);
	System.out.println("\nArray before sorting");
	display(arr);
	}
	//insertion sort technique
	public static void insertElement(int[]arr)
	{
	  for(int i=1;i<arr.length;i++)
	{
	    sortingTechnique(arr,i);
	}  
	}
	public static void sortingTechnique(int[]arr,int i)
	{
	    int item=arr[i];
	    int j=i-1;
	    while(j>=0&&arr[j]>item)
	    {
	        arr[j+1]=arr[j];
	        j--;
	    }
	    arr[j+1]=item;
	    
	}
	

	//dispaly function
	public static void display(int[]arr)
	{
	    for(int i=0;i<arr.length;i++)
	    {
	        System.out.print(arr[i]+"\t");
	    }
	}
	}