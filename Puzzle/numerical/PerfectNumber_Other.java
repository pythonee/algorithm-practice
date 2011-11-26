package numerical;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber_Other {
	
	public static List<Integer> lessThan(int n){
		
		List<Integer> perfects = new ArrayList<Integer>();
		
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i%j == 0) {
					sum += j;
				}
			}
			if(sum == i){
				perfects.add(i);
			}
		}
		
		return perfects;
	}
	
	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		for (Integer i : lessThan(100000)) {
			System.out.print(i + " ");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
