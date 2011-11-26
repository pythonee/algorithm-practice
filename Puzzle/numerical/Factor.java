package numerical;

import java.util.ArrayList;
import java.util.List;


public class Factor {
	
	public static List<Integer> factor(int n){
		List<Integer> primes = Prime.findPrime(n);
		List<Integer> factors = new ArrayList<Integer>();
		
		int num = n;
		
		for (int i = 0; primes.get(i) <= Math.sqrt(num);) {
			if (num % primes.get(i) == 0) {
				factors.add(primes.get(i));
				num /= primes.get(i);
			}
			else
				i++;
		}
		factors.add(num);
		return factors;
	}
	
	public static void main(String[] args) {
		for (Integer fac : factor(100)) {
			System.out.print(fac + " ");
		}
	}
}
