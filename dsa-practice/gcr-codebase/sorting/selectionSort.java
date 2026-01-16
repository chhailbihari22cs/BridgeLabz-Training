import java.util.*;
public class selectionSort
{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the length of an array");
	int length=sc.nextInt();
	int [] arr = new int[length];//here we declear an array
	
	
	//here we initialize an array
	System.out.println("please enter the exam scores")
	for(int i=0;i<length;i++)
	{
	    arr[i]=sc.nextInt();
	}
	
	
		System.out.println("\n ___________Array before sorting___________");
		display(arr);
	
	//here we implement logic of selection sorting
	for(int i =0 ; i<arr.length-1;i++)
	{
	    int min_idx=i;
	    for(int j=i+1;j<arr.length;j++)
	    {
	        if(arr[min_idx]>arr[j])
	        {
	            min_idx=j;
	        }
	    }
	    int swap=arr[min_idx];
	    arr[min_idx]=arr[i];
	    arr[i]=swap;
	}
	System.out.println("\n ____________Array after sorting________________");
	display(arr);
	}
	public static void display(int[]arr)
	{
	    for(int i=0;i<arr.length;i++)
	    {
   	    System.out.print(arr[i]+"\t");
	    }
	}
}