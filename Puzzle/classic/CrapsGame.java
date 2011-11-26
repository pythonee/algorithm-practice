package classic;

import java.io.IOException;

/*
 * Craps 赌博游戏
 * 是一种比较简单的赌博游戏
 * 
 * 解法简单，但更过程控制的几个地方需要注意
 */
public class CrapsGame {
	
	private final static int WON = 0;            // 玩家赢
	private final static int LOST = 1;			// 玩家输
	private final static int CONTINUE = 2;       // 继续掷骰子
	private static int result = CONTINUE;			// 游戏结果
	private static boolean firstRoll = true;     // 是不是第一次掷骰
	private static int firstPoint = 0;			// 第一次点数和
	private static int die_1 = 0;					// 骰子1号
	private static int die_2 = 0;					// 骰子2号
	private static int sumOfDice = 0;				// 骰子之和
	
	
	public static void start() throws IOException{
		System.out.println("Game Start...");
		while (true) {
			die_1 = rollDice();
			die_2 = rollDice();
			sumOfDice = die_1 + die_2;
			System.out.println("sum of dice is " + sumOfDice);
			if (firstRoll) { 						// 第一次掷骰
				switch (sumOfDice) {
				case 7: case 11:
					result = WON;
					break;
				case 2: case 3: case 12:
					result = LOST;
					break;
				default:
					firstRoll = false;
					firstPoint = sumOfDice;
					result = CONTINUE;
					break;
				}
			}
			
			else {									// 后面掷骰，直到与第一次的点数和相等为胜
				if (sumOfDice == firstPoint) {
					result = WON;
				}
				else if (sumOfDice == 7) {			// 在此之前，掷出7为输
					result = LOST;
				}
			}
			
			
			switch (result) {						// 显示结果
			case WON:
				System.out.println("You Win..");
				break;
			case LOST:
				System.out.println("You Lost..");
				break;
			default:
				System.out.println("Nobody Lost and Nobody Won..Continue?");
				continue;
			}
			
			System.out.println("Play again? y/n..");
			
			if (System.in.read() == 'n') {
				System.out.println("Game Over...");
				break;
			}
			else {
				firstRoll = true;
			}
		}
	}
	
	private static int rollDice(){
		int roll = (int)(Math.random()*6)+1;
		
		return roll;
	}
	
	public static void main(String[] args) {
		try {
			start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
