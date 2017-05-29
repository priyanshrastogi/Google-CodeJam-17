import java.io.*;
import java.util.*;

public class TidyNumbers {

	public static void main(String args[]) throws IOException {
		//PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		//System.setOut(out);
		Scanner read = new Scanner(System.in);
		int test = read.nextInt();
		for(int i=1; i<=test; i++) {
			int num = read.nextInt();
			while(true) {
				int num2 = num;
				int len = Integer.toString(num).length();
				ArrayList<Integer> numlist1 = new ArrayList<Integer>();
				for(int j=0; j<len; j++) {
					int digit = num2%10;
					numlist1.add(digit);
					num2 = num2/10;
				}
				ArrayList<Integer> numlist2 = (ArrayList<Integer>)numlist1.clone();
				Collections.sort(numlist2, Collections.reverseOrder());
				if(numlist1.equals(numlist2)) {
					System.out.println("Case #"+i+": "+num);
					break;
				}
				num--;
			}
		}
	}
}
