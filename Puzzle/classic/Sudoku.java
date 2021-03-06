package classic;

/*
 * 数独游戏
 */
public class Sudoku {
	private static int hard = 25;
	static int answer = 0;

	public static boolean solve(int x, int y, int[][] cells) { // 回溯算法求解数独
		if (x == 9) {
			x = 0;
			if (++y == 9) {     // 递归的出口
				answer++;
				print(cells);
				return true;
			}
		}
		
		if (cells[x][y] != 0) { // 如果x,y处已经有了非零，跳到下一行
			return solve(x + 1, y, cells);
		}
		
		for (int val = 1; val <= 9; ++val) {
			cells[x][y] = val;
			if (legal(x, y, val, cells)) {
				solve(x+1, y, cells);
			}
		}
		cells[x][y] = 0;	// 如果没有找到解，要重置该位，并回溯
		
		return false;
	}

	public static boolean legal(int x, int y, int val, int[][] cells) { // 回溯算法中的试错
		for (int i = 0; i < 9; ++i) {	// 检查行
			if (i != x && val == cells[i][y]) {
				return false;
			}
		}

		for (int i = 0; i < 9; ++i) {	// 检查列
			if (i != y && val == cells[x][i]) {
				return false;
			}
		}

		int boxRowOffset = (x / 3) * 3;
		int boxColOffset = (y / 3) * 3;
		
		// 检查9宫格
		for (int row = boxRowOffset; row < boxRowOffset+3; ++row) {
			for (int col = boxColOffset; col < boxColOffset+3; ++col) {
				if ((row != x || col != y) && val == cells[row][col]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void print(int[][] cells) {	// 打印数独
		for (int i = 0; i < 9; i++) {
			if (i % 3 == 0) {
				System.out.println("-------------------------");
			}
			for (int j = 0; j < 9; j++) {
				if (j % 3 == 0) {
					System.out.print("| ");
				}
				System.out.print(cells[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("-------------------------");
	}

	public static int[][] quiz() {	// 简单出题，没有难度AI,只是随机填上一些数字，所以有可能无解，有可能多解
		int[][] cells = new int[9][9];
		for (int i = 0; i < hard;) {
			int x = (int) (Math.random() * 9);
			int y = (int) (Math.random() * 9);
			int val = (int) (Math.random() * 9) + 1;
			if (cells[x][y] == 0) {
				if (legal(x, y, val, cells)) {
					cells[x][y] = val;
					i++;
				}
			}
		}
		return cells;
	}
	
	// 测试生成的数独局面是否有解且有唯一解
	// TODO : TestUnique() 
	public static void testUnique(){
		
	}
	
	// 挖洞思想需要用到的拉斯维加斯算法
	// TODO : lasvegas() algorithm
	public static void lasvegas(){
		
	}

	public static void main(String[] args) {
		// 将控制台输出重定向到文本文件
//		try {
//			FileOutputStream fs = new FileOutputStream("/home/pythonee/log.txt");
//			PrintStream ps = new PrintStream(fs);
//			System.setOut(ps);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		int[][] cells = quiz();
		print(cells);
		long start = System.currentTimeMillis();
		solve(0, 0, cells);
		long end = System.currentTimeMillis();
		if (answer > 0) {
			System.out.println("一共有 "+ answer + " 个解");
			System.out.println("耗时:" + (end-start) + " ms");
		}
		else
			System.out.println("无解");
	}
}
