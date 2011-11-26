package classic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 生命游戏
 * 
 * 规则不详说了，但是可以问的是，如何判定游戏是否结束了呢
 * todo:用applet制作出动画演示则更好了
 */

public class LifeGame {
	private boolean[][] map;         //  生命游戏的棋盘
	private boolean[][] newmap;      //  用于变换过程中的临时存储
	
	private static int maxRow = 12;          // 设置棋盘的行数
	private static int maxColumn = 12;       // 设置棋盘的列数
	
	private static int steps = 0;            // 步数

	public LifeGame(int maxRow, int maxColumn) {
		// TODO Auto-generated constructor stub
		map = new boolean[maxRow][maxColumn];
		newmap = new boolean[maxRow][maxColumn];
	}
	
	public void init(int[] row,int[] column) {         // 初始化，将相应的格子放上生命体
		for (int i = 0; i < row.length; i++) {
			if (row[i] <= maxRow &&  column[i] <= maxColumn) {
				map[row[i]][column[i]] = true;
			}
		}
	}

	public void start() {
		// 这两组数据为测试数据
		int[] row = {1,2,3,3,3};
		int[] column = {5,6,4,5,6};
		
		init(row, column);
	}

	public void next() {
		for (int row = 0; row < maxRow; row++) {
			for (int column = 0; column < maxColumn; column++) {
				switch (neighbors(row, column)) {      // 死亡状态 
				case 0:
				case 1:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
					newmap[row][column] = false;
					break;
				case 2:                                // 稳定状态  
					newmap[row][column] = map[row][column];
					break;
				case 3:                                // 复活状态
					newmap[row][column] = true;
					break;
				}
			}
		}
		steps += 1;
		
		//System.arraycopy(newmap, 0, map, 0, maxRow); // 问题：多维数组的copy应该如何来做
		
		for (int r = 0; r <	 maxRow; r++)              // 将newmap复制到map中
			for (int c = 0; c < maxColumn; c++) 
				map[r][c] = newmap[r][c];
	}

	private int neighbors(int row,int column) {     // 计算一个格子的邻居数
		int count = 0;
		for (int r = row-1; r <= row+1; r++) {
			for (int c = column-1; c <= column+1; c++) {
				if (r < 0 || r >= maxRow ||
					c < 0 || c >= maxColumn) {
					continue;
				}
				if (map[r][c]) {
					count++;
				}
			}
		}
		
		if (map[row][column]) {
			count--;
		}
		return count;
	}
	
	public void print(boolean[][] map) { 			// 打印棋盘
		for (int r = 0; r < maxRow; r++) {
			System.out.println();
			for (int c = 0; c < maxColumn; c++) {
				System.out.printf("%c", map[r][c]?'#':'-');
			}
		}
	}

	public static void main(String[] args) throws IOException {
		LifeGame game = new LifeGame(maxRow, maxColumn);
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
		game.start();
		
		while (true) {
			game.next();
			game.print(game.map);
			
			System.out.println("\n Continue next generation?");
			String ans = bufReader.readLine().toUpperCase();
			if (ans.equals("N")) {
				break;
			}
		}
		
		System.out.println(steps);
	}
}
