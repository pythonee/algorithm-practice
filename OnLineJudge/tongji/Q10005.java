import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q10005 {
	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			BigInteger a = new BigInteger(in.readLine());
			BigInteger b = new BigInteger(in.readLine());

			System.out.println(a.add(b));

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}

	}
}
