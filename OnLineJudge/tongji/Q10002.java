import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10002 {
	public int steps = 0;

	public void move(char source, char destination) {
		// System.out.println("move "+ source + " to "+ destination);
		steps++;
	}

	public void move(int n, char first, char second, char third) {
		if (n == 1) {
			move(first, third);
		} else {
			move(n - 1, first, third, second);
			move(first, third);
			move(n - 1, second, first, third);
		}
	}

	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		Q10002 hanoi = new Q10002();

		int input = 0;

		try {
			input = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return;
		}

		if (input < 1) {

		} else {
			hanoi.move(input, 'A', 'B', 'C');
			System.out.println(hanoi.steps);
		}
	}
}
