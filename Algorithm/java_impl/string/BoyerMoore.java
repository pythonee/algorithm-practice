public class BoyerMoore {
	
	/*
	 * 参考文档:
	 * 1, http://www-igm.univ-mlv.fr/~lecroq/string/node14.html#SECTION00140
	 * 2, http://blog.163.com/prevBlogPerma.do?host=xsh8637&srl=24099666201010100514374&mode=prev
	 * 3, http://blog.163.com/iamyuguo@126/blog/static/32803330201001215522407/
	 * 
	 */
	
	// 只针对ASCII 256个字符
	private final static int ASSIZE = 256;
	
	// 构建坏字符跳转表
	public int[] bmBadChar(String pattern){
		int[] bmBC = new int[ASSIZE];
		int m  = pattern.length();
		for (int i = 0; i < ASSIZE; i++) {
			bmBC[i] = m;
		}
		
		for (int i = 0; i < m-1; i++) {
			bmBC[pattern.charAt(i)] = m - i - 1;
		}
		
		return bmBC;
	}
	
	// 计算Suff辅助数组
	public int[] suff(String pattern){
		
		int[] suff = new int[pattern.length()];
		
		int m = pattern.length();
		
		for (int i = 0; i < suff.length; i++) {
			suff[i] = m;
		}
		
		int f = 0;		//上一次匹配的起始位置
		int g = m-1;	//上一次匹配的失效位置
		int i = 0;
		
		for(i = m-2;i>=0;i--){
			if (i > g  && suff[i + m - f -1] < (i - g)) {
				suff[i] = suff[i + m - f -1];		// 利用已有的suff计算未知知的suff
			}
			else{
				if (i < g) {
					g = i;		// 更新失效位置
				}
				f = i;			// 记录新的起始位置
				while(g >= 0 && pattern.charAt(g) == pattern.charAt(g+m-f-1))
					--g;
				suff[i] = f-g;	// 等于 (起始位置 - 失效位置)
			}
		}
		
		return suff;
		
	}
	
	// 构建好后缀跳转表
	public int[] bmGoodSuffix(String pattern){
		int m = pattern.length();
		
		int[] bmGS = new int[m];
		
		int[] suff = this.suff(pattern);
		
		// case 3	没有后缀
		for(int i = 0; i < m; i++){
			bmGS[i] = m;
		}
		
		// case 2	不完全后缀
		int j = 0;
		for(int i = m-1; i>=0; i--){
			if (suff[i] == i+1) {
				for(;j < m-i-1;++j){
					if (bmGS[j] == m) {
						bmGS[j] = m-i-1;
					}
				}
			}
		}
		
		// case 1	完全后缀
		for(int i=0; i<=m-2;i++){
			bmGS[m-1-suff[i]] = m-i-1;
		}
		
		return bmGS;
		
	}
	
	public int indexOf(String source,String pattern){
		
		int[] bmBC = bmBadChar(pattern);
		int[] bmGS = bmGoodSuffix(pattern);
		int m = pattern.length();
		
		int j = 0;
		int i = 0;
		while (j <= source.length() - pattern.length()) {
			for(i = m-1;i>=0&& pattern.charAt(i) == source.charAt(i+j);--i);
		
			if (i == -1) {
				return j;
			}
			else
				// 这个j的跳转就是bm算法的精华
				j += Math.max(bmGS[i], bmBC[source.charAt(i+j)]-m+i+1);	// 坏字符对齐与好后缀跳转的最大值
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		BoyerMoore bm = new BoyerMoore();
		String source = "gcatcgcagagagtatacagtacg";
		String pattern = "gcgaagag";
		
		int[] bmBC = bm.bmBadChar(pattern);
		
		for (int i = 0; i < pattern.length(); i++) {
			System.out.print(bmBC[pattern.charAt(i)]+" ");
		}
		System.out.println();
		
		int[] suff = bm.suff(pattern);
		
		for (int i = 0; i < suff.length; i++) {
			System.out.print(suff[i] + " ");
		}
		System.out.println();
		
		int[] bmGS = bm.bmGoodSuffix(pattern);
		for (int i = 0; i < bmGS.length; i++) {
			System.out.print(bmGS[i] + " ");
		}
		System.out.println();
		
		int index = bm.indexOf(source, pattern);
		
		System.out.println(index);
	}
	
}
