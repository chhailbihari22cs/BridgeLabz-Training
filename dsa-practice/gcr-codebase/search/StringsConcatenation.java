import java.util.*;
public class StringsConcatenation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String input[] = new String[size];
		
		for(int i = 0;i < size;i++) {
			input[i] = sc.next();
		}
		
		String ans = concat(input);
		System.out.println("Cocatenated String output: "+ans+" ");
	}
	public static String concat(String input[]) {
		StringBuffer ans = new StringBuffer();
		for(int i = 0;i < input.length;i++) {
			ans.append(input[i]);
		}
		return ans.toString();
	}

} FileName:String concatenation.java