package numerical;

import java.util.ArrayList;
import java.util.List;
/*
 * 完美数
 */
public class PerfectNumber_PrimeTable {
	
	public static List<Integer> findPerfect(int lessThan) {
		List<Integer> perfect = new ArrayList<Integer>();
		
		for (int i = 2; i <= lessThan; i++) {
			if (i == sum(Factor.factor(i)))
				perfect.add(i);
		}
		
		return perfect;
	}
	
	private static int sum(List<Integer> factors) { 	// 求所有质因子的和，有公式可依，不是简单相加
		int product = 1;
		int index = 0;
		while (index < factors.size()) {
			int power = 1;
			int sum = 1;
			do {
				power *= factors.get(index);
				sum += power;
				index++;
			} while (index < factors.size()
					&& factors.get(index - 1).equals(factors.get(index)));
			product *= sum;
		}
		return product/2;
	}
	
	public static void main(String[] args) { 
		long start = System.currentTimeMillis();
		for(Integer number : PerfectNumber_PrimeTable.findPerfect(1000)) {
            System.out.print(number + " ");
        }
		long end = System.currentTimeMillis();
		System.out.println("耗时: " + (end - start) + "ms");
	}
}
