import java.util.*;
import java.io.*;

public class BathroomStalls {
	
	public static void main(String args[]) throws IOException {
		PrintStream out = new PrintStream(new FileOutputStream("output2.txt"));
		System.setOut(out);
		Scanner read = new Scanner(System.in);
		int test = read.nextInt();
		try {
		for(int i=1; i<=test; i++) {
			long n = read.nextInt();
			long k = read.nextInt();
			long size = getSize(n,k);
			if(size<=1)
				System.out.println("Case #"+i+": "+0+" "+0);
			else {
				long max = (int)Math.ceil(1.0*(size-1)/2);
				long min = (int)Math.floor(1.0*(size-1)/2);
				System.out.println("Case #"+i+": "+max+" "+min);
			}
		}
		}catch(Exception e) {
			
		}
	
	}
	
	public static long getSize(long n, long k) {
		int level = (int)Math.floor(Math.log(k)/Math.log(2));
		long numofpeople = (long)Math.pow(2, level);
		long numofstalls = n - numofpeople + 1;
		long goodseat = (long)Math.ceil(1.0*numofstalls/numofpeople);
		long badseat = (long)Math.floor(1.0*numofstalls/numofpeople);
		long numofgoodseat = numofstalls - badseat*numofpeople;
		if(k - Math.pow(2,level) + 1 <= numofgoodseat){
			return goodseat;
		}else{
			return badseat;
		}
	}
}
