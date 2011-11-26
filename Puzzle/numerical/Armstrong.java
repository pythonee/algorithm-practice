package numerical;

import java.util.ArrayList;
import java.util.List;

public class Armstrong {
	public static List<Integer> findArmstrong(int start,int end){
		List<Integer> armstrong = new ArrayList<Integer>();
		for (int i = start; i <= end; i++) {
			int hundred = i / 100;
			int ten = (i%100)/10;
			int bit = i % 10;
			
			if ((hundred*hundred*hundred +
				ten*ten*ten + 
				bit*bit*bit) == i) {
				armstrong.add(i);
			}
		}
		
		return armstrong;
	}
	
	public static void main(String[] args) {
		for (Integer armstrong : findArmstrong(100, 9999)) {
			System.out.print(armstrong+" ");
		}
	}
}
