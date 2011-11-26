package classic;

/*
 * 荷兰三色旗问题
 * 
 * 是不允许使用额外的数组的
 */
public class DutchNationFlag {
	private static char[] flags;
	private static char[] threeColors = {'B','W','R'};
	
	// 初始化函数
	private static void init(int count) {
		flags = new char[count];
		for (int i = 0; i < count; i++) {
			int x = (int)(Math.random()*10000);
			flags[i] = threeColors[x%3];
		}
	}
	
	// 移动函数
	public static void move(char[] flags) {
		int wFlag = 0;
		int bFlag = 0;
		int rFlag = flags.length -1;
		
		while (wFlag <= rFlag) {
			switch (flags[wFlag]) {
			case 'W':              // 如果是白色的旗子
				wFlag++;			// 白旗向后移动，表明白色群组加一
				break;
			case 'B':				// 如果是蓝色的旗子
				swap(flags, bFlag, wFlag);    // 交换
				bFlag++;			// 蓝色群组向后加一
				wFlag++;			// 白色群组向后加一
				break;
			default:
				while (wFlag < rFlag && flags[rFlag] == 'R') // 如果是红色旗子
					rFlag--;								  // 从后向前扫，碰到红旗就要减一，表示未处理的区域在减少
				swap(flags, rFlag, wFlag);
				rFlag--;
				break;
			}
		}
	}
	
	// 交换函数
	private static void swap(char[] flags,int x,int y) { 
		char temp;
		temp = flags[x];
		flags[x] = flags[y];
		flags[y] = temp;
	}
	
	public static void main(String[] args) {
		init(10);                      // 测试10支旗子的情况
		System.out.println(flags);
		move(flags);
		System.out.println(flags);
	}
}
