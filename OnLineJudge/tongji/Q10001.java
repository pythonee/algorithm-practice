import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10001 {
	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		String input = "0";

		try {
			while ((input = in.readLine()) != null && input.length() > 0) {
				sum += Integer.parseInt(input);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			// e.printStackTrace();
			return;
		}

		System.out.println(sum);
	}
}
