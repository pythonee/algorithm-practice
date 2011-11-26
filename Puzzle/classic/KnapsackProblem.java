package classic;

class Fruit {
	public final String name;
	public final int size;
	public final int price;

	public Fruit(String name, int size, int price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}
}

public class KnapsackProblem {
	private final static int MAX = 8;
	private final static int MIN = 1;
	static int[] item = new int[MAX + 1];
	static int[] value = new int[MAX + 1];

	public static void main(String[] args) {
		
		Fruit fruits[] = { new Fruit("李子", 4, 4500), 
						    new Fruit("苹果", 5, 5000),
						    new Fruit("橘子", 2, 2500), 
						    new Fruit("草莓", 1, 1000),
						    new Fruit("甜瓜", 6, 6500),
						    new Fruit("西瓜", 3, 3000)};

		for (int i = 0; i < fruits.length; i++) {
			for (int s = fruits[i].size; s <= MAX; s++) {
				int p = s - fruits[i].size;
				int newValue = value[p] + fruits[i].price;
				if (newValue > value[s]) {// 找到阶段最佳解
					value[s] = newValue;
					item[s] = i;
				}
			}
		}

		System.out.println("物品\t价格");
		
		for (int j = MAX; j >= MIN; j -= fruits[item[j]].size) {
			System.out.println(fruits[item[j]].name + "\t"
					+ fruits[item[j]].price);
		}

		System.out.println("合计\t" + value[MAX]);
	}
}
