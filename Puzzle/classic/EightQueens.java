package classic;

/*
 * 八皇后问题 
 */

public class EightQueens {

	private static int anwser=0;		// 解法总数，用此变量来统计所有的方案
	
	
	// 判断现在要放下去的皇后是否和之前的互相攻击
	// queen 数组为存放皇后位置的数姐
	// now 表示当前的皇后
	public static boolean isConsistent(int[] queen,int now){
		for(int i=0;i<now;i++){
			if (queen[i] == queen[now]) return false;
			if (Math.abs(queen[i]-queen[now])==Math.abs(i-now)) return false;
		}
		return true;
	}
	
	// 通过回溯来遍历所有可能性
	// queen 数组为存放皇后位置的数姐
	// n  表示进行到的行，如果互不相攻击，那么不断进行下去
	public static void enumerate(int[] queen,int row) {
		if(row == queen.length) anwser++;    //找到一个解，answer加1;
		else {
			for (int i = 0; i < queen.length; i++) {
				queen[row] =i;		// 存储列数，数组下标做为行数
				if (isConsistent(queen, row)) {
					enumerate(queen, row+1);	// 如果满足,则进行下一行
				}
			}
		}
	}
	
	
	// TODO : 打印八皇后棋盘,以便了解有哪些解
	public static void print(int[] queen){
		
	}
	
	public static void main(String[] args){
		int[] queen = new int[8];    // 八皇后，这个规模可以扩大，改到20的时候，电脑搞不定了
		long before = System.currentTimeMillis();     // 这个主要是为了统计耗时的 
		enumerate(queen, 0);
		long after = System.currentTimeMillis();
		System.out.println(anwser);                   // 打印解法总数
		System.out.println(after-before);             // 打印耗时，单位为ms
	}
}
