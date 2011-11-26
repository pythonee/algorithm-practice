package classic;

/*
 * 八个硬币问题
 * 
 * todo:推广到n个硬币问题，并且可以探讨最优解的个数是不是仅有一个
 * 反正知道一系列的3^n-3/2这类有特殊解
 */
public class EightCoins {

	private static int normal = 10;
	private static int fake[] = { 5, 6, 7, 11, 12, 13 };
	private static int[] coins = new int[8];
	public static void setFake() {
		for (int i = 0; i < coins.length; i++) {
			coins[i] = normal;
		}
		// 随机选择一个，并且让其随机性的重或轻
		coins[(int) (Math.random() * coins.length)] = fake[(int) (Math.random() * fake.length)];
	}

	public static void searchFake() {
		// 3－3－2分组
		int group_one = coins[0] + coins[1] + coins[2];
		int group_two = coins[3] + coins[4] + coins[5];

		int sub_group_one = coins[0] + coins[3];    // a+d
		int sub_group_two = coins[1] + coins[4];    // b+e

		if (group_one == group_two) { // 这种情况是假币在第三组，也就是e-f有问题
			if (coins[6] > coins[7]) {
				compare(6, 7, 0);
			} else {
				compare(7, 6, 0);
			}
		}
		// 以下两种情况是假币出现在前两组
		else if (group_one > group_two) {  
			if (sub_group_one == sub_group_two) {
				compare(2, 5, 0);
			} else if (sub_group_one > sub_group_two) {
				compare(0, 4, 1);
			} else {
				compare(1, 3, 0);
			}
		} else {
			if (sub_group_one == sub_group_two) {
				compare(5,2,0);
			} else if (sub_group_one > sub_group_two) {
				compare(3, 1, 0);
			} else {
				compare(4, 0, 1);
			}
		}
	}
	
	// 注意这个方法传的是索引
	public static void compare(int higher, int lighter, int normal) {
		if (coins[higher] > coins[normal]) {
			System.out.println("第 "+ (higher+1) + " 块较重" );
		}
		else {
			System.out.println("第 "+ (lighter+1) + " 块较轻");
		}
	}

	public static void main(String[] args) {
		setFake();
		for (int i = 0; i < coins.length; i++) {
			System.out.println(coins[i]);
		}
		searchFake();
	}
}
