import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10000 {

	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = "";

		try {
			input = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[] numberStr = input.split(" ");

		int a = Integer.valueOf(numberStr[0]);
		int b = Integer.valueOf(numberStr[1]);

		System.out.println(a + b);

	}
}
