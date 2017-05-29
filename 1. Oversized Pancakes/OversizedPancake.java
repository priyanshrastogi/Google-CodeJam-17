import java.io.*;
import java.util.*;

public class OversizedPancake {

	public static void main(String args[]) throws IOException {
		//PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
		//System.setOut(out);
		Scanner read = new Scanner(System.in);
		int test = read.nextInt();
		for(int i=1; i<=test; i++) {
			String str = read.next();
			int flip = read.nextInt();
			int count = 0;
			boolean terminate = false;
			char[] pancakes = str.toCharArray();
			for(int j=0; j<pancakes.length; j++) {
				if(pancakes[j]=='-') {
					try{
						for(int k=j; k<j+flip; k++) {
							if(pancakes[k]=='-')
								pancakes[k]='+';
							else
								pancakes[k]='-';
						}
						count++;
					}catch(Exception E) {
						System.out.println("Case #"+i+": "+"IMPOSSIBLE");
						terminate = true;
						break;
					}
				}
			}
			if(!terminate)
				System.out.println("Case #"+i+": "+count);
		}
		
	}
}
