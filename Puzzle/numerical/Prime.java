package numerical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 素数相关
 */
public class Prime {
	
	public static List<Integer> findPrime(int lessThan) {  // 找小于某个数的所有素数
		int[] sieve = new int[lessThan+1];
		Arrays.fill(sieve, 1);
		
		
		for(int i = 2; i*i <= lessThan; i++){
			if (sieve[i] == 1) {
				for (int j = 2*i; j <= lessThan; j++) {
					if (j%i == 0) {
						sieve[j] = 0;
					}
				}
			}
		}
		
		List<Integer> prime = new ArrayList<Integer>();    
		
		for (int i = 2; i <= lessThan; i++) {
			if (sieve[i] == 1) {
				prime.add(i);
			}
		}
		
		return prime;
	}
	
	public static boolean testPrime(int n){	  // 素数检测算法
		int sqrt = (int)Math.sqrt(n)+1;
		
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0 && n != 2) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int number = 0;
		for (Integer p : findPrime(1000)) {
			number++;
			System.out.print(p+" ");
			if (number % 10 ==0) {
				System.out.println();
			}
		}
		System.out.println();

		System.out.println("一共有 " + number);
		
		
	}
}
