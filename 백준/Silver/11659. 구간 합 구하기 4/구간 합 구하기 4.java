import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] intArray = new int[n+1];
		intArray[0] = 0;
		int sum = 0 ;
		int input;
		for(int i=1;i<intArray.length;i++) {
			input = scan.nextInt();
			sum+=input;
			intArray[i]= sum;
		}
		
		for(int i=0;i<m;i++) {
			int from = scan.nextInt();
			int to = scan.nextInt();
			System.out.println(intArray[to]-intArray[from-1]);
			sum=0;
		}
		
        
    }
}