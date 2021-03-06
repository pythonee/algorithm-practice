public class KMP {

	/* 参考理论:
	 * 			1,http://www.ics.uci.edu/~eppstein/161/960227.html
	 * 			2,http://www.ics.uci.edu/~goodrich/dsa/11strings/demos/pattern/
	 */
	/* 参考代码: 
	 * 			1,http://www.cs.princeton.edu/algs4/53substring/KMP.java.html
	 * 			2,http://wansishuang.javaeye.com/blog/402018
	 */
	
	
	
	// 构建DFA
	public int[] overlap(String pattern){
		
		int[] next = new int[pattern.length()];
		
		next[0] = 0;
		next[1] = 0;
		
		int i = 2;
		int cur = 0;
		
		while (i < pattern.length()) {
			
			if (pattern.charAt(i-1)==pattern.charAt(cur)) {	//	当前匹配,移到下一个位置
				next[i] = cur+1;
				cur++;
				i++;
			}
			
			else if (cur > 0) {		//	cur > 0,匹配了一部分,回溯
				cur = 0;
				// cur = next[cur];	//  有的人这样来回溯
			}
			
			else{		//	cur=0,当前不匹配
				
				next[i] = 0;
				i++;
				
			}
		}
				
		return next;
	}
	
	// 根据DFA进行查找
	public int search(String source,String pattern){
		
		int[] next = this.overlap(pattern);
		
		for (int i = 0; i < next.length; i++) {
			System.out.print(pattern.charAt(i) + " ");
		}
		System.out.println();
		
		for (int i = 0; i < next.length; i++) {
			System.out.print(next[i] + " ");
		}
		System.out.println();
		
		int j = 0;
		
		for (int i = 0; i < source.length(); i++) {
			for(;;){
				
				if (source.charAt(i) == pattern.charAt(j)) {
					j++;
					if (j == pattern.length()) {	// 找到一个匹配
						return i-j+1;
					}
					break;
				}
				
				else if (j == 0) {					// 没有与source[i]的匹配,直接让i+1
					break;
				}
				
				else {								// 匹配了一部分失败,按next数组,让j回溯
					j = next[j];
				}
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		KMP kmp = new KMP();
		String source = "sfababcasfbabcabcabababcabababbabcab";
		String pattern = "abababb";
		int index = kmp.search(source, pattern);
		
		if(index >= 0){
			System.out.println(index);
		}
		else{
			System.out.println("No contain");
		}
	}
}
