import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			int input = Integer.parseInt(in.readLine());
			
			
			int tail=1;
			
			for(int i=1; i<=input;i++) {
				
				
				tail = tail*i;
				
				while(tail%10==0) tail /= 10;
				
				tail = tail%10000000;
			}
			
			
			while(tail%10==0) tail /= 10;
			
			System.out.println((""+tail).charAt((""+tail).length()-1));
		
			
		} catch (NumberFormatException e) {

		} catch (IOException e) {

		}
	}
}
