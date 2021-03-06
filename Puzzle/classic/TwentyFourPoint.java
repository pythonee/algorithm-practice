package classic;

import java.util.ArrayList;


/*
 * 24点游戏
 * 
 * 游戏介绍:def
 * 
 * 
 * 算法思路：
   (1) 将4个整数放入数组中
　　(2) 对4个数进行全排列，对每一个排列，
　　(3) 取前面两个数，使用 – * / 每一个运算符，
　　(3.1) 根据此排列的两个数字和运算符，计算结果
　　(3.2) 改变数组：将此排列的两个数字从数组中去除掉，将 3.1 计算的结果放入数组中
　　(3.3) 对新的数组，重复步骤 3，
　　(4) 如果运算结果为24，则判断结果表达是否已存在
 */
public class TwentyFourPoint {
	
	private final static int MAX = 10; 
	private final static int MIN = 3;
	private final static int COUNT = 5;
	private static char[] operator = new char[COUNT-1];
	private static double[] current = new double[COUNT];
	private static ArrayList<String> expressions = new ArrayList<String>();
	
	
	public static void solve(double[] numbers) {						// 对每一个排列，进行四种算术运算,精华之一
		double[] result = arithmetic(numbers[0], numbers[1]);
		double[] newNumbers = new double[numbers.length - 1];
		System.arraycopy(numbers, 1, newNumbers, 0, newNumbers.length);
		
		if (numbers.length == COUNT) {
			System.arraycopy(numbers, 0, current, 0, COUNT);
		}
		
		for (int i = 0; i < result.length; i++) {
			newNumbers[0] = result[i];
			
			switch (i) {
			case 0:
				operator[COUNT-1-newNumbers.length] = '+';
				break;
			case 1:
				operator[COUNT-1-newNumbers.length] = '-';
				break;
			case 2:
				operator[COUNT-1-newNumbers.length] = '＊';
				break;
			case 3:
				operator[COUNT-1-newNumbers.length] = '/';
				break;
			}
			
			if (newNumbers.length > 1) {
				solve(newNumbers);
			}
			else{
				if (newNumbers[0] == 24.0) {
					String expression = makeExpression(current, operator);
					if (!contain(expression)) {
						expressions.add(expression);
					}
				}
			}
		}
	}
	
	/*
	 * 1，从所有数字中分别选择一位与原头部组合成新头
	 * 2，以此头部与剩余位为参
	 * 3，重复步骤1
	 * 
	 */
	public static void permutate(double[] head,double[] tail){ // 所有数字的全排列
		if (tail.length <= 1) {
			double[] numbers = new double[head.length + tail.length];
			System.arraycopy(head, 0, numbers, 0, head.length);
			System.arraycopy(tail, 0, numbers, head.length, tail.length);

			solve(numbers);	// 排出一组，进行24点核对
		}
		else {
			for (int i = 0; i < tail.length; i++) {						  // 构造全排列，精华之一
				double[] newHead = new double[head.length+1];
				System.arraycopy(head, 0, newHead, 0, head.length);
				newHead[head.length] = tail[i];
				double[] newTail = new double[tail.length-1];
				System.arraycopy(tail, 0, newTail, 0, i);
				System.arraycopy(tail, i+1, newTail, i, tail.length-i-1);

				permutate(newHead, newTail);
			}
		}
	}
	
	public static double[] arithmetic(double a,double b){   // 目前支持四种算术运算，+-*/
		
		double[] result = new double[4];

		result[0] = a + b;					//返回两数之和,放在第一位
		result[1] = a - b;					//返回两数之差，放在第二位
		result[2] = a * b;					//返回两数之积，放在第三位
		result[3] = (double)(a / b);		//返回两数之商，放在第四位，注意，这里一定要用double类型
		
		return result;
		
	}
	
	/*
	 * 参数:numbers  表示参与运算的数字
	 * 参数:operator 表示依次使用的运算符
	 */
	public static String makeExpression(double[] numbers, char[] operator){ // 构造表达式

		String expression = ""+(int)numbers[0] + operator[0] + (int)numbers[1];
		
		for (int i = 1; i < operator.length; i++) {                             // 括号处理
			if (getPriority(operator[i]) > getPriority(operator[i-1])) 
				expression = "(" + expression + ")" + operator[i] + (int)numbers[i+1];
			else 
				expression += ""+operator[i]+(int)numbers[i+1];
		}
		return expression;
	}
	
	public static int getPriority(char operator){	// 获取运算符的优先级
		switch (operator) {
		case '+': case '-':
			return 0;
		default:
			return 1;
		}
	}
	
