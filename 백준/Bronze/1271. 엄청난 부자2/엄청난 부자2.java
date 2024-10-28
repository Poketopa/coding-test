import java.util.*;
import java.math.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String[] part = input.split(" ");
		
		BigInteger a = new BigInteger(part[0]);
		BigInteger b = new BigInteger(part[1]);
		
		BigInteger div = a.divide(b);
		BigInteger mod = a.mod(b);
		
		
		System.out.println(div);
		System.out.println(mod);
	}
}
