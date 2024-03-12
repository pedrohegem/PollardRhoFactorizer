import java.math.BigInteger;
import java.util.Scanner;

public class PollardRho {
	
	public static BigInteger PollardRhoFactor (BigInteger N) {
		BigInteger a = BigInteger.valueOf(2);
		BigInteger b = BigInteger.valueOf(2);
		BigInteger c;
		
		while(true) {
			a = a.pow(2).add(BigInteger.ONE).mod(N);
			b = b.pow(2).add(BigInteger.ONE).mod(N);
			b = b.pow(2).add(BigInteger.ONE).mod(N);
			c = a.subtract(b).gcd(N);
			
			if((c.compareTo(BigInteger.ONE) > 0) && (c.compareTo(N) < 0))
				return c;
			
			if(c.equals(N))
				return BigInteger.valueOf(-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number to factorize: ");
		String number = scanner.nextLine();
		BigInteger N = new BigInteger(number);
		
		long startTime = System.currentTimeMillis();
		System.out.println("Non-trivial factor: " + PollardRhoFactor(N));
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - startTime) + " milliseconds.");
		scanner.close();
	}
}