	public static boolean contain(String curr_expr) {   // 判断当前满足24点运算的表达式是否已存在
		boolean contained = false;

		for (String inList_expr : expressions) {
			contained = contained || equivalent(inList_expr, curr_expr);
			if (contained) break;
		}

		return contained;
	}
	
	public static boolean equivalent(String expr_1,String expr_2){   // 给定两个表达式，判断是否是交换率等价的
		
		boolean equal = false;
		String unit_1 = new String();
		String unit_2 = new String();
		String[] numbers_1 = expr_1.split("\\D+");        // 从表达式提取数字
		String[] operators_1 = expr_1.split("\\d+");	  // 从表达式提取运算符
		String[] numbers_2 = expr_2.split("\\D+");
		String[] operators_2 = expr_2.split("\\d+");
		
		if (numbers_1.length >= 2) {
			if (expr_1.startsWith("(") && expr_2.startsWith("(") && 		// 处理带括号的
				expr_1.lastIndexOf(")")==expr_2.lastIndexOf(")")) {
				
				unit_1 = expr_1.substring(1,expr_1.lastIndexOf(")"));
				unit_2 = expr_2.substring(1,expr_2.lastIndexOf(")"));
				
				if (equivalent(unit_1, unit_2)) {
					unit_1 = 0 + expr_1.substring(expr_1.lastIndexOf(")")+1);
					unit_2 = 0 + expr_2.substring(expr_2.lastIndexOf(")")+1);
					equal = equal || equivalent(unit_1, unit_2);
				}
				else
					return false;
			}
			else if(!expr_1.startsWith("(") && !expr_2.startsWith("(")) {  // 不带括号的
				
				ArrayList<String> read_numbers = new ArrayList<String>();
				ArrayList<String> read_operator = new ArrayList<String>();
				
				boolean numberSame = true;        // 判断参与运算的数字是不是相同的数字
				boolean opertorSame = true;		// 参与运算的运算符是不是一致的
				
				int curr_oper = 1;
				
				while (curr_oper < operators_1.length) {
					if (curr_oper+1 < operators_1.length) {
						if (getPriority(operators_1[curr_oper].charAt(0)) == 
							getPriority(operators_1[curr_oper+1].charAt(0))) { // 只要优先级相同，就不断往前读，
							curr_oper++;
						}
						else 
							break;
					}
					else 
						break;
				}
				
				for (int i = 1; i <= curr_oper; i++) {							// 读入所有优先级相同的运算符
					read_operator.add(operators_1[i]);
				}
				
				for (int i = 1; i <= curr_oper ; i++) {
					opertorSame = opertorSame && read_operator.contains(operators_2[i]);
					if (opertorSame) {
						continue;
					}
					else 
						return false;
				}
				
				if (opertorSame) {												// 判断参与运算的运符符是否一致
					for (int i = 0; i <= curr_oper; i++) {
						read_numbers.add(numbers_1[i]);
					}
					
					for (int i = 0; i <= curr_oper; i++) {
						numberSame = numberSame && read_numbers.contains(numbers_2[i]);
						if (numberSame) {
							continue;
						}
						else 
							return false;
					}
					if (numberSame) {										   // 如果运算符一致，则判断参与运算的数字是否一致
						unit_1 = "0";
						unit_2 = "0";
						
						for (int k = curr_oper; k < numbers_1.length; k++) {
							if (k+1 < operators_1.length && k+1 < numbers_1.length) {
								unit_1 += operators_1[k+1]+numbers_1[k+1];
								unit_2 += operators_2[k+1]+numbers_2[k+1];
							}
						}
						equal = equal || equivalent(unit_1, unit_2);
					}
					else 
						return false;
				}
			}
		}
		else {				
			equal = equal || expr_1.equals(expr_2);
		}
		
		return equal;
	}
	
	public static double[] random(){				// 随机产生需要的n个数
		double[] numbers = new double[COUNT];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random()*MAX)+MIN;
		}
		
		return numbers;
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		double[] numbers = random();             //  随机产生测试数据，以便测试程序的正确性
		permutate(new double[]{}, numbers);	  //  产生排列，对每个排列，进行24点运算
		long end = System.currentTimeMillis();
		
		if (expressions.size() > 0) 			 //   判断是否有解
			for (String expr : expressions) {
				System.out.println(expr);
			}
		else {
			for (int i = 0; i < numbers.length; i++) {
				System.out.print((int)numbers[i] + "\t");
			}
			System.out.println();
			System.out.println("无解");
		}
		System.out.println("耗时: "+ (end - start)+ "ms");
	}
}
