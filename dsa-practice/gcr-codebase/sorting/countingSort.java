import java.util.*;
public class countingSort
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the length of an array");
		int len=sc.nextInt();
		int[]ages=new int[len];//here we declear an array
		//here we initialize an array
        System.out.print("enter student ages");
		for(int i=0;i<ages.length;i++)
		{
		    ages[i]=sc.nextInt();
		}
		
		//here we find which element in an array is maximum
		int max_age=ages[0];
		for(int i=1;i<len;i++)
		{
		    if(ages[i]>max_age)
		    {
		        max_age=ages[i];
		    }
		}
		
		//here we create another array with size of maximum element + 1
		int[]frequency = new int [max_age+1];
		
		//here we count the frequency of a numbers in an original array
		for(int i=0;i<len;i++)
		{
		   frequency[ages[i]] ++;
		}
		
		
		//here we complete our sorting technique
		int k=0;
		for(int i=0;i<frequency.length;i++)
		{
		    int j=frequency[i];
		    while(j>0)
		    {
		        ages[k]=i;
		        j--;
		        k++;
		    }
		}
		display(ages);
	}
	public static void display(int[]arr)
	{
	    for(int i=0;i<arr.length;i++)
	    {
	        System.out.print(arr[i]+"\t");
	    }
	}
}