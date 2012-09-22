public class StrStr {
	// 相当于java indexOf
	
	public int indexOf(String source,String pattern){
		
		char first = pattern.charAt(0);
		int max = source.length()-pattern.length();
		
		for (int index = 0; index <= max; index++) {
			if (source.charAt(index) != first) {
				while(++index <= max && source.charAt(index) != first);
			}
			
			if (index <= max) {
				
				int rest = index + 1;
				
				int end = index + pattern.length();
				
				for (int k = 1; rest < end && source.charAt(rest) == pattern.charAt(k); k++,rest++);
				
				if (rest == end) {
					
					return index;
					
				}
				
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		StrStr instance = new StrStr();
		String source = "sfaba bcasf babca bcab ababcabababbabcab";
		String pattern = "abababb";
		
		int index = instance.indexOf(source, pattern);
		
		
		if(index >= 0){
			System.out.println(index);
		}
		else{
			System.out.println("No contain");
		}
	}
	
}
