import java.util.*;
public class RemoveDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String result = removeDuplicate(input);
		System.out.println("Updated String is: "+result);
		
	}
	public static String removeDuplicate(String input) {
		StringBuilder ans = new StringBuilder();
		HashSet<Character> set = new HashSet<>();

		for(int i = 0;i < input.length();i++) {
			if(!set.contains(input.charAt(i))) {
				ans.append(input.charAt(i));
				set.add(input.charAt(i));
			}
			
		}
		return ans.toString();
	}

}  File name:removeduplicate.java