import java.util.*;
public class quickSort
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the length of an array : ");
		int len=sc.nextInt();
		int[]arr = new int[len];  //here we declear an array
		
		
		//in this section we initialize an array
		System.out.print("enter the prices of product in an array : \n");
		for(int i=0;i<arr.length;i++)
		{
		    arr[i]=sc.nextInt();
		}
		System.out.print("\n prices before sorting : \n");
		display(arr);
		qsort(arr,0,arr.length-1);
		System.out.print("\n prices after sorting : \n");
		display(arr);
	}
	public static void qsort(int[]arr,int si,int ei)
	{
	    //break statement
	    if(si>=ei)
	    {
	        return;
	    }
	    int idx=indexx(arr,si,ei);
	    qsort(arr,si,idx-1);
	    qsort(arr,idx+1,ei);
	}
		
		//here we find index of sorted element
		public static int indexx(int[]arr,int si,int ei)
		{
		int item=arr[ei];
		int idx=0;
		for(int i=0;i<arr.length;i++)
		{
		    if(arr[i]<item)
		    {
		        int swap=arr[i];
		        arr[i]=arr[idx];
		        arr[idx]=swap;
		        idx++;
		        }
		}
		int swap=arr[ei];
		arr[ei]=arr[idx];
		arr[idx]=swap;
		return idx;
	}
	public static void display(int[]arr)
	{
	    for(int i=0;i<arr.length;i++)
	    {
	        System.out.print(arr[i]+"\t");
	    }
	}
}