import java.io.*;
import java.util.*;

public class TidyNumbersLarge {

	public static void main(String args[]) throws IOException {
		//PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		//System.setOut(out);
		Scanner read = new Scanner(System.in);
		int test = read.nextInt();
		for(int i=1; i<=test; i++) {
			long num = read.nextLong();
			long num2 = num;
			int len = Long.toString(num).length();
			ArrayList<Integer> numlist1 = new ArrayList<Integer>();
			for(int j=0; j<len; j++) {
				int digit = (int) (num2%10);
				numlist1.add(digit);
				num2 = num2/10;
			}
			Collections.reverse(numlist1);
			
			if(len==1) {
				System.out.println("Case #"+i+": "+num);
				continue;
			}
			for(int p=0; p<len-1; p++) {
				if(numlist1.get(p)>numlist1.get(p+1)) {
					System.out.println("Case #"+i+": "+rearrange(numlist1));
					break;
				}
				if(p==len-2) {
					System.out.println("Case #"+i+": "+num);
				}
			}	
		}
	}
	
	public static long rearrange(ArrayList<Integer> numlist) {
		int len = numlist.size();
		for(int k=1; k<len; k++) {
			if(numlist.get(k-1)>=numlist.get(k)) {
				int temp = numlist.get(k-1);
				numlist.set(k-1, temp-1);
				for(int l=k; l<len; l++) {
					numlist.set(l, 9);
				}
				break;
			}
		}
		
		long result = 0;
		for(int m=0; m<len; m++) {
			result = result + (long)(Math.pow(10, (len-1-m))*numlist.get(m));
		}
		
		return result;
	}
	
}
